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

public class Product_page extends PGS.pages.TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

    @Test
  public void Product_page() throws Exception {
	driver.manage().window().maximize(); 
	Actions actions = new Actions(driver);
    driver.get(baseUrl + "personalised-birthday-gifts/for-babies.html");
    TimeUnit.SECONDS.sleep(3);
    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
            ,driver.findElement(By.cssSelector("h2.product-name > a[title=\"Personalised Children's Pirate Ship Money Box\"]")));
    driver.findElement(By.cssSelector("h2.product-name > a[title=\"Personalised Children's Pirate Ship Money Box\"]")).click();
    TimeUnit.SECONDS.sleep(3);
    assertEquals("Personalised Children's Pirate Ship Money Box", driver.findElement(By.cssSelector("h1 > span")).getText());
    TimeUnit.SECONDS.sleep(10);
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
