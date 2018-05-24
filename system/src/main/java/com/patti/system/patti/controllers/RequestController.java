package com.patti.system.patti.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patti.system.patti.model.Patti;
import com.patti.system.patti.model.PattiRequest;
import com.patti.system.patti.repositories.RequestRepository;

@RestController
@RequestMapping("/pattiRequest")
public class RequestController {
	
	@Autowired
	private PattiController pattiController;
	@Autowired
	private RequestRepository requestRepository;
	
	@PostMapping
	public void servePattiRequest(@RequestBody PattiRequest pattiRequest) {
		int patti_id = pattiRequest.getP_id();
		Patti patti = pattiController.findPatti(patti_id);
		requestRepository.serveRequest(pattiRequest,patti);
	}
	
	@RequestMapping("/verify")
	@GetMapping
	public void verifyPattiRequest(@RequestBody PattiRequest pattiRequest) {
		requestRepository.verifyRequest(pattiRequest);
	}
}
