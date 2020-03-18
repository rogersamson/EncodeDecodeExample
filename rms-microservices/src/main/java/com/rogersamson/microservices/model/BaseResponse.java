package com.rogersamson.microservices.model;

import lombok.Data;

@Data
public class BaseResponse {
	private String message;
	private String encodedFile ;
}
