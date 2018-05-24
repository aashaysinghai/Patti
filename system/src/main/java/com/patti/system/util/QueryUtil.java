package com.patti.system.util;

public class QueryUtil {
	public static final String USER_INSERT =  "INSERT INTO user (" +
			"name, " +
			"mobile_no, " +
			"email) " +
			"VALUES (?, ?, ?)";
	
	public static final String PATTI_INSERT = "INSERT INTO patti (" +
		  	"	start_date, " +
		  	"	amount_per_head, " +
			"	open_day_month, " +
			"	admin_user, " +
			"	patti_type, " +
			"	min_bid, " +
			"	no_users, " +
			"	is_open, " +
			"	curr_month) " +
			  "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	public static final String REQUEST_INSERT = "INSERT INTO patti_request(p_id,user_id,request_origin,verification_status) values(?,?,?,?)";
}
