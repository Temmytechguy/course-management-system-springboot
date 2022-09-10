package com.temmytechie.coursems.entity;

public enum Department {

	
		SCIENCE("Science"),
		ART("Art"),
		BUSINESS("Business"),
		Technology("Technology"),
		MATHEMATICS("Mathematics")
		;
	
	private final String displayText;
	
	Department(String displayText) {
	
		this.displayText = displayText;
	}
	
	public String getDisplayText() {
		return displayText;
	}
	
}
