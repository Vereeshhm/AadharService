package com.aadharapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aadharapi.service.AadharService;
import com.aadharapi.utils.AadharRequest;

@RestController
@RequestMapping("/saswat")
public class AadharContoller {
	
	@Autowired
	AadharService aadharService;
	
	@PostMapping(value = "/aathar_verification", produces = MediaType.APPLICATION_JSON_VALUE)
	public String getAatharVerification(@RequestBody AadharRequest aadharRequest) {
		return aadharService.fetchAatharVerification(aadharRequest);
		
	}

}
