package com.rogersamson.microservices.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class FileEncoder {
	private String mpCryptoPassword;
	
	public String encodeFileToBase64Binary(String fileName) throws IOException {

	    File file = new File(fileName);
	    byte[] bytes = loadFile(file);
	    byte[] encoded = Base64.getEncoder().encode(bytes);
	    String encodedString = new String(encoded,StandardCharsets.US_ASCII);

	    return encrypString(encodedString);
	}
	
	public byte[] loadFile(File file) throws IOException {
	    InputStream is = new FileInputStream(file);

	    long length = file.length();
	    if (length > Integer.MAX_VALUE) {
	        // File is too large
	    }
	    byte[] bytes = new byte[(int)length];

	    int offset = 0;
	    int numRead = 0;
	    while (offset < bytes.length
	           && (numRead=is.read(bytes, offset, bytes.length-offset)) >= 0) {
	        offset += numRead;
	    }

	    if (offset < bytes.length) {
	        throw new IOException("Could not completely read file "+file.getName());
	    }

	    is.close();
	    return bytes;
	}
	
	
	private String encrypString(String source) {
		 StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();
	     encryptor.setPassword(mpCryptoPassword);
	     return  encryptor.encrypt(source);
	}

}
