package com.social.executors;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.social.beans.User;
import com.social.connections.DbHelper;
import com.social.connections.Delete;
import com.social.connections.Insert;
import com.social.connections.Query;
import com.social.connections.Select;
import com.social.connections.Update;

public class FriendsServiceExecutor {
	Connection connection;
	ResultSet rs = null;
	User user;
	
	public String getMembersServiceExecutor(String id) throws Exception{
		DbHelper db = new DbHelper();
		Select helper = new Select();
		List<User> userList = new ArrayList<User>();
		connection = db.open();
		rs = helper.selectWithParams(Query.worldMembers, connection, id);
		if(rs!=null){
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
			userList.add(user);			
			
		}
		Gson json = new Gson();
		String userListString = json.toJson(userList);
		return userListString;
		
		}
		
		return "0";
		
	}
	
	public String sendRequestServiceExecutor(String uid, String fid, String status ) throws Exception{
		int flag = 0;
		DbHelper db = new DbHelper();
		Insert helper = new Insert();
		connection = db.open();
		flag = helper.insert(Query.sendRequest, connection, uid, fid, status);
		if(flag>0){
			int flagFriend = helper.insert(Query.sendRequest, connection, fid, uid, "P");
			System.out.println("Inserted to friendTable "+flagFriend);
			
			return Integer.toString(flagFriend);
		}
		
		return "false";
		
	}
	
	
	public String myFriendsServiceExecutor(String id) throws Exception{
		DbHelper db = new DbHelper();
		Select helper = new Select();
		List<User> userList = new ArrayList<User>();
		connection = db.open();
		rs = helper.selectWithParams(Query.myFriends, connection, id);
		if(rs!=null){
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
			userList.add(user);			
			
		}
		Gson json = new Gson();
		String userListString = json.toJson(userList);
		return userListString;
		
		}
		
		return "0";
		
		
	}
	
	public String deleteFriendServiceExecutor(String uid, String fid) throws Exception{
		int flag = 0;
		DbHelper db = new DbHelper();
		Delete helper = new Delete();
		connection = db.open();
		flag = helper.deleteItem(Query.deleteFriend, connection, uid, fid);
		if(flag>0){
			int flagFriend = helper.deleteItem(Query.deleteFriend, connection, fid, uid);
			System.out.println("Inserted to friendTable "+flagFriend);
			
			return Integer.toString(flagFriend);
		}
		
		return "false";
		
	}
	
	public String activeRequestServiceExecutor(String id) throws Exception{
		DbHelper db = new DbHelper();
		Select helper = new Select();
		List<User> friendList = new ArrayList<User>();
		connection = db.open();
		rs = helper.selectWithParams(Query.activeFriendRequest, connection, id);
		if(rs!=null){
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
			friendList.add(user);			
			
		}
		Gson json = new Gson();
		String friendListString = json.toJson(friendList);
		System.out.println(friendListString);
		return friendListString;
		
		}
		
		return "0";
		
		
	}
	
	
	public String acceptRequestServiceExecutor(String uid, String fid) throws Exception{
		int flag = 0;
		DbHelper db = new DbHelper();
		Update helper = new Update();
		connection = db.open();
		flag = helper.update(Query.updateFriendLink, connection, uid, fid);
		if(flag>0){
			int flagFriend = helper.update(Query.updateFriendLink, connection, fid, uid);
			System.out.println("Updated friendTable "+flagFriend);
			
			return Integer.toString(flagFriend);
		}
		
		return "0";
		
	}
	

}
