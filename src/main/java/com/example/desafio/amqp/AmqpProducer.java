package com.example.desafio.amqp;

public interface AmqpProducer<T> {

	 void producer(T t);
}
