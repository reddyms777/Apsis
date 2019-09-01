package com.apsis.Exception;

public class NotFoundException extends RuntimeException{

	private Integer code = 1004;
	
	public NotFoundException(String msg) {
		super(msg);
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}
}
