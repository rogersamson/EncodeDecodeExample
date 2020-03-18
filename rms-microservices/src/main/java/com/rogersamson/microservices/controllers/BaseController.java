package com.rogersamson.microservices.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rogersamson.microservices.model.BaseResponse;
import com.rogersamson.microservices.services.BaseService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/rms")
public class BaseController {
	
	@Autowired
	private BaseService baseService;
	
	@GetMapping("/fetch-data")
	public BaseResponse fetchData() {
		BaseResponse response = new BaseResponse();
		response.setMessage("HELLO ROGER");
		try {
			response.setEncodedFile(baseService.encodeFile("D:/MyWebExample.zip") );
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

}
;