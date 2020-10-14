package com.example.desafio.configuration;

import java.util.HashMap;
import java.util.Map;

import javax.naming.Binding;

import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProducerRabbitConfiguration {
	
	
	@Value(value = "spring.rabbitmq.request.routing-key.producer")
	private String queue;
	
	@Value(value = "spring.rabbitmq.request.exchenge.producer")
	private String exchenge;
	
	@Value(value = "spring.rabbitmq.request.deadletter.producer")
	private String deadLetter;
	
	@Bean
	DirectExchange exchenge() {
		return new DirectExchange(exchenge);
	}
	
	@Bean
	Queue deadletter() {
		return new Queue(deadLetter);
	}
	
	@Bean
	Queue queue() {
		Map<String, Object> args = new HashMap<>();
		args.put("x-dead-letter-exchenge", exchenge);
		args.put("x-dead-letter-routing-key", deadLetter);
		return new Queue(queue, true, false, false, args);
	}
	
	public org.springframework.amqp.core.Binding bindingQueue() {
		return BindingBuilder.bind(queue())
				.to(exchenge()).with(queue);
	}
	
	public org.springframework.amqp.core.Binding bindingDeadLetter(){
		return BindingBuilder.bind(deadletter())
					.to(exchenge()).with(deadLetter);
	}

}
