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
	 public static final String ACCOUNT_SID = "ACbf60193b85acda34fefa825d031e6691";
	    public static final String AUTH_TOKEN  = "a9e0a0c43422ff0c66da0121b86f1fd8\n" + 
	    		"";

	    // Create a phone number in the Twilio console
	    public static final String TWILIO_NUMBER = "+15054046486";

	@Override
	public void run(String... args) throws Exception {
	/*try {
			String recipient = "+441234567";
			String message = " Greetings from Mr. Gupta! Have a nice day!";
			String username = "admin";
			String password = "abc123";
			String originator = "+917899357978";
			String requestUrl  = "http://127.0.0.1:9501/api?action=sendmessage&" +
			 "username=" + URLEncoder.encode(username, "UTF-8") +
			 "&password=" + URLEncoder.encode(password, "UTF-8") +
			 "&recipient=" + URLEncoder.encode(recipient, "UTF-8") +
			 "&messagetype=SMS:TEXT" +
			 "&messagedata=" + URLEncoder.encode(message, "UTF-8") +
			 "&originator=" + URLEncoder.encode(originator, "UTF-8") +
			 "&serviceprovider=GSMModem1" +
			 "&responseformat=html";
			URL url = new URL(requestUrl);
			HttpURLConnection uc = (HttpURLConnection)url.openConnection();
			System.out.println(uc.getResponseMessage());
			uc.disconnect();
			} catch(Exception ex) {
			System.out.println(ex.getMessage());
			}
			}*/
	/*	Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
		Message message = Message.creator(
		    new PhoneNumber("+91 96636 04262"),
		    new PhoneNumber(TWILIO_NUMBER),
		    "hello nithin  fromm vidya")
		.create();
	}*/
	sendSms();	
	
}
	public String sendSms() {
		try {
			// Construct data
			String apiKey = "apikey=" + "NNkySbo0RrU-rZJzLrg0RMGqawNZEnSIOylxHEnSgL";
			String message = "&message=" + "from vidya";
			String sender = "&sender=" + "TXTLCL";
			String numbers = "&numbers=" + "917899357978";
			
			// Send data
			HttpURLConnection conn = (HttpURLConnection) new URL("https://api.textlocal.in/send/?").openConnection();
			String data = apiKey + numbers + message + sender;
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-Length", Integer.toString(data.length()));
			conn.getOutputStream().write(data.getBytes("UTF-8"));
			final BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			final StringBuffer stringBuffer = new StringBuffer();
			String line;
			while ((line = rd.readLine()) != null) {
				stringBuffer.append(line);
				System.out.println("msg sent");
			}
			rd.close();
			
			return stringBuffer.toString();
		} catch (Exception e) {
			System.out.println("Error SMS "+e);
			return "Error "+e;
		}
	}
}
	
	

