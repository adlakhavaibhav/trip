package com.td.impl.service;

import com.td.pact.service.LoadPropertyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Properties;

/**
 * Created by IntelliJ IDEA.
 * User: Vaibhav
 * Date: 9/20/14
 * Time: 10:51 AM
 */
@Service
public class LoadPropertyServiceImpl implements LoadPropertyService {

  private static Logger logger = LoggerFactory.getLogger(LoadPropertyServiceImpl.class);
  private final String PROPS_PATH = "environmentLocator.properties";


  private static Properties loadProps = null;
  private boolean isLoaded = false;


  @Override
  public Object getProperty(String propertyName, String defaultValue) {

    if (!isLoaded)
      load();

    String result = System.getProperty(propertyName);
    if (result == null) {
      result = defaultValue;
      if (result != null)
        System.setProperty(propertyName, result);
    }
    return result;
  }

  @Override
  public Object getProperty(String propertyName) {
    return getProperty(propertyName, null);
  }


  protected boolean load() {
    return load(PROPS_PATH);
  }

  @Override
  public boolean load(String filePath) {

    if (loadProps != null) {
      Iterator<?> names = loadProps.keySet().iterator();
      while (names.hasNext()) {
        String name = (String) names.next();
        System.clearProperty(name);
      }
    }
    logger.debug("***************************Loading properties*********************");

    loadProps = new java.util.Properties();
    try {
      InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(filePath);
      loadProps.load(inputStream);

      Enumeration<?> names = loadProps.propertyNames();
      while (names.hasMoreElements()) {
        String key = (String) names.nextElement();
        System.setProperty(key, loadProps.getProperty(key));
        logger.debug("Loading key " + key + ", value:" + loadProps.getProperty(key));
      }
    } catch (IOException ioe) {
      logger.error("IO Error while loading properties", ioe);
    }

    isLoaded = true;
    return isLoaded;
  }

  @Override
  public boolean isLoaded() {
    return isLoaded;
  }


}

