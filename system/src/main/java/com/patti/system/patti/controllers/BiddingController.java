package com.patti.system.patti.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patti.system.patti.model.PattiBid;
import com.patti.system.patti.repositories.BidRepository;

@RequestMapping("/bid")
@RestController
public class BiddingController {
	@Autowired
	BidRepository bidRepo;
	
	@PostMapping
	public void bid(@RequestBody PattiBid bid) {
		bidRepo.bid(bid);
	}
	
}
