package com.rogersamson.baseclient.services;

import org.springframework.stereotype.Service;

import com.rogersamson.baseclient.model.BaseResponse;

@Service
public interface BaseClientService {
	
	BaseResponse fetchRemoteData();
	

}
