package com.apsis.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.apsis.models.Counter;

@Repository
public class CounterDaoLocalImp implements CounterDao{
	
	private static HashMap<String, Counter> counters = new HashMap<String, Counter>(); 
	
	@Override
	public Counter save(Counter counter) {
		counters.put(counter.getCounterName(), counter);
		return counter; 
	}

	@Override
	public Counter findByCounterName(String counterName) {
		if(counters.containsKey(counterName)) {
			return counters.get(counterName);
		}
		return null;
	}

	@Override
	public List<Counter> fetchAll() {
		ArrayList<Counter> arList = new ArrayList<Counter>();
		for(Map.Entry<String,Counter> map : counters.entrySet()){
		     arList.add(map.getValue());
		}
		return arList; 
	}

	@Override
	public synchronized Counter increaseCounter(Counter counter) {
		counter.setValue(counter.getValue() + 1);
		return this.save(counter);
	}
}
