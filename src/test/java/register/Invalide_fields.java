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

public class Invalide_fields extends PGS.pages.TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

    @Test
  public void Invalide_fields() throws Exception {
    	driver.manage().window().setSize(new Dimension(1366, 1050));
    driver.get(baseUrl + "customer/account/create/");    
    driver.findElement(By.id("firstname")).clear();
    driver.findElement(By.id("firstname")).sendKeys("<script>alert();</script>");
    driver.findElement(By.id("lastname")).click();
    driver.findElement(By.id("lastname")).clear();
    driver.findElement(By.id("lastname")).sendKeys("<form action=”http://live.hh.ru”><input type=”submit”></form>");
    driver.findElement(By.id("email_address")).clear();
    driver.findElement(By.id("email_address")).sendKeys("test");
    driver.findElement(By.id("email_address")).click();
    driver.findElement(By.id("password")).clear();
    assertEquals("Please enter a valid email address. For example johndoe@example.com.", driver.findElement(By.id("advice-validate-email-email_address")).getText());
    driver.findElement(By.id("email_address")).clear();
    driver.findElement(By.id("email_address")).sendKeys("test@tdtfcg.com");
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("qwert");
    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
            ,driver.findElement(By.id("confirmation")));
    driver.findElement(By.id("confirmation")).click();
    assertEquals("Please enter 6 or more characters. Leading or trailing spaces will be ignored.", driver.findElement(By.id("advice-validate-password-password")).getText());
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("qwerty");
    driver.findElement(By.id("confirmation")).click();
    driver.findElement(By.id("confirmation")).clear();
    driver.findElement(By.id("confirmation")).sendKeys("qwert");
    driver.findElement(By.id("captcha_user_create")).clear();
    assertEquals("Please make sure your passwords match.", driver.findElement(By.id("advice-validate-cpassword-confirmation")).getText());
    driver.findElement(By.id("confirmation")).clear();
    driver.findElement(By.id("confirmation")).sendKeys("qwerty");
    driver.findElement(By.cssSelector("div.content")).click();
    driver.findElement(By.id("captcha_user_create")).clear();
    driver.findElement(By.id("captcha_user_create")).sendKeys("123");
    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
            ,driver.findElement(By.id("confirmation")));
    driver.findElement(By.id("confirmation")).click();
    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
            ,driver.findElement(By.cssSelector("div.buttons-set > button.button.btn-primary")));
    driver.findElement(By.cssSelector("div.buttons-set > button.button.btn-primary")).click();
    assertEquals("Incorrect CAPTCHA.", driver.findElement(By.cssSelector("li > span")).getText());

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
