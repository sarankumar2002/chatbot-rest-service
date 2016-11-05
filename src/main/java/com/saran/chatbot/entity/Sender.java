package com.saran.chatbot.entity;

import java.io.Serializable;

public class Sender implements Serializable{
	
	private long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Sender [id=" + id + "]";
	}
	
	

}
