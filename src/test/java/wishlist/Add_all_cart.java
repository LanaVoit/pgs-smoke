package wishlist;

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

public class Add_all_cart extends PGS.pages.TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

    @Test
  public void Add_all_cart() throws Exception {
    	driver.manage().window().setSize(new Dimension(1366, 1050));
    	Actions actions = new Actions(driver);
        driver.get(baseUrl + "personalised-swarovski-crystal-heart-vase.html");
        TimeUnit.SECONDS.sleep(5);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
                ,driver.findElement(By.cssSelector("li > a.button > span")));
        TimeUnit.SECONDS.sleep(5);
        driver.findElement(By.cssSelector("li > a.button > span")).click();
        TimeUnit.SECONDS.sleep(5);
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("qatestingtestqa@gmail.com");
        driver.findElement(By.id("pass")).clear();
        driver.findElement(By.id("pass")).sendKeys("qwerty");
        TimeUnit.SECONDS.sleep(5);
        driver.findElement(By.id("send2")).click();
        TimeUnit.SECONDS.sleep(10);
        driver.findElement(By.cssSelector("span")).click();
        TimeUnit.SECONDS.sleep(3);
        driver.findElement(By.cssSelector("span")).click();
        TimeUnit.SECONDS.sleep(3);
        assertEquals("Engraved Swarovski Crystal Heart Vase has been added to your wishlist.", driver.findElement(By.cssSelector("span")).getText());
        driver.findElement(By.cssSelector("button.mfp-close")).click();
        TimeUnit.SECONDS.sleep(3);
    driver.get(baseUrl + "personalised-swarovski-big-heart-diamante-vase.html");
    TimeUnit.SECONDS.sleep(5);
    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
            ,driver.findElement(By.cssSelector("li > a.button > span")));
    driver.findElement(By.cssSelector("li > a.button > span")).click();
    TimeUnit.SECONDS.sleep(3);
    driver.findElement(By.cssSelector("span")).click();
    TimeUnit.SECONDS.sleep(3);
    driver.findElement(By.cssSelector("span")).click();
    TimeUnit.SECONDS.sleep(3);
    driver.findElement(By.cssSelector("button.mfp-close")).click();
    driver.get(baseUrl + "wishlist/");

    TimeUnit.SECONDS.sleep(3);
    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
            ,driver.findElement(By.cssSelector("button.button.btn-add")));
    driver.findElement(By.cssSelector("button.button.btn-add")).click();
    try {
      assertEquals("2 product(s) have been added to shopping cart: \"Engraved Swarovski Crystal Heart Vase\", \"Personalised Swarovski Diamante Vase - Big Heart Design\".", driver.findElement(By.cssSelector("li > span")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    try {
      assertEquals("You have no items in your wishlist.", driver.findElement(By.cssSelector("p.wishlist-empty")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }    
    driver.get(baseUrl + "checkout/cart/");
    assertEquals("YOUR SHOPPING BASKET", driver.findElement(By.cssSelector("h1")).getText());
    try {
        assertEquals("Engraved Swarovski Crystal Heart Vase", driver.findElement(By.xpath("(//a[contains(text(),'Engraved Swarovski Crystal Heart Vase')])[3]")).getText());
      } catch (Error e) {
        verificationErrors.append(e.toString());
      }
      driver.findElement(By.xpath("//div[@class='item']/div[7]/a")).click();
      TimeUnit.SECONDS.sleep(7);
      driver.findElement(By.xpath("//div[@class='item']/div[7]/a")).click();
      TimeUnit.SECONDS.sleep(10);
      assertEquals("SHOPPING CART IS EMPTY", driver.findElement(By.cssSelector("h1")).getText());
      TimeUnit.SECONDS.sleep(5);
      driver.get(baseUrl + "customer/account/logout");

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
