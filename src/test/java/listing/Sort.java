package listing;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.testng.*;
import org.testng.annotations.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Sort extends PGS.pages.TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

    @Test
  public void Sort() throws Exception {
    	driver.manage().window().setSize(new Dimension(1366, 1050));
    driver.get(baseUrl + "personalised-birthday-gifts/for-babies.html");
    driver.get(baseUrl + "personalised-birthday-gifts/for-babies.html?dir=asc&order=price");
    TimeUnit.SECONDS.sleep(3);
    assertEquals("£5.99", driver.findElement(By.cssSelector("#product-price-777 > span.price")).getText());
    assertEquals("£5.99", driver.findElement(By.cssSelector("#product-price-778 > span.price")).getText());
    assertEquals("£5.99", driver.findElement(By.cssSelector("#product-price-1282 > span.price")).getText());
    driver.get(baseUrl + "personalised-birthday-gifts/for-babies.html?dir=asc&order=name");
    TimeUnit.SECONDS.sleep(3);
    assertEquals("Baby Prints On Canvas Gift Box", driver.findElement(By.linkText("Baby Prints On Canvas Gift Box")).getText());
    assertEquals("Balloons Happy Birthday YoYo", driver.findElement(By.linkText("Balloons Happy Birthday YoYo")).getText());
    assertEquals("Beauty and the Beast Personalised Fairy Tale", driver.findElement(By.linkText("Beauty and the Beast Personalised Fairy Tale")).getText());
    driver.findElement(By.linkText("2")).click();
    TimeUnit.SECONDS.sleep(3);
    //assertEquals("30 to 58 of 418 items", driver.findElement(By.cssSelector("p.amount")).getText());
    driver.get(baseUrl + "personalised-birthday-gifts/for-babies.html?dir=desc&order=bestsellers");

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
