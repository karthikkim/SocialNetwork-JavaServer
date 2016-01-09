package com.social.webservices;

import javax.jws.WebService;

import com.social.executors.ProfileServiceExecutor;

@WebService
public class Profile {
	ProfileServiceExecutor helper = new ProfileServiceExecutor();
	public String getProfileService(String id){
		String userDetails = null;
		try {
			 userDetails = helper.getProfileServiceExecutor(id);
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return  userDetails;
		
		
	}
	
	public String postStatusService(String uid, String message, String record_time){
		String status = null;
		
		try {
			status = helper.postStatusServiceExecutor(uid, message, record_time);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status;
	}
	
	public String getStatusService(String uid){
		String status = null;
		System.out.println("Got request"+uid);
		try {
			status = helper.getStatusServiceExecutor(uid);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status;
	}
}
