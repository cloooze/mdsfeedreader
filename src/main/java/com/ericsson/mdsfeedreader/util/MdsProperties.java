package com.ericsson.mdsfeedreader.util;

import java.util.ResourceBundle;

public class MdsProperties {

	private static ResourceBundle mdsProps = ResourceBundle.getBundle("mds");

	public MdsProperties() {
	}

	public static String getDefinition(String key) {
		return mdsProps.getString(key);
	}
}
