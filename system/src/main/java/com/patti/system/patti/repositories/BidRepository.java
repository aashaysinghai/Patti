package com.patti.system.patti.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.patti.system.exceptions.UserException;
import com.patti.system.patti.controllers.PattiController;
import com.patti.system.patti.model.Patti;
import com.patti.system.patti.model.PattiBid;
import com.patti.system.patti.model.PattiCycle;

@Repository
public class BidRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	PattiController pattiController;

	public void bid(PattiBid bid) {
		int p_id = bid.getP_id();
		Patti patti = pattiController.findPatti(p_id);
		int curr_month = patti.getCurr_month();
		String bidQuery = "select * from patti_cycle where patti_id = ? and month_id = ?";
		try {
			PattiCycle pattiCycle = (PattiCycle) jdbcTemplate.queryForObject(bidQuery, new Object[] {p_id,curr_month},new BeanPropertyRowMapper(PattiCycle.class));
			if(pattiCycle == null) {
				// first bid so we should insert..
				String insertQuery = "INSERT INTO patti_cycle (patti_id,month_id,highest_bid,highest_bidder) VALUES (?,?,?,?)";
				jdbcTemplate.update(insertQuery,pss-> {
					pss.setInt(1,bid.getP_id());
					pss.setInt(2, curr_month);
					pss.setInt(3, bid.getUser_d());
					pss.setInt(4, bid.getBid_amount());
				} );
			}
			else {
				// check for the previous highest bid..
				int highestBid = pattiCycle.getHighest_bid();
				if(bid.getBid_amount() > highestBid) {
					// then only update an entry in a table and send notification to all users of patti regarding the updation of patti's new bid for that month.
					String updateBidQuery = "update patti_cycle set highest_bid = ? ,highest_bidder = ? where patti_id = ? and month_id = ?";
					jdbcTemplate.update(updateBidQuery,pss -> {
						pss.setInt(1, bid.getBid_amount());
						pss.setInt(2, bid.getUser_d());
						pss.setInt(3,bid.getP_id());
						pss.setInt(4, curr_month);
					});
				}
				else {
					// tell the user to bid for high amount...or this condition can be checked in front end also but can double check also..
				}
			}
		}
		catch(DataAccessException e) {
			e.printStackTrace();
			throw new UserException("Error finding Patti Cycle .");
		}
		
	}
}
