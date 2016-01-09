package com.social.connections;

public class Query {
	
	public static String login = "SELECT id, firstname, lastname FROM MOBILE_USERS WHERE EMAIL=? AND PASSWORD=?";
	public static String register ="INSERT INTO MOBILE_USERS (FIRSTNAME, LASTNAME, EMAIL, PASSWORD, DOB, SEX) VALUES(?,?,?,?,?,?)";
	public static String friendInsert ="INSERT INTO FRIEND_LIST(UID, FID) VALUES(?,?)";
	public static String updateProfile = "UPDATE MOBILE_USERS SET ABOUT =?, INTEREST =?, EDUCATION =?, WORK =?, RELATIONSHIP = ? WHERE ID = ?";
	public static String getProfileData = "SELECT * FROM MOBILE_USERS WHERE ID =?";
	public static String postStatus = "INSERT INTO NEWS_FEED (UID, MESSAGE, RECORD_TIME) VALUES(?,?,?)";
	public static String getStatus = "select n.message,n.id, u.id as pid,n.record_time, u.firstname, u.lastname from news_feed n, mobile_users u  where n.uid in (select fid from friend_list where uid = ? and status like '%Y%') and u.id=n.uid order by n.id desc";
	public static String worldMembers ="select * from mobile_users where id not in (SELECT fid FROM `friend_list` where uid =?)";
	public static String sendRequest = "INSERT INTO FRIEND_LIST (UID, FID, STATUS) VALUES (?,?,?)";
	public static String myFriends ="select * from mobile_users where id in(SELECT fid FROM `friend_list` where uid =? and status  like '%Y%' and uid <> fid)";
	public static String deleteFriend ="DELETE FROM FRIEND_LIST  WHERE UID = ? AND FID = ?";
	public static String activeFriendRequest = "select * from mobile_users where id in(SELECT fid FROM `friend_list` where uid =? and status  like '%P%')";
	public static String updateFriendLink = "UPDATE FRIEND_LIST SET STATUS ='Y' WHERE UID = ? AND FID = ?";
}
