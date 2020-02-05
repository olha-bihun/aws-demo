package com.demo.tests;

import com.demo.framework.components.Properties;
import io.appium.java_client.ios.IOSDriver;
import java.net.MalformedURLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

public class BaseTest extends Properties {

  public IOSDriver driver;
  private static final Logger LOG = LoggerFactory.getLogger(BaseTest.class);
  private String bundle = "com.olhabihun.TestApp";

  @BeforeClass(alwaysRun = true)
  public void createSuite(ITestContext ctx) throws MalformedURLException {
    service = startServer();
    LOG.info("service was started");
    driver = Properties.getDriver();
    LOG.info("driver was " + (driver == null));
  }

  @AfterSuite(alwaysRun = true)
  public void afterSuite() {
    driver.closeApp();
    LOG.info("application was closed");
    if (driver != null) {
      driver.quit();
      LOG.info("Driver quited");
    }
    service.stop();
    LOG.info("service was stopped");
  }

}
