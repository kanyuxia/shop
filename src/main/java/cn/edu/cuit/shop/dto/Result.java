package cn.edu.cuit.shop.dto;

public class Result<T> {
	// ----------------------------some filed
	/**
	 * 是否成功
	 */
	public boolean success;
	/**
	 * DTO对象
	 */
	public T data;
	/**
	 * 错误信息
	 */
	public String message;
	
	// -----------------some construct methods
	public Result(boolean success, T data) {
		this.success = success;
		this.data = data;
	}

	public Result(boolean success, String message) {
		this.success = success;
		this.message = message;
	}
	
	// ---------------some setter、getter methods
	public boolean isSuccess() {
		return success;
	}
	
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	public T getData() {
		return data;
	}
	
	public void setData(T data) {
		this.data = data;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
}
