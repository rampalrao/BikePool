package com.bikepool.properties;

import org.springframework.stereotype.Component;

import java.util.Properties;

/**
 * Created by rampal on 15/11/17.
 */
public class BikeShareProperties {
    private static BikeShareProperties instance;

    public BikeShareProperties() {
        instance = this;
    }

    public static BikeShareProperties getInstance() {
        return instance;
    }

    private Properties properties;

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public String getProperty(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }

}
