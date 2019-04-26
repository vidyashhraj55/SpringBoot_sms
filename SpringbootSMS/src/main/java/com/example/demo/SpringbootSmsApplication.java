package com.example.demo;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootSmsApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringbootSmsApplication.class, args);
	}
	 public static final String ACCOUNT_SID = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx(your SId number)";
	    public static final String AUTH_TOKEN  = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx\n(your Auth token)" + 
	    		"";

	    // Create a phone number in the Twilio console
	    public static final String TWILIO_NUMBER = "your twilio no.";

	@Override
	public void run(String... args) throws Exception {
	
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		Message message = Message.creator(
		    new PhoneNumber("+91xxxxxxxxxx"),
		    new PhoneNumber(TWILIO_NUMBER),
		    "hello good moring")
		.create();
	}
	
}
	
	

