package com.demo.tests;

import com.demo.pageobjects.MainePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoggingNegative extends BaseTest {

  private String validEmail = "demo@gmail.com";
  private String invalidEmail = "deo@gmail.com";
  private String validPass = "1234";
  private String invalidPass = "124";

  @Test
  public void loggingPositiveAssertion() {
    MainePage page = new MainePage(driver);
    page.enterValueInTextField(page.emailInput, validEmail);
    page.enterValueInTextField(page.passwordInput, invalidPass);
    page.tapOnElementByWait(page.doneBtn);
    Assert.assertTrue(page.failLabel.isDisplayed(), "");

    page.enterValueInTextField(page.emailInput, invalidEmail);
    page.enterValueInTextField(page.passwordInput, validPass);
    page.tapOnElementByWait(page.doneBtn);
    Assert.assertTrue(page.failLabel.isDisplayed(), "");

    page.enterValueInTextField(page.emailInput, invalidEmail);
    page.enterValueInTextField(page.passwordInput, invalidPass);
    page.tapOnElementByWait(page.doneBtn);
    Assert.assertTrue(page.failLabel.isDisplayed(), "");
  }

}
