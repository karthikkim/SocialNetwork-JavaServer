package com.social.webservices;

import javax.jws.WebService;

import com.social.executors.IndexServiceExecutor;

@WebService
public class Index {
	IndexServiceExecutor helper = new IndexServiceExecutor();
		public String loginService(String username, String password){
		try {
			String userDetails = helper.loginServiceExecutor(username, password);
			System.out.println(userDetails);
			return userDetails;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			
		}
			
			return "false";	
		}
		
		public String registerService(String firstname, String lastname, String email, String password, String dob, String sex){
			String result = null;
			try {
				result = helper.registerServiceExecutor(firstname, lastname, email, password, dob, sex);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return result;
			
		}
		
		
		public String updateService(String about, String interest, String education, String work, String relationship, String id){
			
			String result = null;
			try {
				result = helper.updateServiceExecutor(about, interest, education, work, relationship, id);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return result;
		}

}
