package com.defect.tracker.data.exception;

public class ServiceException extends Exception {
	private static final long serialVersionUID = 1L;
	private Integer errorCode;

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

	public ServiceException() {
		super();
	}

	public ServiceException(String message, Integer errorCode) {
		super(message);
		setErrorCode(errorCode);
	}

	public ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
	}

	public ServiceException(String message) {
		super(message);
	}

	public ServiceException(Throwable cause) {
		super(cause);
	}
}
