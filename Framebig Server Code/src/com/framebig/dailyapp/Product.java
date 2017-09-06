package com.framebig.dailyapp;

import java.sql.Connection;
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

@Path("/product")
public class Product {

	private PreparedStatement preparedStatement = null;
	private Connection conn = DatabaseConnection.getDBConnection();

	@POST
	@Path("/insert")
	@Consumes(MediaType.APPLICATION_JSON)
	public String testMethod(String data) throws SQLException, JSONException {

		// @QueryParam("name") String name, @QueryParam("age") String age

		JSONObject jo = new JSONObject(data);

		String name = jo.getString("name");
		String price = jo.getString("price");
		// String sentence = jo.getString("sentence");
		// String synonyms = jo.getString("synonym");

		// INSERT INTO `product` (`name`, `price`) VALUES ('', '')

		String insertString = "insert into product(name, price)"
				+ " values(? ,? )";
		try {
			StaticValue.CONN.setAutoCommit(false);
			preparedStatement = StaticValue.CONN.prepareStatement(insertString);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, price);

			/*
			 * prdstmt.setString(3, sentence); prdstmt.setString(4, synonyms);
			 */
			preparedStatement.execute();
			StaticValue.CONN.commit();

			return StaticValue.CRUD_YES;
		} catch (SQLException ex) {
			ex.printStackTrace();
			StaticValue.CONN.close();
			return StaticValue.CRUD_NO;

		} /*
		 * else { StaticValue.CONN.close(); return StaticValue.EXIST_YES; }
		 */

	}

	/*
	 * id, company_id(fk), category_id(fk), brand_id, full_name, short_name,
	 * code, description, unit_name, weight_per_unit, dimension, standard_price,
	 * discount_amount, discount_from_date, discount_to_date, stock_status,
	 * standard_delivery_time_in_days.
	 */

	@GET
	@Path("/productlist")
	@Produces(MediaType.APPLICATION_JSON)
	public String getProductList() throws SQLException {

		JSONArray ja = new JSONArray();
		//select * from product
		String selectString = "SELECT * FROM product, product_picture WHERE product.id = product_picture.product_id";
		
		/*	SELECT * FROM product, product_picture WHERE product.id = product_picture.product_id 		*/
		
		try {

			preparedStatement = conn.prepareStatement(selectString);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				JSONObject jo = new JSONObject();
				try {
					/*
					 * jo.put("email", rs.getString(1)); jo.put("password",
					 * rs.getString(2));
					 */
					jo.put("id", rs.getString("id"));
					jo.put("full_name", rs.getString("full_name"));
					jo.put("short_name", rs.getString("short_name"));
					jo.put("description", rs.getString("description"));
					jo.put("code", rs.getString("code"));
					jo.put("stock_status", rs.getString("stock_status"));
					jo.put("standard_price", rs.getString("standard_price"));
					jo.put("weight_per_unit", rs.getString("weight_per_unit"));
					jo.put("picture_location", rs.getString("picture_location"));

				} catch (JSONException e) {

					e.printStackTrace();
				}

				ja.put(jo);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			conn.close();
		}

		JSONObject finalJObj = new JSONObject();
		try {
			finalJObj.put("productlist", ja);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ja.toString();
	}
}
