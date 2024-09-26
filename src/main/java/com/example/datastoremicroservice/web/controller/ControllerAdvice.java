package com.example.datastoremicroservice.web.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.example.datastoremicroservice.model.exception.SensorNotFoundException;

@RestController
public class ControllerAdvice {
	@ExceptionHandler(SensorNotFoundException.class)
	public String sensorNotFound(SensorNotFoundException e) {
		return "Sensor not found";
	}
	
	@ExceptionHandler
	public String server(Exception e) {
		e.printStackTrace();
		return "Something happened.";
	}
}
