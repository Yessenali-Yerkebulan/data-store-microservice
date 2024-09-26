package com.example.datastoremicroservice.repository.impl;

import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Repository;

import com.example.datastoremicroservice.config.RedisSchema;
import com.example.datastoremicroservice.model.MeasurementType;
import com.example.datastoremicroservice.model.Summary;
import com.example.datastoremicroservice.model.SummaryType;
import com.example.datastoremicroservice.repository.SummaryRepository;

import lombok.RequiredArgsConstructor;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Repository
@RequiredArgsConstructor
public class SummaryRepositoryImpl implements SummaryRepository{
	private final JedisPool jedisPool;

	@Override
	public Optional<Summary> findBySensorId(long sensorId, Set<MeasurementType> measurementTypes,
			Set<SummaryType> summaryTypes) {
		try(Jedis jedis = jedisPool.getResource()) {
			if(!jedis.sismember(
				RedisSchema.sensorKeys(),
				String.valueOf(sensorId)
			)) {
				return Optional.empty();
			}
			if(measurementTypes.isEmpty() && !summaryTypes.isEmpty()) {
				return getSummary(
					sensorId,
					Set.of(MeasurementType.values()),
					summaryTypes,
					jedis
				);
			} else if (!measurementTypes.isEmpty() && summaryTypes.isEmpty()) {
				return getSummary(
					sensorId,
					measurementTypes,
					Set.of(SummaryType.values()),
					jedis
				);
			} else {
				return getSummary(
					sensorId,
					measurementTypes,
					summaryTypes,
					jedis
				);
			}
		}
	}
	
	private Optional<Summary> getSummary(long sensorId, Set<MeasurementType> measurementTypes,
			Set<SummaryType> summaryTypes, Jedis jedis) {
		Summary summary = new Summary();
		summary.setSensorId(sensorId);
		
		for(MeasurementType mType : measurementTypes) {
			for(SummaryType sType : summaryTypes) {
				Summary.SummaryEntry entry = new Summary.SummaryEntry();
				entry.setType(sType);
				String value = jedis.hget(
					RedisSchema.summaryKey(sensorId, mType),
					sType.name().toLowerCase()
				);
				if(value != null) {
					entry.setValue(Double.parseDouble(value));
				}
				summary.addValue(mType, entry);
			}
		}
		
		return Optional.of(summary);
	}
}
