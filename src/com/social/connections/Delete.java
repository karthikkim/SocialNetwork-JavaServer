package com.social.connections;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Delete {
	
	public int deleteItem(String Query, Connection c, String ...params){
		PreparedStatement stmt = null;
		int code = 0;
		try {
			stmt = c.prepareStatement(Query);
			for(int i =0; i<params.length; i++){
			  stmt.setString(i+1,params[i]); 
			}
			 code = stmt.executeUpdate();
			 System.out.println("Delete friendlink.");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return code;
	}

}
