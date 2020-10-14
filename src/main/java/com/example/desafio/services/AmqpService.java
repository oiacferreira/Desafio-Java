package com.example.desafio.services;

import com.example.desafio.dto.MessageDTO;

public interface AmqpService {
	void sendToConsumer(MessageDTO message);
}
