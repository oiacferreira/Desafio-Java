package com.example.desafio.amqp.implementation;

import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.example.desafio.amqp.AmqpProducer;
import com.example.desafio.dto.MessageDTO;

@Component
public class ProducerRabbitMQ implements AmqpProducer<MessageDTO> {
	
	private RabbitTemplate rabbitTemplate;
	
	@Value(value = "spring.rabbitmq.request.routing-key.producer")
	private String queue;
	
	@Value(value = "spring.rabbitmq.request.exchenge.producer")
	private String exchenge;
	
	@Override
	public void producer(MessageDTO message) {
		try {
			rabbitTemplate.convertAndSend(exchenge, queue, message);
		}catch (Exception ex) {
			throw new AmqpRejectAndDontRequeueException(ex);
		}
		
	}

}
