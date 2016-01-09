package com.social.connections;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;

public class Select {
	ResultSet rs ;

	public ResultSet selectWithoutParams(String Query, Connection c)
	{
		
		PreparedStatement stmt = null;
		
		try {
			
			stmt = c.prepareStatement(Query);				
			rs = stmt.executeQuery();
		
		  
	}
		catch(Exception e){
		
		}
		
		
		return rs;
		
		
}
	
	public ResultSet selectWithParams(String Query, Connection c, Object... a)
	{
		
		PreparedStatement stmt = null;
		
		try {
			
			System.out.println("Query is "+Query);
			stmt = c.prepareStatement(Query);
			for(int i = 0 ; i<a.length; i++){
		if(a[i] instanceof Date){
			stmt.setDate(i+1, (java.sql.Date) a[i]);
		}else if(a[i] instanceof Integer){
			stmt.setInt(i+1, (Integer)a[i]);
			
		}else{ 
			stmt.setString(i+1, (String)a[i]);
			//System.out.println(a[i]);
			
		}
		}
			rs = stmt.executeQuery();
	
		}
		
		
		catch(Exception e){
		
		}
				
		return rs;
		
		
}
}