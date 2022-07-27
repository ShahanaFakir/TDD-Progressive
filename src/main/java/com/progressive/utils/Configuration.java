package com.progressive.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {

	private Properties properties;
	private final String defaultPath = "configuration/config.properties";

	public Configuration(String Path) {
		if (Path == null || Path.length() < 11) {
			loadProperty(defaultPath);
		} else {
			loadProperty(Path);
		}
	}

	private void loadProperty(String path) {
		properties = new Properties();
		try {
			InputStream iStream = new FileInputStream(path);
			properties.load(iStream);
			iStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public String getConfiguration(String key) {
		if (key != null) {
			return properties.getProperty(key);
		} else {
			return null;
		}

	}

}
