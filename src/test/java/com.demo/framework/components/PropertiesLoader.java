package com.demo.framework.components;

import java.io.IOException;
import java.util.Properties;

public class PropertiesLoader {

  private static final String GENERAL_PROPERTIES = "/general.properties";


  public static String loadProperty(String name) {
    java.util.Properties props = new Properties();
    try {
      props.load(PropertiesLoader.class.getResourceAsStream(GENERAL_PROPERTIES));
    } catch (IOException e) {
      e.printStackTrace();
    }
    String value = null;
    if (name != null) {
      value = props.getProperty(name);
    }
    return value;
  }

}
