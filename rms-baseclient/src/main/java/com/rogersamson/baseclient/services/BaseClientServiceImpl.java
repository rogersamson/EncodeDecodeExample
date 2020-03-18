package com.rogersamson.baseclient.services;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rogersamson.baseclient.model.BaseResponse;
import com.rogersamson.baseclient.remote.BaseClientInterface;
import com.rogersamson.baseclient.utilities.FileDecoder;

@Component
public class BaseClientServiceImpl implements BaseClientService {


	private String mpCryptoPassword = "RMSGerLan$";
	
	@Autowired
	private BaseClientInterface client;
	
	@Autowired
	private FileDecoder fileDecoder;
		
	@Override
	public BaseResponse fetchRemoteData() {
		BaseResponse result = client.fetchData();
		
		try {
			fileDecoder.setMpCryptoPassword(mpCryptoPassword);
			fileDecoder.decodeBase64BinaryToFile("C:/RMS TEST/ClientFIle.crt", result.getEncodedFile());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
