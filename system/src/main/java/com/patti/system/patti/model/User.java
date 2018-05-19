package com.patti.system.patti.model;

public class User {
	private int user_id;
	private String name;
	private String mobile_no;
	private String email;
	private String address;
	
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile_no() {
		return mobile_no;
	}
	public void setMobile_no(String mobile_no) {
		this.mobile_no = mobile_no;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", name=" + name + ", mobile_no=" + mobile_no + ", email=" + email
				+ ", address=" + address + "]";
	}
	
	
}
