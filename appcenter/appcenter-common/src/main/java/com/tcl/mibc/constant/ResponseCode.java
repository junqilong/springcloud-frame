package com.tcl.mibc.constant;

/**
 *接口响应状态码
 */
public enum ResponseCode {
	/**
	 * 成功
	 */
	SUCCESS(200, "Success"),
	
	/**
	 * 服务错误
	 */
	FAILURE(500, "Server Error"),

	/**
	 * 微服务调用错误
	 */
	MICRO_SERVICE_ERROR(10001,"micro_service call error");



	private int code;
	private String message;
	ResponseCode(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return this.message;
	}

}
