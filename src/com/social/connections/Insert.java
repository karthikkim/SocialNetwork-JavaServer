package com.social.connections;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Insert {
	ResultSet rs ;
	
	public ResultSet insertAndGetId(String Query, Connection c, String ...params){
		PreparedStatement stmt = null;
		
		try {
			stmt = c.prepareStatement(Query, PreparedStatement.RETURN_GENERATED_KEYS);
			for(int i =0; i<params.length; i++){
			  stmt.setString(i+1,params[i]); 
			}
			stmt.executeUpdate();
			 rs = stmt.getGeneratedKeys();
			 
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	
	public int insert(String Query, Connection c, String ...params){
		PreparedStatement stmt = null;
		int code = 0;
		try {
			stmt = c.prepareStatement(Query, PreparedStatement.RETURN_GENERATED_KEYS);
			for(int i =0; i<params.length; i++){
			  stmt.setString(i+1,params[i]); 
			}
			 code = stmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return code;
	}

}
