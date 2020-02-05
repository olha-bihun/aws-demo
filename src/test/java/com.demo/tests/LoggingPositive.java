package com.demo.tests;

import com.demo.pageobjects.MainePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoggingPositive extends BaseTest {

  private String validEmail = "demo@gmail.com";
  private String validPass = "1234";

  @Test
  public void loggingPositiveAssertion() {
    MainePage page = new MainePage(driver);
    page.enterValueInTextField(page.emailInput, validEmail);
    page.enterValueInTextField(page.passwordInput, validPass);
    page.tapOnElementByWait(page.doneBtn);
    Assert.assertTrue(page.successLabel.isDisplayed(), "");
  }

}
