package com.example.datastoremicroservice.service.impl;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.example.datastoremicroservice.model.MeasurementType;
import com.example.datastoremicroservice.model.Summary;
import com.example.datastoremicroservice.model.SummaryType;
import com.example.datastoremicroservice.model.exception.SensorNotFoundException;
import com.example.datastoremicroservice.repository.SummaryRepository;
import com.example.datastoremicroservice.service.SummaryService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SummaryServiceImpl implements SummaryService{
	
	private final SummaryRepository summaryRepository;
	
	@Override
	public Summary get(long sensorId, Set<MeasurementType> measurementTypes, Set<SummaryType> summaryTypes) {
		// TODO Auto-generated method stub
		return summaryRepository.findBySensorId(
				sensorId,
				measurementTypes == null ? Set.of(MeasurementType.values()) : measurementTypes,
				summaryTypes == null ? Set.of(SummaryType.values()) : summaryTypes
		).orElseThrow(SensorNotFoundException::new);
	}

}
