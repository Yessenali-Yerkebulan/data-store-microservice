package com.example.datastoremicroservice.model;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class Data {
	private Long id;
	private Long sensorId;
	private LocalDateTime timestamp;
	private double measurement;
	private MeasurementType measurementType;
}
