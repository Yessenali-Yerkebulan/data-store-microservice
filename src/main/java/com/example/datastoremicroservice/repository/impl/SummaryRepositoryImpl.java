package com.example.datastoremicroservice.repository.impl;

import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Repository;

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
					
			));
		}
	}
	
	
}
