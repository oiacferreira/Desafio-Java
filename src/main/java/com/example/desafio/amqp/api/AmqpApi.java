package com.example.desafio.amqp.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.desafio.dto.MessageDTO;
import com.example.desafio.services.AmqpService;

@RestController
public class AmqpApi {
	
	
	@Autowired
	private AmqpService service;

	@ResponseStatus(HttpStatus.ACCEPTED)
	@PostMapping("/send")
	public void sendToConsumer(@RequestBody MessageDTO message){
		service.sendToConsumer(message);
	}
}
