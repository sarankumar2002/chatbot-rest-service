package com.saran.chatbot.entity;

import java.io.Serializable;

public class Recipient implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Recipient [id=" + id + "]";
	}
	
	

}
