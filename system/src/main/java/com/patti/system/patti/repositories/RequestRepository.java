package com.patti.system.patti.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.patti.system.exceptions.UserException;
import com.patti.system.patti.model.Patti;
import com.patti.system.patti.model.PattiRequest;
import static com.patti.system.util.QueryUtil.*;

@Repository
public class RequestRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void serveRequest(PattiRequest pattiRequest, Patti patti) {
		//TODO before inserting validate user id and patti_id 
		// when the status becomes three then only attach user to patti after confirmation....
		int status;
		//TODO put status according to some validation from the request origin...
		if("ADMIN".equals(pattiRequest.getOrigin())) {
			status = 1;
		}
		else {
			status = 2;
		}
			
		try {
			jdbcTemplate.update(REQUEST_INSERT,pss -> {pss.setInt(1,patti.getP_id());
											  pss.setInt(2,pattiRequest.getUser_id());
											  pss.setString(3,pattiRequest.getOrigin());
											  pss.setInt(4, status);} );
		} catch (DataAccessException e) {
			e.printStackTrace();
			throw new UserException("Request Register exception Exception");
		}
		
	}

	public void verifyRequest(PattiRequest pattiRequest) {
		String query = "";
		
	}
}
