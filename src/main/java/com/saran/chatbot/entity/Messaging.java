package com.saran.chatbot.entity;

public class Messaging {

	private Sender sender;
	private Recipient recipient;
	private long timestamp;
	private Message message;

	public Sender getSender() {
		return sender;
	}

	public void setSender(Sender sender) {
		this.sender = sender;
	}

	public Recipient getRecipient() {
		return recipient;
	}

	public void setRecipient(Recipient recipient) {
		this.recipient = recipient;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Messaging [sender=" + sender + ", recipient=" + recipient + ", timestamp=" + timestamp + ", message="
				+ message + "]";
	}

}
