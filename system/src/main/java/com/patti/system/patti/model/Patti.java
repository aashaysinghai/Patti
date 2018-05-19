package com.patti.system.patti.model;

import java.sql.Date;

public class Patti {
	private int  p_id;
	private String start_date;
	private int amount_per_head;
	private int open_day_month;
	private int admin_user;
	private int patti_type;
	private int min_bid;
	private int no_users;
	private boolean is_open;
	private int curr_month;
	public int getP_id() {
		return p_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public int getAmount_per_head() {
		return amount_per_head;
	}
	public void setAmount_per_head(int amount_per_head) {
		this.amount_per_head = amount_per_head;
	}
	public int getOpen_day_month() {
		return open_day_month;
	}
	public void setOpen_day_month(int open_day_month) {
		this.open_day_month = open_day_month;
	}
	public int getAdmin_user() {
		return admin_user;
	}
	public void setAdmin_user(int admin_user) {
		this.admin_user = admin_user;
	}
	public int getMin_bid() {
		return min_bid;
	}
	public void setMin_bid(int min_bid) {
		this.min_bid = min_bid;
	}
	public int getNo_users() {
		return no_users;
	}
	public void setNo_users(int no_users) {
		this.no_users = no_users;
	}
	public boolean isIs_open() {
		return is_open;
	}
	public void setIs_open(boolean is_open) {
		this.is_open = is_open;
	}
	public int getCurr_month() {
		return curr_month;
	}
	public void setCurr_month(int curr_month) {
		this.curr_month = curr_month;
	}
	public int getPatti_type() {
		return patti_type;
	}
	public void setPatti_type(int patti_type) {
		this.patti_type = patti_type;
	}
	
}
