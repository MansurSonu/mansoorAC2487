package com.ac.sourceio.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "twilio")
public class TwilioConfig {


	private String accountSid;

	private String authToken;

	private String phoneNumber;

	
}
