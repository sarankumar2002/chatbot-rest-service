package com.saran.chatbot.entity;

import java.io.Serializable;
import java.util.List;

public class Page implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Entry> entry;
	public List<Entry> getEntry() {
		return entry;
	}
	public void setEntry(List<Entry> entry) {
		this.entry = entry;
	}
	@Override
	public String toString() {
		return "Page [entry=" + entry + "]";
	}
	
	

}
