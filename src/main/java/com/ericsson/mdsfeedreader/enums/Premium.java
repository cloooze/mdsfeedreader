package com.ericsson.mdsfeedreader.enums;

public enum Premium {
	
	N ("NO"),
	Y ("YES");
	
	private final String premium;
	
	private Premium(final String premium) {
		this.premium = premium;
	}
	
	@Override
	public String toString() {
		return premium;
	}
}
