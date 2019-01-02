package com.llq.gift.vo;

public class BaseResponse<T> {

	protected Boolean success;
	
	protected T body;
	
	protected String code;
	
	protected String msg;
	
	public BaseResponse(String code, String msg) {
		this.code = code;
		this.msg = msg;
		this.success = Boolean.FALSE;
	}
	
	protected BaseResponse(T body) {
		this.success = Boolean.TRUE;
		this.body = body;
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public T getBody() {
		return body;
	}

	public String getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

	@Override
	public String toString() {
		return "BaseResponse [success=" + success + ", body=" + body + ", code=" + code + ", msg=" + msg + "]";
	}
	
	
	
}
