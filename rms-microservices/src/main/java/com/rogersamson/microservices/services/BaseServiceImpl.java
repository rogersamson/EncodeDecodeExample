package com.rogersamson.microservices.services;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rogersamson.microservices.utilities.FileDecoder;
import com.rogersamson.microservices.utilities.FileEncoder;

@Component
public class BaseServiceImpl implements BaseService {
	private String mpCryptoPassword = "RMSGerLan$";
	
	@Autowired
	private FileEncoder fileEncoder;
	
	@Autowired
	private FileDecoder fileDecoder;
		
	@Override
	public String encodeFile(String source)  {
		fileEncoder.setMpCryptoPassword(mpCryptoPassword);
		String target = null;
		try {
			target = fileEncoder.encodeFileToBase64Binary(source);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return target;
	}


	@Override
	public void decodeToFile(String fileLoc, String source) {	
		fileDecoder.setMpCryptoPassword(mpCryptoPassword);
		 try {
			fileDecoder.decodeBase64BinaryToFile(fileLoc,source);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

}
