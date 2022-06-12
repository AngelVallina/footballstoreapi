package com.footballstore.core;

import java.sql.Timestamp;

/**
 * Clase auxilar para centralizar las respuestas de la APIs
 * @author avallina
 *
 */
public class ApiResponse {
	private Timestamp timestamp;
	private Object result;

	public ApiResponse(Timestamp timestamp, Object result){		
		this.setResult(result);
		this.setTimestamp(timestamp);
	}


	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}


	public Timestamp getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}
}