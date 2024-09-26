package com.example.datastoremicroservice.service;

import java.util.Set;

import com.example.datastoremicroservice.model.MeasurementType;
import com.example.datastoremicroservice.model.Summary;
import com.example.datastoremicroservice.model.SummaryType;

public interface SummaryService {
	Summary get(
			long sensorId,
			Set<MeasurementType> measurementTypes,
			Set<SummaryType> summaryTypes
	);
}
