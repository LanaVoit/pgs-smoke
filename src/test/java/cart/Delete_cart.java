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

public class Delete_cart extends PGS.pages.TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

    @Test
  public void Delete_cart() throws Exception {
    	driver.manage().window().setSize(new Dimension(1366, 1050));
        driver.get(baseUrl + "personalised-swarovski-crystal-heart-vase.html");
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
                ,driver.findElement(By.cssSelector("button[title=\"Add to Basket\"]")));
        TimeUnit.SECONDS.sleep(5);
        driver.findElement(By.cssSelector("button[title=\"Add to Basket\"]")).click();
        TimeUnit.SECONDS.sleep(5);
        driver.findElement(By.xpath("//a[2]/span")).click();
        TimeUnit.SECONDS.sleep(5);
        assertEquals("YOUR SHOPPING BASKET", driver.findElement(By.cssSelector("h1")).getText());
        assertEquals("ENGRAVED SWAROVSKI CRYSTAL HEART VASE", driver.findElement(By.xpath("(//a[contains(text(),'Engraved Swarovski Crystal Heart Vase')])[3]")).getText());
        driver.findElement(By.xpath("//div[@class='item']/div[7]/a")).click();
        TimeUnit.SECONDS.sleep(10);
        assertEquals("SHOPPING CART IS EMPTY", driver.findElement(By.cssSelector("h1")).getText());


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
