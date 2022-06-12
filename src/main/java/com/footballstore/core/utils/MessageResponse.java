package com.footballstore.core.utils;

import java.util.Date;

public class MessageResponse {
	private Date timestamp;
	private String message;
	private int status;

	public MessageResponse(Date timestamp, String message, int status) {
		this.timestamp = timestamp;
		this.message = message;
		this.status = status;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public int getStatus() {
		return status;
	}
}
