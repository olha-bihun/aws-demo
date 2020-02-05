package com.demo.tests;

import com.demo.pageobjects.MainePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InputValidation extends BaseTest {

  private String validEmail = "demo@gmail.com";
  private String validPass = "1234";

  @Test
  public void isEmailFieldsDisplayed() throws InterruptedException {
    MainePage page = new MainePage(driver);
    synchronized (driver) {
      driver.wait(30);
    }
    Assert.assertTrue(page.emailInput.isDisplayed(), "");
  }

  @Test
  public void isPasswordFieldsDisplayed() throws InterruptedException {
    MainePage page = new MainePage(driver);
    synchronized (driver) {
      driver.wait(30);
    }
    Assert.assertTrue(page.passwordInput.isDisplayed(), "");
  }

  @Test
  public void passwordShouldBeHidden() throws InterruptedException {
    MainePage page = new MainePage(driver);
    synchronized (driver) {
      driver.wait(30);
    }
    page.enterValueInTextField(page.passwordInput, validPass);
    Assert.assertFalse(page.passwordInput.getAttribute("value").contains(validEmail), "");
  }


}
