package com.rogersamson.baseclient.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.rogersamson.baseclient.model.BaseResponse;

@Service
@FeignClient(name="rms-microservices", url="http://localhost:8081/api/v1/rms")
public interface BaseClientInterface {

	@GetMapping("/fetch-data")
	public BaseResponse fetchData() ;
}
