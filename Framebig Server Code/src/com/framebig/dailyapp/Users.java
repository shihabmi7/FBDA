package com.framebig.dailyapp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.mdf.dbconn.DatabaseConnection;
import com.mdf.utility.StaticValue;

import java.sql.Connection;

@Path("/user")
public class Users {
	private PreparedStatement prdstmt = null;
	private Connection conn = DatabaseConnection.getDBConnection();

	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
	public String login(String loginData) throws SQLException {
		JSONObject jo;
		String emailId = null, password = null;
		try {
			jo = new JSONObject(loginData);
			emailId = jo.getString("email");
			password = jo.getString("password");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String selectString = "select * from registration where email=? and password=?";
		try {
			prdstmt = conn.prepareStatement(selectString);
			prdstmt.setString(1, emailId);
			prdstmt.setString(2, password);

			ResultSet rs = prdstmt.executeQuery();
			while (rs.next()) {
				// dbConn.dbConnClose();
				return StaticValue.SUCCESS;
			}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
			;
		} finally {
			conn.close();
		}

		return StaticValue.FAILED;

	}

	@POST
	@Path("/registration")
	@Consumes(MediaType.APPLICATION_JSON)
	public String registration(String registrationData) throws SQLException {
		JSONObject jo;
		System.out.println(registrationData);
		String emailId = null, password = null;
		try {
			jo = new JSONObject(registrationData);
			emailId = jo.getString("email");
			password = jo.getString("password");

			System.out.println("got this: " + emailId);

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (checkExistingEmailID(emailId))
			return StaticValue.EXIST_YES;

		String insertString = "insert into registration(email, password)"
				+ " values(? ,?)";
		try {
			conn.setAutoCommit(false);
			prdstmt = conn.prepareStatement(insertString);
			prdstmt.setString(1, emailId);
			prdstmt.setString(2, password);
			prdstmt.execute();
			conn.commit();

			return StaticValue.CRUD_YES;
		} catch (SQLException ex) {
			ex.printStackTrace();
			return StaticValue.CRUD_NO;
		} finally {
			conn.close();
			System.out.println("Registration Service is being called");
		}

	}

	private boolean checkExistingEmailID(String emailID) {

		String selectString = "select * from registration where email=?";
		try {
			prdstmt = conn.prepareStatement(selectString);
			prdstmt.setString(1, emailID);

			ResultSet rs = prdstmt.executeQuery();
			while (rs.next()) {
				return true;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			;
		}
		return false;
	}

	@GET
	@Path("/userlist")
	@Produces(MediaType.APPLICATION_JSON)
	public String userList() throws SQLException {

		JSONArray ja = new JSONArray();

		String selectString = "select email, password from registration";
		try {
			
			prdstmt = conn.prepareStatement(selectString);
			ResultSet rs = prdstmt.executeQuery();

			while (rs.next()) {
				JSONObject jo = new JSONObject();
				try {
					jo.put("email", rs.getString(1));
					jo.put("password", rs.getString(2));
				} catch (JSONException e) {
					 
					e.printStackTrace();
				}

				ja.put(jo);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			conn.close();
			;
		}

		JSONObject finalJO = new JSONObject();
		try {
			finalJO.put("userlist", ja);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ja.toString();
	}

}
