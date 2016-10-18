package com.java.xml.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexioDB {

	public Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@EDM9000:1540:desa10", "br", "desa");
		} catch(ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		} catch(SQLException sql) {
			sql.printStackTrace();
		}
		return conn;
	}
}
