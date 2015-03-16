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

public class Add_cart extends PGS.pages.TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

    @Test
  public void Add_cart() throws Exception {
    	driver.manage().window().maximize();
    	Actions actions = new Actions(driver);
        driver.get(baseUrl + "personalised-swarovski-crystal-heart-vase.html");
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
                ,driver.findElement(By.cssSelector("li > a.button > span")));
        driver.findElement(By.cssSelector("li > a.button > span")).click();
        TimeUnit.SECONDS.sleep(5);
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("qatestingtestqa@gmail.com");
        driver.findElement(By.id("pass")).clear();
        driver.findElement(By.id("pass")).sendKeys("qwerty");
        driver.findElement(By.id("send2")).click();
        TimeUnit.SECONDS.sleep(10);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
                ,driver.findElement(By.cssSelector("li > a.button > span")));
        driver.findElement(By.cssSelector("li > a.button > span")).click();
        driver.findElement(By.cssSelector("span")).click();
        TimeUnit.SECONDS.sleep(3);
        driver.findElement(By.cssSelector("span")).click();
        TimeUnit.SECONDS.sleep(3);
        assertEquals("Engraved Swarovski Crystal Heart Vase has been added to your wishlist.", driver.findElement(By.cssSelector("span")).getText());
        driver.findElement(By.cssSelector("button.mfp-close")).click();
        TimeUnit.SECONDS.sleep(3);
        /*WebElement my_account = driver.findElement(By.id("myaccount-menu-link"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
                ,my_account);
        TimeUnit.SECONDS.sleep(5);
        actions.moveToElement(my_account).build().perform();
        driver.findElement(By.linkText("My Wishlist")).click();
        TimeUnit.SECONDS.sleep(5);*/
        driver.get(baseUrl + "wishlist/");
        assertEquals("Engraved Swarovski Crystal Heart Vase", driver.findElement(By.cssSelector("div.columns.small-6 > h3.product-name > a[title=\"Engraved Swarovski Crystal Heart Vase\"]")).getText());
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
                ,driver.findElement(By.cssSelector("div.columns.small-6 > h3.product-name > a[title=\"Engraved Swarovski Crystal Heart Vase\"]")));
    driver.findElement(By.cssSelector("div.r-tbody > div:last-child > div.columns.small-2 > div > div.add-to-cart-alt > button[title=\"Add to Basket\"]")).click();    
    TimeUnit.SECONDS.sleep(5);
    driver.get(baseUrl + "checkout/cart/");
    assertEquals("YOUR SHOPPING BASKET", driver.findElement(By.cssSelector("h1")).getText());
    assertEquals("ENGRAVED SWAROVSKI CRYSTAL HEART VASE", driver.findElement(By.xpath("(//a[contains(text(),'Engraved Swarovski Crystal Heart Vase')])[3]")).getText());
    driver.findElement(By.xpath("//div[@class='item']/div[7]/a")).click();
    TimeUnit.SECONDS.sleep(5);
    assertEquals("SHOPPING CART IS EMPTY", driver.findElement(By.cssSelector("h1")).getText());
    TimeUnit.SECONDS.sleep(5);
    driver.get(baseUrl + "customer/account/logout");
    TimeUnit.SECONDS.sleep(7);
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
