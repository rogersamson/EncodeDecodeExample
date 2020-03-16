package com.rogersamson.apiclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MyMain {

	public static void main(String[] args) {
	String mpCryptoPassword = "RMSGerLan$";

   	 try {

			URL url = new URL("http://localhost:8081/api/v1/rms/fetch-data");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader(
				(conn.getInputStream())));

			String output;
			
			System.out.println("Output from Server .... \n");
			String json = "";
			while ((output = br.readLine()) != null) {
				json+=output;				
			}
			ObjectMapper mapper = new ObjectMapper();
			BaseResponse response = mapper.readValue(json, BaseResponse.class);             
	        FileDecoder  fd= new  FileDecoder();
			fd.setMpCryptoPassword(mpCryptoPassword);
			fd.decodeBase64BinaryToFile("C:\\RMS TEST\\RMSclient.crt", response.getEncodedFile());
	        
			

			conn.disconnect();

		  } catch (MalformedURLException e) {

			e.printStackTrace();

		  } catch (IOException e) {

			e.printStackTrace();

		  }


	}

}
