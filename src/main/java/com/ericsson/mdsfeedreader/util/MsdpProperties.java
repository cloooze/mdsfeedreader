package com.ericsson.mdsfeedreader.util;

import java.util.ResourceBundle;

public class MsdpProperties {

	private static ResourceBundle msdpProps = ResourceBundle.getBundle("msdp");

	public MsdpProperties() {
	}

	public static String getDefinition(String key) {
		return msdpProps.getString(key);
	}
}
