package com.vishwa.utility;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class CommonProperties {
	
	private static Logger logger = Logger.getLogger(CommonProperties.class);
	private static Properties properties;

	static {
		properties = getPropertiesFile("config.properties");
	}

	/**
	 * Static Method to load property values in {@link Properties} instance.
	 * 
	 * @param fileName
	 *            {@link String}
	 */
	public static void loadPropertiesFile(final String fileName) {

		try {
			logger.info("fileName ::::::: " + fileName);
			properties = new Properties();
			properties.load(CommonProperties.class.getClassLoader().getResourceAsStream(fileName));
		} catch (IOException e) {
			logger.error(e);
		}
	}

	/**
	 * Getter method to load and get Property file.
	 * 
	 * @param fileName
	 *            {@link String}
	 * @return properties {@link Properties}
	 */
	public static Properties getPropertiesFile(final String fileName) {
		if (properties == null) {
			loadPropertiesFile(fileName);
		}
		return properties;
	}
public static String AUTHORIZATION_HEADER = properties.getProperty("authorization.header");

}
