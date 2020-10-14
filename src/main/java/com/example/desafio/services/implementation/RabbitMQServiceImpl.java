package com.example.desafio.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.desafio.amqp.AmqpProducer;
import com.example.desafio.dto.MessageDTO;
import com.example.desafio.services.AmqpService;

@Service
public class RabbitMQServiceImpl implements AmqpService{
	
	@Autowired
	private AmqpProducer<MessageDTO> amqp;
	
	@Override
	public void sendToConsumer(MessageDTO message) {
		amqp.producer(message);
	}
}
