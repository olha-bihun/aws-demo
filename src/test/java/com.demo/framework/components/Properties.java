package com.demo.framework.components;

import static java.util.concurrent.TimeUnit.SECONDS;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Properties {

  private static IOSDriver<MobileElement> driver;
  private static final Logger LOG = LoggerFactory.getLogger(Properties.class);
  public static AppiumDriverLocalService service;

  public AppiumDriverLocalService startServer() {
    boolean flag = checkIfServerIsRunning(4723);
    if (!flag) {
      service = AppiumDriverLocalService.buildDefaultService();
      service.start();
    }
    return service;

  }

  public static boolean checkIfServerIsRunning(int port) {

    boolean isServerRunning = false;
    ServerSocket serverSocket;
    try {
      serverSocket = new ServerSocket(port);

      serverSocket.close();
    } catch (IOException e) {
      isServerRunning = true;
    } finally {
      serverSocket = null;
    }
    return isServerRunning;
  }

  public static IOSDriver<MobileElement> getDriver() throws MalformedURLException {
    driver = new IOSDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),
        capabilities());
    driver.manage().timeouts().implicitlyWait(60, SECONDS);
    return driver;
  }

  private static final File appPath = new File(PropertiesLoader.loadProperty("app.path"));

  public static DesiredCapabilities capabilities() {
    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 11 Pro Max");
    capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
//    capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.0");
    capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
    capabilities.setCapability(MobileCapabilityType.APP, appPath.getAbsolutePath());
    return capabilities;
  }

}
