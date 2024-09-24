package com.dosoar.email_security_demo.common;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

public class Result<T> implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/**
	 * 成功标记
	 */
	public static final Integer SUCCESS = 0;

	/**
	 * 失败标记
	 */
	public static final Integer FAIL = 1;


	public static final Integer SESSION_INVALID = 401;

	@Getter
	@Setter
	private int code;

	@Getter
	@Setter
	private String message;

	@Getter
	@Setter
	private T result;
	
	public static <T> Result<T> ok() {
		return setResult(null, SUCCESS, null);
	}
	
	public static <T> Result<T> ok(String msg) {
		return setResult(null, SUCCESS, msg);
	}

	public static <T> Result<T> ok(T data) {
		return setResult(data, SUCCESS, null);
	}

	public static <T> Result<T> ok(T data, String msg) {
		return setResult(data, SUCCESS, msg);
	}

	public static <T> Result<T> failed() {
		return setResult(null, FAIL, null);
	}

	public static <T> Result<T> failed(String msg) {
		return setResult(null, FAIL, msg);
	}

	public static <T> Result<T> loginTimeout(String msg) {
		return setResult(null, SESSION_INVALID, msg);
	}
	
	public static <T> Result<T> sessionInvalid(String msg) {
		return setResult(null, SESSION_INVALID, msg);
	}

	public static <T> Result<T> setResult(T data, int code, String msg) {
		Result<T> result = new Result<>();
		result.setCode(code);
		result.setResult(data);
		result.setMessage(msg);
		return result;
	}
}
