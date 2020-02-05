package com.demo.pageobjects;

import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BasePage {

  IOSDriver<IOSElement> driver;
  private static final Logger LOG = LoggerFactory.getLogger(BasePage.class);

  public BasePage(IOSDriver<IOSElement> driver) {
    this.driver = driver;
    PageFactory.initElements(new AppiumFieldDecorator(driver), this);
  }

  public void tapOnElementByWait(IOSElement el) {
    TouchAction touchAction = new TouchAction(driver);
    waitUntilElementPresent(el);
    touchAction.tap(new TapOptions().withElement(new ElementOption().withElement(el))).perform();
  }

  public void waitUntilElementPresent(IOSElement element) {
    try {
      WebDriverWait wait = new WebDriverWait(driver, 5);
      wait.until(ExpectedConditions.visibilityOf(element));
    } catch (Exception e) {
      LOG.info(e.getMessage());
    }
  }

}
