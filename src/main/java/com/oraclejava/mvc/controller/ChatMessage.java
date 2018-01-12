package com.oraclejava.mvc.controller;

import java.io.Serializable;

public class ChatMessage implements Serializable {
	private static final long serialVersionUID = 3379909466032411995L;
	
	private String name;
	private String message;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	
	@Override
	public String toString() {
		return "ChatMessage [name=" + name + ", message=" + message + "]";
	}

	public ChatMessage(String name, String message) {
		this.name = name;
		this.message = message;
	}
}
