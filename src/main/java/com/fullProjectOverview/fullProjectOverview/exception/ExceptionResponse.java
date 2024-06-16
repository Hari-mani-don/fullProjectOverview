package com.fullProjectOverview.fullProjectOverview.exception;

import java.util.Date;

public class ExceptionResponse {
	
	private Date timeStamp;
	private String message;
	private Object details;

	public ExceptionResponse() {
		super();
	}

	public ExceptionResponse(Date timeStamp, String message, Object details) {
		super();
		this.timeStamp = timeStamp;
		this.message = message;
		this.details = details;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getDetails() {
		return details;
	}

	public void setDetails(Object details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "ExceptionResponse [timeStamp=" + timeStamp + ", message=" + message + ", details=" + details + "]";
	}

}
