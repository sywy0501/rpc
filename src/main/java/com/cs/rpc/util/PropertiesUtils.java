package com.cs.rpc.util;

import java.io.IOException;
import java.util.Properties;

/**
 * @description:
 * @author: chushi
 * @create: 2020-10-29 15:47
 **/
public class PropertiesUtils {

    private static Properties properties;

    static {
        try {
            properties = new Properties();
            properties.load(PropertiesUtils.class.getResourceAsStream("/app.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperties(String key) {
        return (String) properties.getProperty(key);
    }
}
