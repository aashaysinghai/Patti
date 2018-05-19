package com.patti.system.patti.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patti.system.patti.model.Patti;
import com.patti.system.patti.repositories.PattiRepository;

@RequestMapping("/patti")
@RestController
public class PattiController {
	
	@Autowired
	PattiRepository pattiRepository;
	
	@PostMapping
	public Patti createPatti(@RequestBody Patti patti) {
		return pattiRepository.createPatti(patti);
	} 

	@GetMapping
	public Patti findPatti(int patti_id) {
		return pattiRepository.findPattiById(patti_id);
	}
	
}
