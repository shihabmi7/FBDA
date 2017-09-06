package com.framebig.dailyapp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import org.json.JSONException;
import org.json.JSONObject;

import com.mdf.utility.StaticValue;

@Path("/vocabulary")
public class Vocabulary {
	private PreparedStatement prdstmt = null;
	
	
	@POST
	@Path("/insert")
	@Consumes(MediaType.APPLICATION_JSON)
	public String testMethod(String data) throws SQLException, JSONException{ //@QueryParam("name") String name, @QueryParam("age") String age	
		
		JSONObject jo = new JSONObject(data);
		
		String germanWord = jo.getString("german");
		String englishWord = jo.getString("english");
		String sentence = jo.getString("sentence");
		String synonyms = jo.getString("synonym");		
		
		if(!checkVocabulary(germanWord)){
			String insertString = "insert into vocabulary(german, english, sentences, synonyms)"
					+ " values(? ,? ,? ,?)";
			try {
				StaticValue.CONN.setAutoCommit(false);
				prdstmt = StaticValue.CONN.prepareStatement(insertString);
				prdstmt.setString(1, germanWord);
				prdstmt.setString(2, englishWord);
				prdstmt.setString(3, sentence);
				prdstmt.setString(4, synonyms);
				prdstmt.execute();
				StaticValue.CONN.commit();
				
				return StaticValue.CRUD_YES;
			} catch (SQLException ex) {
				ex.printStackTrace();
				StaticValue.CONN.close();
				return StaticValue.CRUD_NO;
			}
		} else {
			StaticValue.CONN.close();
			return StaticValue.EXIST_YES;
		}

	}
	
	
	private boolean checkVocabulary(String german) {
		System.out.println("German:"+german);
		System.out.println("Conn:"+StaticValue.CONN);
		
		String selectString = "select * from vocabulary where german=?";
		try {
			prdstmt = StaticValue.CONN.prepareStatement(selectString);
			prdstmt.setString(1, german);
			ResultSet rs = prdstmt.executeQuery();
			while (rs.next()) {
				// dbConn.dbConnClose();
				return true;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();;
		}
		// dbConn.dbConnClose();
		return false;
	}
}
