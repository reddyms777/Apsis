package com.apsis.models;

public class Counter {
	
	String counterName;
	Long value = 0L;

	public String getCounterName() {
		return counterName;
	}
	public void setCounterName(String counterName) {
		this.counterName = counterName;
	}
	public Long getValue() {
		return value;
	}
	public void setValue(Long value) {
		this.value = value;
	}
	
	
}
