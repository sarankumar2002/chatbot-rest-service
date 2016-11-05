package com.saran.chatbot.entity;

import java.io.Serializable;
import java.util.List;

public class Entry implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private long time;
	private List<Messaging>	messaging;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public long getTime() {
		return time;
	}
	public void setTime(long time) {
		this.time = time;
	}
	public List<Messaging> getMessaging() {
		return messaging;
	}
	public void setMessaging(List<Messaging> messaging) {
		this.messaging = messaging;
	}
	@Override
	public String toString() {
		return "Entry [id=" + id + ", time=" + time + ", messaging=" + messaging + "]";
	}
	
	
}
