package com.example.datastoremicroservice.service;

public interface CDCEventConsumer {
	void handle(String message);
}
