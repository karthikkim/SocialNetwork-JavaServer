package com.social.executors;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.social.beans.Status;
import com.social.beans.User;
import com.social.connections.DbHelper;
import com.social.connections.Insert;
import com.social.connections.Query;
import com.social.connections.Select;

public class ProfileServiceExecutor {
	Connection connection;
	ResultSet rs = null;
	User user;
	
	public String getProfileServiceExecutor(String id) throws Exception{
		
		DbHelper db = new DbHelper();
		Select helper = new Select();
		connection = db.open();
		rs = helper.selectWithParams(Query.getProfileData, connection, id);
		
		while(rs.next()){
			user = new User();
			user.setId(rs.getInt(1));
			user.setFirstname(rs.getString(2));
			user.setLastname(rs.getString(3));
			user.setEmail(rs.getString(4));
			user.setDob(rs.getString(6));
			user.setSex(rs.getString(7));
			user.setValid(rs.getString(8));
			user.setAbout(rs.getString(9));
			user.setEducation(rs.getString(11));
			user.setWork(rs.getString(12));
			user.setRelationship(rs.getString(13));
			user.setInterest(rs.getString(14));
			
			
		}
		
		Gson json = new Gson();
		String details = json.toJson(user);
		return details;
	}
	
	
	public String postStatusServiceExecutor(String...params) throws Exception{
		
		DbHelper db = new DbHelper();
		Insert helper = new Insert();
		connection = db.open();
		int number = helper.insert(Query.postStatus, connection, params);
		
		return Integer.toString(number);
		
	}

	public String getStatusServiceExecutor(String id) throws Exception{
		
		DbHelper db = new DbHelper();
		Select helper = new Select();
		Status localBean;
		List<Status> statusList = new ArrayList<Status>();
		connection = db.open();
		rs = helper.selectWithParams(Query.getStatus, connection, id);
		
		if(rs!= null){
			while(rs.next()){
				localBean = new Status();
				localBean.setMessage(rs.getString(1));
				localBean.setId(rs.getInt(2));
				localBean.setPid(rs.getInt(3));
				localBean.setRecord_time(rs.getString(4));
				localBean.setFirstname(rs.getString(5));
				localBean.setLastname(rs.getString(6));
				statusList.add(localBean);
				
			}
			Gson json = new Gson();
			String statusString = json.toJson(statusList);
			return statusString;
		}
			return "Null";
		
	}
}
