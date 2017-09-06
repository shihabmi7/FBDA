package com.mdf.utility;

import java.sql.Connection;

import com.mdf.dbconn.DatabaseConnection;

public class StaticValue {
	
	
	public static final String EXIST_YES="exist_yes";
	public static final String EXIST_NO="exist_no";
	public static final String CRUD_YES="crud_yes";
	public static final String CRUD_NO="crud_no";
	public static final String SUCCESS="success";
	public static final String FAILED="failed";
	
	
	public static Connection CONN = DatabaseConnection.getDBConnection();
	
	
}
