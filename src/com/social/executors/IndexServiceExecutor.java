package com.social.executors;

import java.sql.Connection;
import java.sql.ResultSet;

import com.google.gson.Gson;
import com.social.beans.User;
import com.social.connections.DbHelper;
import com.social.connections.Insert;
import com.social.connections.Query;
import com.social.connections.Select;
import com.social.connections.Update;


public class IndexServiceExecutor {
	Connection connection;
	ResultSet rs = null;
	User user;
	
	public String loginServiceExecutor(String username, String password) throws Exception{
		System.out.println("In Executor "+username+" "+password);
		DbHelper db = new DbHelper();
		Select helper = new Select();
		connection = db.open();
		rs = helper.selectWithParams(Query.login, connection, username, password);
		
		while(rs.next()){
			user = new User();
			user.setId(rs.getInt(1));
			user.setFirstname(rs.getString(2));
			user.setLastname(rs.getString(3));
			
		}
		
		Gson json = new Gson();
		String details = json.toJson(user);
		return details;
	}
	
	
	public String registerServiceExecutor(String...params) throws Exception{
		DbHelper db = new DbHelper();
		int number=0;
		connection = db.open();
		Insert helper = new Insert();
		rs = helper.insertAndGetId(Query.register, connection, params);
		int autoId = 0;
		if(rs!= null){
		while(rs.next()){
			autoId = rs.getInt(1);
		}
		String autoIdString = Integer.toString(autoId);
		number = helper.insert(Query.friendInsert, connection, autoIdString, autoIdString);
		System.out.println(autoId);
		return Integer.toString(number);
		}
		return "fail";
		
	}
	
	public String updateServiceExecutor(String...params) throws Exception{
		DbHelper db = new DbHelper();
		int number=0;
		connection = db.open();
		Update helper = new Update();		
		number = helper.update(Query.updateProfile,connection, params);
		
		return Integer.toString(number);
		
		
	}

}
