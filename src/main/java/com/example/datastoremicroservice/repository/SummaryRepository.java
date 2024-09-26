package com.example.datastoremicroservice.repository;

import java.util.Optional;
import java.util.Set;

import com.example.datastoremicroservice.model.MeasurementType;
import com.example.datastoremicroservice.model.Summary;
import com.example.datastoremicroservice.model.SummaryType;

public interface SummaryRepository {
	Optional<Summary> findBySensorId(
			long sensorId,
			Set<MeasurementType> measurementTypes,
			Set<SummaryType> summaryTypes
	);
}
