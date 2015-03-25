package com.ericsson.mdsfeedreader.enums;

public enum Brand {
	
	VMU ("virgin"),
	BST ("boost"), 
	SPP ("spp");
	
	private final String brand;
	
	private Brand(final String brand) {
		this.brand = brand;
	}
	
	@Override
	public String toString() {
		return brand;
	}
}
