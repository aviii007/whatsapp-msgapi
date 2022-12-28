package com.messageapi.controller;

import com.messageapi.model.MessageRequest;
import com.messageapi.service.MessageSendingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")
@CrossOrigin
public class SendController {

	@Autowired
	MessageSendingService messageSendingService;

	@PostMapping("send")

	public String sendTo(@RequestBody MessageRequest messageRequest) {

		return messageSendingService.messageSender(messageRequest);

	}
}