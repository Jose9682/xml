package com.java.xml.status;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.sql.*;
import com.java.xml.conn.*;


@Path("/v1/status")
public class V1_status {

	
	
	
	@Path("/database")
	@GET
	@Produces(MediaType.TEXT_HTML)
	public String returnDatabaseStatus() throws Exception {
		
		PreparedStatement query = null;
		String myString = null;
		String returnString = null;
		Connection conn = null;
		
		try {
			
			//conn = OraclePool.OracleConn().getConnection();                                                    //              Oracle308tubeConn().getConnection(); //calls the method defined in the Oracle308tube package
		conn = new ConexioDB().getConnection();
			//simple sql query to return the date/time
			query = conn.prepareStatement("select to_char(sysdate,'YYYY-MM-DD HH24:MI:SS') DATETIME " +
					"from sys.dual");
			
			//query = conn.prepareStatement("select nombre from jm.LOGIN");
			
			ResultSet rs = query.executeQuery();
			
			//loops through the results and save it into myString
			while (rs.next()) {
				// /*Debug*/ System.out.println(rs.getString("DATETIME"));
				myString = rs.getString("DATETIME");
				//myString = rs.getString("NOMBRE");
			}
			
			query.close(); //close connection
			
			returnString = "<p>Database Status</p> " +
				"<p>Database Date/Time return: " + myString + "</p>";
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		/**
		 * The finally cause will always run. Even if the the method get a error.
		 * You want to make sure the connection to the database is closed.
		 */
		finally {
			if (conn != null) conn.close();
		}
		
		return returnString; 
	}
}
