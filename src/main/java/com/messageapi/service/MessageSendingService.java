package com.messageapi.service;

import com.messageapi.model.MessageRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class MessageSendingService {

	@Value("${whatsApp.accessToken}")
	private String token; // getting Access token form Application.Properties

	public String messageSender(MessageRequest messageRequest) {

		String uri = "https://graph.facebook.com/v15.0/101220266195721/messages "; // Facebook API URL

		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Bearer " + token); // Add bearer token to the RestTemplate Header

		headers.setContentType(MediaType.APPLICATION_JSON);

		// Build JSON Body

		String requestJson = "{\"messaging_product\": \"whatsapp\", \"to\": \"" + messageRequest.getWhatsAppNumber()
				+ "\", \"type\": \"template\", \"template\": { \"name\": \"" + messageRequest.getMessageTemplate()
				+ "\", \"language\": { \"code\": \"en_US\" }}}";

		// Create HttpEntity Using JSON body and Authentication (Bearer Token) Header
		HttpEntity<String> entity = new HttpEntity<>(requestJson, headers);

		// Call the WhatsAPP API

		ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.POST, entity, String.class);

		return response.getBody();
	}

}
