package com.demo.pageobjects;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class MainePage extends BasePage {

  public MainePage(IOSDriver<IOSElement> driver) {
    super(driver);
  }

  @iOSXCUITFindBy(id = "email")
  public IOSElement emailInput;

  @iOSXCUITFindBy(id = "password")
  public IOSElement passwordInput;

  @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name='Done']")
  public IOSElement doneBtn;

  @iOSXCUITFindBy(accessibility = "Success")
  public IOSElement successLabel;

  @iOSXCUITFindBy(accessibility = "Fail")
  public IOSElement failLabel;

  public void enterValueInTextField(IOSElement element, String value){
    tapOnElementByWait(element);
//    emailInput.clear();
    element.sendKeys(value);
  }
}


