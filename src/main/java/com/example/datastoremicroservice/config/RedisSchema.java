package com.example.datastoremicroservice.config;

import com.example.datastoremicroservice.model.MeasurementType;

public class RedisSchema {
	public static String sensorKeys() {
		return KeyHelper.getKey("sensors");
	}
	
	public static String summaryKey(
			long sensorId,
			MeasurementType measurementType
	) {
		return KeyHelper.getKey("sensors:" + sensorId + ":" + measurementType.name().toLowerCase());
	}
}
