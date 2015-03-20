package login;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.testng.*;
import org.testng.annotations.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Invalid_field extends PGS.pages.TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

    @Test
  public void Invalid_field() throws Exception {
    	driver.manage().window().setSize(new Dimension(1366, 1050));
    driver.get(baseUrl + "customer/account/login/");
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("qatestingtestqa");
    driver.findElement(By.id("pass")).clear();
    driver.findElement(By.id("pass")).sendKeys("qw");
    driver.findElement(By.id("email")).click();
    assertEquals("Please enter 6 or more characters. Leading or trailing spaces will be ignored.", driver.findElement(By.id("advice-validate-password-pass")).getText());
    assertEquals("Please enter a valid email address. For example johndoe@example.com.", driver.findElement(By.id("advice-validate-email-email")).getText());  
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("qatestingtestqa@gmail.com");
    driver.findElement(By.id("pass")).clear();
    driver.findElement(By.id("pass")).sendKeys("qwertyu");
    TimeUnit.SECONDS.sleep(5);
    driver.findElement(By.id("send2")).click();
    TimeUnit.SECONDS.sleep(7);
    assertEquals("Invalid login or password.", driver.findElement(By.cssSelector("li > span")).getText());

  }

   private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  
  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
