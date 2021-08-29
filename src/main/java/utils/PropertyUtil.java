package utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyUtil {

	private static PropertyUtil prop;
	private Properties properties;

	private PropertyUtil() {
		properties = new Properties();
	}
	
	public static synchronized PropertyUtil getInstance() {
		if (prop == null) {
			prop = new PropertyUtil();
		}
		return prop;
	}
	
	public static synchronized PropertyUtil getProperties() {
		PropertyUtil prop = new PropertyUtil();
		return prop;
	}
	
	public void load(String fileName) {
		InputStream input;
		input = getClass().getClassLoader().getResourceAsStream(fileName);
		try {
			properties.load(input);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	public String getValue(String key) {
		return properties.getProperty(key).trim();
	}

}

