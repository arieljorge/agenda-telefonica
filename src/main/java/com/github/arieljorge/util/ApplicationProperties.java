package com.github.arieljorge.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ApplicationProperties {

    private static final Properties PROPERTIES = new Properties();

    static {
        try (InputStream in = ApplicationProperties.class.getClassLoader().getResourceAsStream("application.properties")) {
            PROPERTIES.load(in);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String get(String key) {
        return PROPERTIES.getProperty(key);
    }
}
