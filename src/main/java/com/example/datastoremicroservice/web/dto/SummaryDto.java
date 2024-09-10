package com.example.datastoremicroservice.web.dto;

import java.util.List;
import java.util.Map;

import com.example.datastoremicroservice.model.MeasurementType;
import com.example.datastoremicroservice.model.Summary.SummaryEntry;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SummaryDto {
	private long sensorId;
	private Map<MeasurementType, List<SummaryEntry>> values;
	
}
