package com.java.xml.conn;


import javax.naming.*;
import javax.sql.*;
import java.sql.Connection;
import java.sql.SQLException;


public class OraclePool {

	
	private static DataSource OracleDataSource = null; //hold the database object
	private static Context context = null; //used to lookup the database connection in JBoss
	
	
	
	//Metodo para la conexion
	public static DataSource OracleConn() throws Exception {
		if (OracleDataSource != null) { 
 
			return OracleDataSource; 
		}
		
		try { 	 

			if (context == null) { 
				context = new InitialContext(); 
			} 
						
			OracleDataSource = (DataSource) context.lookup("oracle.jdbc.driver.OracleDriver"); 	
			
			//
			
		} 
		catch (Exception e) { 
				e.printStackTrace(); 
		} 
			return OracleDataSource; 		
	}
	
	protected static Connection oracleConnection() {
		Connection conn = null;
		try {
			conn = OracleConn().getConnection();
			
			return conn;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	
	
}
