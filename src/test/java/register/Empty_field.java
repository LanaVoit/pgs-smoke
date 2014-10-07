package register;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.testng.*;
import org.testng.annotations.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Empty_field extends PGS.pages.TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

    @Test
  public void testUntitled() throws Exception {
	driver.manage().window().maximize();
    driver.get(baseUrl + "customer/account/create/");
    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
            ,driver.findElement(By.cssSelector("div.buttons-set > button.button.btn-primary")));
    driver.findElement(By.cssSelector("div.buttons-set > button.button.btn-primary")).click();
    assertEquals("This is a required field.", driver.findElement(By.id("advice-required-entry-firstname")).getText());
    assertEquals("This is a required field.", driver.findElement(By.id("advice-required-entry-lastname")).getText());
    assertEquals("This is a required field.", driver.findElement(By.id("advice-required-entry-email_address")).getText());
    assertEquals("This is a required field.", driver.findElement(By.id("advice-required-entry-password")).getText());
    assertEquals("This is a required field.", driver.findElement(By.id("advice-required-entry-confirmation")).getText());
    assertEquals("This is a required field.", driver.findElement(By.id("advice-required-entry-captcha_user_create")).getText());

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
