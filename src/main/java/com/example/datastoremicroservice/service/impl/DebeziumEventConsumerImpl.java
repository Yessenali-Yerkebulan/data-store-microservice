package com.example.datastoremicroservice.service.impl;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.TimeZone;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.datastoremicroservice.model.Data;
import com.example.datastoremicroservice.model.MeasurementType;
import com.example.datastoremicroservice.service.CDCEventConsumer;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DebeziumEventConsumerImpl implements CDCEventConsumer{

	@Override
	@KafkaListener(topics = "data")
	public void handle(String message) {
		try {
			JsonObject payload = JsonParser.parseString(message)
					.getAsJsonObject()
					.get("palyoad")
					.getAsJsonObject();
			Data data = new Data();
			data.setId(
					payload.get("id")
						.getAsLong()
			);
			
			data.setSensorId(
					payload.get("sensor_id")
						.getAsLong()
			);
			data.setMeasurement(
					payload.get("measurement")
					    .getAsDouble()
			);
			data.setMeasurementType(
					MeasurementType.valueOf(payload.get("type").getAsString())
			);
			data.setTimestamp(LocalDateTime.ofInstant(
							Instant.ofEpochMilli(
									payload.get("timestamp")
									.getAsLong() / 1000),
							TimeZone.getDefault()
								.toZoneId()
			));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
