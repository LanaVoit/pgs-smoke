package product;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.testng.*;
import org.testng.annotations.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Reviews extends PGS.pages.TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

    @Test
  public void Reviews() throws Exception {
    	driver.manage().window().setSize(new Dimension(1366, 1050));
    driver.get(baseUrl + "personalised-swarovski-crystal-heart-vase.html");
    TimeUnit.SECONDS.sleep(5);
    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
            ,driver.findElement(By.cssSelector("#reviews-tab > span")));
    driver.findElement(By.cssSelector("#reviews-tab > span")).click();
    assertEquals("83 CUSTOMER REVIEWS", driver.findElement(By.cssSelector("p.reviews-title")).getText());
    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
            ,driver.findElement(By.cssSelector("div.reviews-legend-content > p")));
    assertEquals("We have chosen to work with one of the the most trusted independent customer feedback forum, FEEFO. All reviews collected by FEEFO after real purchases and published on product pages.", driver.findElement(By.cssSelector("div.reviews-legend-content > p")).getText());
    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
            ,driver.findElement(By.linkText("LOAD MORE")));
    assertEquals("LOAD MORE", driver.findElement(By.linkText("LOAD MORE")).getText());
    driver.findElement(By.linkText("LOAD MORE")).click();
    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
            ,driver.findElement(By.linkText("LOAD MORE")));
    assertEquals("LOAD MORE", driver.findElement(By.linkText("LOAD MORE")).getText());
    driver.findElement(By.linkText("LOAD MORE")).click();
    assertEquals("LOAD MORE", driver.findElement(By.linkText("LOAD MORE")).getText());

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
