package com.automation.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties;

    static {
        try (FileInputStream input = new FileInputStream("src/test/resources/configuration.properties")) {
            properties = new Properties();
            properties.load(input);
            Log.info("Configuration properties loaded successfully.");
        } catch (IOException e) {
            Log.error("Configuration.properties file failed to load: " + e.getMessage());
            throw new RuntimeException("Configuration.properties file failed to load", e);
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
