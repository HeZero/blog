package com.hsp.base.Exception;

public class DataNotFoundException extends BaseException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String msg;
	
	public String code;

	public DataNotFoundException(String msg, String code) {
		super();
		this.msg = msg;
		this.code = code;
	}
	
}
