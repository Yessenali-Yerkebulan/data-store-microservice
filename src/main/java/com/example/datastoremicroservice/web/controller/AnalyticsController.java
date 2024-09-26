package com.example.datastoremicroservice.web.controller;

import java.util.Set;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.datastoremicroservice.model.MeasurementType;
import com.example.datastoremicroservice.model.Summary;
import com.example.datastoremicroservice.model.SummaryType;
import com.example.datastoremicroservice.web.dto.SummaryDto;
import com.example.datastoremicroservice.web.mapper.SummaryMapper;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/analytics")
@RequiredArgsConstructor
public class AnalyticsController {
	private final SummaryService simmaryService;
	
	private final SummaryMapper summaryMapper;
	
	@GetMapping("/summary/{sensorId}")
	public SummaryDto getSummary(
			@PathVariable long sensorId,
			@RequestParam(value = "mt", required = false)
				Set<MeasurementType> measurementTypes,
			@RequestParam(value = "st", required = false)
				Set<SummaryType> summaryTypes
	) {
		Summary summary = summaryService.get(
				sensorId,
				measurementTypes,
				summaryTypes
		);
		return summaryMapper.toDto(summary);
	}
}
