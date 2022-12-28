package com.messageapi.model;

import org.springframework.stereotype.Component;

@Component
public class MessageRequest {
	private String whatsAppNumber;
	private String messageTemplate;

	public String getWhatsAppNumber() {
		return whatsAppNumber;
	}

	public void setWhatsAppNumber(String whatsAppNumber) {
		this.whatsAppNumber = "917000598464";
	}

	public String getMessageTemplate() {
		return messageTemplate;
	}

	public void setMessageTemplate(String messageTemplate) {
		this.messageTemplate = "hello_world";
	}

	public MessageRequest() {
		super();
	}

}
