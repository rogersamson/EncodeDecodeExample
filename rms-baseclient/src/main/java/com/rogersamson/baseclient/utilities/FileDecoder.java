package com.rogersamson.baseclient.utilities;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class FileDecoder {
	
	private String mpCryptoPassword;
	
	public void decodeBase64BinaryToFile(String saveLoc , String source) throws IOException {
		Path path = Paths.get(saveLoc);
	    Files.write(path, Base64.getDecoder().decode( decryptString(source)));
	}
	
	private String decryptString(String source) {
        StandardPBEStringEncryptor decryptor = new StandardPBEStringEncryptor();
        decryptor.setPassword(mpCryptoPassword);
        return decryptor.decrypt(source);

	}
}
