package com.aadharapi.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.aadharapi.service.AadharApiLogs;
import com.aadharapi.service.AadharService;
import com.aadharapi.utils.AadharRequest;
import com.aadharapi.utils.PropertiesConfig;
import com.google.gson.Gson;

@Service
public class AadharServiceImpl implements AadharService {

	@Autowired
	PropertiesConfig propertiesConfig;

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	AadharApiLogs aadharApiLogs;

	@Override
	public String fetchAatharVerification(AadharRequest aadharRequest) {

		long timeStamp = System.currentTimeMillis();
		String apiName = "api-preproduction.signzy.app/api/v3/aadhaar/basicVerify";
		String requestPacket = null;
		String Response = null;
		try {
			Gson gson = new Gson();
			requestPacket = gson.toJson(aadharRequest);

			HttpHeaders headers = new HttpHeaders();
			headers.set("Authorization", propertiesConfig.getAatharTocken());
			headers.set("Content-Type", "application/json");

			HttpEntity<String> requestEntity = new HttpEntity(aadharRequest, headers);
			Response = restTemplate.postForObject(propertiesConfig.getAatharUrl(), requestEntity, String.class);
			aadharApiLogs.saveAAdharApiLogs(requestPacket, Response, apiName, timeStamp);
		} catch (Exception e) {
			e.printStackTrace();
			Response = e.getMessage();
			aadharApiLogs.saveAAdharApiLogs(requestPacket, Response, apiName, timeStamp);
			return Response;
		}
		return Response;
	}

}
