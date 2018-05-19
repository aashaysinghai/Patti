package com.patti.system;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.patti.system.patti.model.Patti;


public class Dummy {
	
	public static void main(String[] args) throws JsonProcessingException {
		Patti patti = new Patti();
		ObjectMapper mapper = new ObjectMapper();
		String ans = mapper.writeValueAsString(patti);
		System.out.println(ans);
	}
	
}
