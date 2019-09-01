package com.apsis.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apsis.Exception.DuplicateException;
import com.apsis.Exception.NotFoundException;
import com.apsis.dao.CounterDaoLocalImp;
import com.apsis.models.Counter;

@Service
public class CounterService {
	
	private CounterDaoLocalImp counterDao;
	
	@Autowired
	public CounterService(CounterDaoLocalImp counterDao) {
		this.counterDao = counterDao;
	}

	public Counter createCounter(String counterName) {
		if(this.getCounter(counterName) != null) {
			throw new DuplicateException("Counter already exists");
		} else {
			return this.counterDao.save(getCounterObject(counterName));
		}
	}
	
	private Counter getCounterObject(String counterName) {
		Counter counter = new Counter();
		counter.setCounterName(counterName);
		return counter;
	}

	
	public Counter increaseCounter(String counterName) {
		Counter counter = this.getCounter(counterName);
		if(counter == null) {
			throw new NotFoundException("Counter not exists");
		} else {
			return increaseCounterValue(counter);
		}
	}
	
	private synchronized Counter increaseCounterValue(Counter counter) {
		return this.counterDao.increaseCounter(counter);
	}

	public Counter getCounter(String counterName) {
		return this.counterDao.findByCounterName(counterName);
	}

	public List<Counter> getAllCounter() {
		return this.counterDao.fetchAll();
	}

}
