package com.apsis.Exception;

public class DuplicateException extends RuntimeException{

	private Integer code = 1001;
	
	public DuplicateException(String msg) {
		super(msg);
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}
}
