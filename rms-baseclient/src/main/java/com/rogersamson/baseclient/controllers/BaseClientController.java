package com.rogersamson.baseclient.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rogersamson.baseclient.model.BaseResponse;
import com.rogersamson.baseclient.services.BaseClientService;

@RestController
@CrossOrigin(origins = "*")
public class BaseClientController {
	
	@Autowired
	private BaseClientService baseClientService;
	
	
	@GetMapping("/test")
	public  BaseResponse test() {
		
		return baseClientService.fetchRemoteData();
		
	}

}
