package com.revature.ajax;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "information")
@XmlAccessorType(XmlAccessType.FIELD)
public class ClientMessage {
	
	@XmlElement
	private String message;
	
	public ClientMessage() {}
	
	public ClientMessage(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
