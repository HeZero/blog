package com.hsp.base.Exception;

public class BaseException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String msg;
	
	public String code;

	public BaseException() {
		super();
	}

	public BaseException(String msg) {
		super();
		this.msg = msg;
	}

	public BaseException(String msg, String code) {
		super();
		this.msg = msg;
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	@Override
	public String getMessage() {
		return this.msg+this.code;
	}

}
