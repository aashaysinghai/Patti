package com.patti.system;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.patti.system.patti.model.PattiBid;
import com.patti.system.patti.model.PattiRequest;


public class Dummy {
	
	public static void main(String[] args) throws JsonProcessingException {
		PattiBid patti = new PattiBid();
		ObjectMapper mapper = new ObjectMapper();
		String ans = mapper.writeValueAsString(patti);
		System.out.println(ans);
	}
	
}
