package com.ericsson.mdsfeedreader.enums;

public enum Premium {
	
	N ("false"),
	Y ("true");
	
	private final String premium;
	
	private Premium(final String premium) {
		this.premium = premium;
	}
	
	@Override
	public String toString() {
		return premium;
	}
}
