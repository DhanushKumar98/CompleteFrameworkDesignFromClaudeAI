package com.config;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

	private static final Properties props = new Properties();

	static {
		try (InputStream is = ConfigReader.class.getClassLoader().getResourceAsStream("Config.properties")) {
			props.load(is);
		} catch (Exception e) {
			throw new RuntimeException("Config.properties not found", e);
		}
	}

	/**
	 * Env var takes priority over .properties file CI Pipelines sets BASE_URL;
	 * local dev uses the file.
	 */

	public static String get(String key) {
		String envKey = key.toUpperCase().replace(".", "_");
		String envVal = System.getenv(envKey);
		return (envVal != null) ? envVal : props.getProperty(key);
	}

	public static boolean getBool(String key) {
		return Boolean.parseBoolean(get(key));
	}

}
