package com.braincustom.resources.exceptions;

import java.io.Serializable;

public class StandardError implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long timeStamp;
	private Integer status;
	private String mensage;
	
	public StandardError() {
	}
	
	public StandardError(Long timeStamp, Integer status, String mensage) {
		super();
		this.timeStamp = timeStamp;
		this.status = status;
		this.mensage = mensage;
	}

	public Long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMensage() {
		return mensage;
	}

	public void setMensage(String mensage) {
		this.mensage = mensage;
	}
}
