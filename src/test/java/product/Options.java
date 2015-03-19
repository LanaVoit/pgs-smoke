package product;

import java.util.List;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.testng.*;
import org.testng.annotations.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Options extends PGS.pages.TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

    @Test
  public void Options() throws Exception {
	driver.manage().window().maximize();
    driver.get(baseUrl + "personalised-swarovski-crystal-heart-vase.html");
    assertEquals("£40.00", driver.findElement(By.xpath("//*[@id='product-price-1914']")).getText());
    
    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
            ,driver.findElement(By.id("options_32498_text")));
    driver.findElement(By.id("options_32498_text")).clear();
    driver.findElement(By.id("options_32498_text")).sendKeys("Test1");
    driver.findElement(By.id("options_32497_text")).clear();
    driver.findElement(By.id("options_32497_text")).sendKeys("Test2");
    driver.findElement(By.id("options_32496_text")).clear();
    driver.findElement(By.id("options_32496_text")).sendKeys("Test3");
    driver.findElement(By.id("options_32495_text")).clear();
    driver.findElement(By.id("options_32495_text")).sendKeys("Test4");
    driver.findElement(By.id("options_32499_text")).clear();
    driver.findElement(By.id("options_32499_text")).sendKeys("Test");
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
            ,driver.findElement(By.cssSelector("button[title=\"Add to Basket\"]")));
    driver.findElement(By.cssSelector("button[title=\"Add to Basket\"]")).click();
    TimeUnit.SECONDS.sleep(7);
    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
            ,driver.findElement(By.xpath("//a[2]/span")));
    driver.findElement(By.xpath("//a[2]/span")).click();
    TimeUnit.SECONDS.sleep(10);
    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
            ,driver.findElement(By.cssSelector("div.item-name.columns.medium-5.hide-for-small-only > div.product-links > span")));
    driver.findElement(By.cssSelector("div.item-name.columns.medium-5.hide-for-small-only > div.product-links > span")).click();
    TimeUnit.SECONDS.sleep(5);
    
    assertEquals("Test1", driver.findElement(By.cssSelector("dd")).getText());
    assertEquals("Test2", driver.findElement(By.xpath("//dd[2]")).getText());
    assertEquals("Test3", driver.findElement(By.xpath("//dd[3]")).getText());
    assertEquals("Test4", driver.findElement(By.xpath("//dd[4]")).getText());
    assertEquals("Test", driver.findElement(By.xpath("//dd[5]")).getText());
    driver.findElement(By.cssSelector("button.mfp-close")).click();
    TimeUnit.SECONDS.sleep(5);
    
    driver.findElement(By.cssSelector("div.item-remove.columns.medium-1.hide-for-small-only > a[title='Remove item']")).click();  

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
