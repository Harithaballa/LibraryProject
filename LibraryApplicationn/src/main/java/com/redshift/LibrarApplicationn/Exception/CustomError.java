package com.redshift.LibrarApplicationn.Exception;

import org.springframework.http.HttpStatus;

public class CustomError  extends Exception
{
	
	String msg;
	HttpStatus status;
    public CustomError(String msg, HttpStatus status) {
		//super(msg);
		this.msg = msg;
		this.status = status;
	}
    public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
}
