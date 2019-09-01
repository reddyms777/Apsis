package com.apsis.dto;

public class ResponseDTO {
	String msg;
	Integer errorCode;
	Object data;
	
	public ResponseDTO(String msg, Integer errorCode, Object data) {
		this.msg = msg;
		this.errorCode = errorCode;
		this.data = data;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Integer getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
}
