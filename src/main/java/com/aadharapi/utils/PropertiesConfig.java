package com.aadharapi.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("file:src/main/resources/application.properties")
public class PropertiesConfig {

	@Value("${Aathar_Tocken}")
	private String aatharTocken;

	@Value("${Aathar_Url}")
	private String aatharUrl;

	public String getAatharTocken() {
		return aatharTocken;
	}

	public void setAatharTocken(String aatharTocken) {
		this.aatharTocken = aatharTocken;
	}

	public String getAatharUrl() {
		return aatharUrl;
	}

	public void setAatharUrl(String aatharUrl) {
		this.aatharUrl = aatharUrl;
	}

}
