package com.patti.system.patti.repositories;
import static com.patti.system.util.QueryUtil.*;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.patti.system.exceptions.UserException;
import com.patti.system.patti.model.Patti;

@Repository
public class PattiRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public  Patti createPatti(Patti patti) {
		
		int row;
		try {
			row = jdbcTemplate.update(PATTI_INSERT,pss -> {
									    pss.setDate(1,Date.valueOf(LocalDate.now()));
										pss.setInt(2, patti.getAmount_per_head());
										pss.setInt(3, patti.getOpen_day_month());
										pss.setInt(4, patti.getAdmin_user());
										pss.setInt(5, patti.getPatti_type());
										pss.setInt(6, patti.getMin_bid());
										pss.setInt(7,patti.getNo_users());
										pss.setBoolean(8, false); // should always be false and become true when we call start patti..
										pss.setInt(9, 0);}); // while starting it is 0 , when we call start patti we make it as 1 and goes till no. of users month
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new UserException("Patti Creation Exception");
		}
		
		return patti;
	}

	public Patti findPattiById(int patti_id) {
		String query = "select * from patti where p_id = "+patti_id;
		Patti patti;
		try {
			patti = (Patti) jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper(Patti.class));
		} catch (DataAccessException e) {
			throw new UserException("Patti not found");
		}
		return patti;
	}

	public void startPatti(int patti_id) {
		String query = "update patti set is_open = 1, curr_month = 1 where p_id = ?";
		try {
			jdbcTemplate.update(query, pss ->pss.setInt(1, patti_id));
		}
		 catch (DataAccessException e) {
				throw new UserException("Patti fail to get started..");
		}
	}
	
}
