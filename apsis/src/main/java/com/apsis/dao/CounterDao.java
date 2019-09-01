package com.apsis.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.apsis.models.Counter;

@Component
public interface CounterDao {
	
	public Counter save(Counter counter);
	public Counter increaseCounter(Counter counter);
	public Counter findByCounterName(String counterName);
	public List<Counter> fetchAll();
}
