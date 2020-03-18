package com.rogersamson.microservices.services;

import org.springframework.stereotype.Service;

@Service
public interface BaseService {
	String encodeFile(String fileName);
	void decodeToFile(String fileLoc, String source);
}
