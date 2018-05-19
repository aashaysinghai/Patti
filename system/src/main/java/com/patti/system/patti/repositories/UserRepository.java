package com.patti.system.patti.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mysql.jdbc.StringUtils;
import com.patti.system.exceptions.UserException;
import com.patti.system.patti.model.User;

@Repository
public class UserRepository  {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;

	public User addUser(User user) {
		
		if(!validateUser(user)) {
			 throw new UserException("User details not valid.");
		}
		
		String insertSql =  "INSERT INTO user (" +
							"name, " +
							"mobile_no, " +
							"email) " +
							"VALUES (?, ?, ?)";
		
		int row;
		try {
			row = jdbcTemplate.update(insertSql,pss -> {pss.setString(1, user.getName());
															pss.setString(2, user.getMobile_no());
															pss.setString(3, user.getEmail());});
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new UserException("User Creation Failed");
		}
		
		if(row != 1) {
			throw new UserException("Cannot create user");
		}
		user.setUser_id(getUserId(user));
		return user;
	}	
	
	private int getUserId(User user) {
		String query = "select user_id from user where mobile_no = "+user.getMobile_no();
		Integer userId;
		try {
			userId = jdbcTemplate.queryForObject(query,Integer.class);
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new UserException("User does not exist");
		}
		return userId;
	}

	private boolean validateUser(User user) {
		if(user == null)
			return false;
		if(StringUtils.isEmptyOrWhitespaceOnly(user.getName()) || StringUtils.isEmptyOrWhitespaceOnly(user.getEmail()) || StringUtils.isEmptyOrWhitespaceOnly(user.getMobile_no()))
			return false;
		if(user.getMobile_no().length() != 10) 
			return false;
		
		return true;
	}
	
	public User getUser(int userId) {
		String query = "select * from user where user_id = "+userId;
		User user;
		try {
			user = (User) jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper(User.class));
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new UserException("Cannot found user");
		}
		
		return user;
		
	}
}
