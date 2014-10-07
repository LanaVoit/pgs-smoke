package cart;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.testng.*;
import org.testng.annotations.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Checkout extends PGS.pages.TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

    @Test
  public void testUntitled3() throws Exception {
	driver.manage().window().maximize();
    driver.get(baseUrl + "personalised-swarovski-crystal-heart-vase.html");
    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
            ,driver.findElement(By.cssSelector("button[title=\"Add to Basket\"]")));
    driver.findElement(By.cssSelector("button[title=\"Add to Basket\"]")).click();
    TimeUnit.SECONDS.sleep(5);
    driver.findElement(By.xpath("//a[2]/span")).click();
    TimeUnit.SECONDS.sleep(5);
    assertEquals("YOUR SHOPPING BASKET", driver.findElement(By.cssSelector("h1")).getText());
    assertEquals("ENGRAVED SWAROVSKI CRYSTAL HEART VASE", driver.findElement(By.xpath("(//a[contains(text(),'Engraved Swarovski Crystal Heart Vase')])[3]")).getText());
    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
            ,driver.findElement(By.xpath("(//button[@type='button'])[2]")));
    driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
    TimeUnit.SECONDS.sleep(5);
    assertEquals("SECURE CHECKOUT", driver.findElement(By.cssSelector("h1")).getText());
    driver.get(baseUrl + "checkout/cart/");
    TimeUnit.SECONDS.sleep(5);
    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
            ,driver.findElement(By.xpath("(//ul[@class='checkout-types']/li/p[@class='paypal-logo']/a[@class='paypal-express-btn']/img)")));
    driver.findElement(By.xpath("(//ul[@class='checkout-types']/li/p[@class='paypal-logo']/a[@class='paypal-express-btn']/img)")).click();
    TimeUnit.SECONDS.sleep(5);
    assertEquals("first second's Test Store", driver.findElement(By.cssSelector("h1.confidential")).getText());
    assertEquals("Choose a way to pay", driver.findElement(By.id("loginPageTitle")).getText());
    driver.get(baseUrl + "checkout/cart/");
    TimeUnit.SECONDS.sleep(5);
    driver.findElement(By.cssSelector("a.continue-shopping")).click();
    String title = driver.getTitle();
    String title_test = "Home page";
    TimeUnit.SECONDS.sleep(5);
    assertEquals(title_test, title);
    TimeUnit.SECONDS.sleep(5);
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
