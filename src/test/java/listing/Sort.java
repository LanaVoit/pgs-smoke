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
  public void testUntitled5() throws Exception {
	driver.manage().window().maximize();
    driver.get(baseUrl + "crystal-gifts");
    driver.get(baseUrl + "crystal-gifts?dir=asc&order=price");
    TimeUnit.SECONDS.sleep(3);
    assertEquals("£11.99", driver.findElement(By.cssSelector("#product-price-388 > span.price")).getText());
    assertEquals("£12.99", driver.findElement(By.cssSelector("#product-price-292 > span.price")).getText());
    assertEquals("£14.99", driver.findElement(By.cssSelector("#product-price-85 > span.price")).getText());
    driver.get(baseUrl + "crystal-gifts?dir=asc&order=name");
    TimeUnit.SECONDS.sleep(3);
    assertEquals("Engraved Anniversary Crystal Wine Glasses", driver.findElement(By.linkText("Engraved Anniversary Crystal Wine Glasses")).getText());
    assertEquals("Engraved Birthday Crystal Whisky Glass", driver.findElement(By.linkText("Engraved Birthday Crystal Whisky Glass")).getText());
    assertEquals("Engraved Crystal Bible Book", driver.findElement(By.linkText("Engraved Crystal Bible Book")).getText());
    driver.findElement(By.linkText("2")).click();
    TimeUnit.SECONDS.sleep(3);
    assertEquals("30 to 52 of 52 items", driver.findElement(By.cssSelector("p.amount")).getText());
    TimeUnit.SECONDS.sleep(3);
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
