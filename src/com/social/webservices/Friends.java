package com.social.webservices;

import javax.jws.WebService;

import com.social.executors.FriendsServiceExecutor;

@WebService
public class Friends {
	FriendsServiceExecutor helper = new FriendsServiceExecutor();
	
	public String getMembersService(String id){
		String worldMembers = "0";
		try {
			 worldMembers = helper.getMembersServiceExecutor(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return worldMembers;
	}
	
	
	public String sendRequestService(String uid, String fid, String status){
		String returnStatus = null;
		
		try {
			returnStatus = helper.sendRequestServiceExecutor(uid, fid, status);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return returnStatus;
	}
	
	public String myFriendsService(String id){
		String myFriends = "0";
		try {
			myFriends = helper.myFriendsServiceExecutor(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return myFriends;
	}
	
	public String deleteFriendService(String uid, String fid){
		String deleteFriend ="0";
		
		try {
			deleteFriend = helper.deleteFriendServiceExecutor(uid, fid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return deleteFriend;
	}
	
	public String activeRequestService(String id){
		String activeRequest = "0";
		
		try {
			activeRequest = helper.activeRequestServiceExecutor(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return activeRequest;
	}
	
	public String acceptRequestService(String uid, String fid){
		String acceptRequest = "0";
		
		try {
			acceptRequest = helper.acceptRequestServiceExecutor(uid, fid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return acceptRequest;
	}

}
