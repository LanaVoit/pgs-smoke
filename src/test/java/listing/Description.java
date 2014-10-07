package listing;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.testng.*;
import org.testng.annotations.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Description extends PGS.pages.TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

    @Test
  public void testUntitled4() throws Exception {
	driver.manage().window().maximize(); 
    driver.get(baseUrl + "crystal-gifts");
    TimeUnit.SECONDS.sleep(3);
    assertEquals("Stunning Engraved Crystal Gifts :: Vases, glasses, trophies, tokens just to name a few - Fast UK DELIVERY on all crystal... READ MORE [+]", driver.findElement(By.cssSelector("div.short-desc > p")).getText());
    assertEquals("READ MORE [+]", driver.findElement(By.linkText("READ MORE [+]")).getText());
    driver.findElement(By.linkText("READ MORE [+]")).click();
    assertEquals("Stunning Engraved Crystal Gifts :: Vases, glasses, trophies, tokens just to name a few - Fast UK DELIVERY on all crystal gifts. Stunning Engraved Crystal Gifts :: Vases, glasses, trophies, tokens just to name a few - Fast UK DELIVERY on all crystal gifts. Stunning Engraved Crystal Gifts :: Vases, glasses, trophies, tokens just to name a few - Fast UK DELIVERY on all crystal gifts. Stunning Engraved Crystal Gifts :: Vases, glasses, trophies, tokens just to name a few - Fast UK DELIVERY on all crystal gifts.Stunning Engraved Crystal Gifts :: Vases, glasses, trophies, tokens just to name a few - Fast UK DELIVERY on all crystal gifts.Stunning Engraved Crystal Gifts :: Vases, glasses, trophies, tokens just to name a few - Fast UK DELIVERY on all crystal gifts. Stunning Engraved Crystal Gifts :: Vases, glasses, trophies, tokens just to name a few - Fast UK DELIVERY on all crystal gifts. Stunning Engraved Crystal Gifts :: Vases, glasses, trophies, tokens just to name a few - Fast UK DELIVERY on all crystal gifts. Stunning Engraved Crystal Gifts :: Vases, glasses, trophies, tokens just to name a few - Fast UK DELIVERY on all crystal gifts. READ LESS [-]", driver.findElement(By.cssSelector("div.full-desc")).getText());
    assertEquals("READ LESS [-]", driver.findElement(By.linkText("READ LESS [-]")).getText());
    driver.findElement(By.linkText("READ LESS [-]")).click();
    assertEquals("Stunning Engraved Crystal Gifts :: Vases, glasses, trophies, tokens just to name a few - Fast UK DELIVERY on all crystal... READ MORE [+]", driver.findElement(By.cssSelector("div.short-desc > p")).getText());
    
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
