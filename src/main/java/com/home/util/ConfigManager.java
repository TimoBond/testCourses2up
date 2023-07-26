package com.home.util;

import java.io.IOException;
import java.util.Properties;

public class ConfigManager {

    private static ConfigManager configManager = new ConfigManager();
    private static  Properties properties = new Properties();

    static{
        try {
            properties.load(ConfigManager.class.getClassLoader().getResourceAsStream("application.properties"));

        }catch (IOException ioException){
            ioException.printStackTrace();
        }
    }

    public String getProperties(String key){
        return properties.getProperty(key);
    }

    public static ConfigManager getConfigManager() {
        return configManager;
    }
}
