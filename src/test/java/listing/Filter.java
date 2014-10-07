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

public class Filter extends PGS.pages.TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

    @Test
  public void testUntitled4() throws Exception {
    driver.manage().window().maximize();
    driver.get(baseUrl + "crystal-gifts");
    assertEquals("SHOP FOR", driver.findElement(By.cssSelector("p.block-subtitle")).getText());
    assertEquals("MOST POPULAR", driver.findElement(By.cssSelector("dt")).getText());
    assertEquals("REFINE BY", driver.findElement(By.cssSelector("div.block-content > p.block-subtitle")).getText());
    assertEquals("PRICE", driver.findElement(By.cssSelector("dt.last.odd")).getText());
    TimeUnit.SECONDS.sleep(3);
    WebElement webelement = driver.findElement(By.cssSelector("a[href=\"http://dev-mage.com/store53/store/default/engraved-gifts/crystal-gifts/shopby/price-71-80\"]"));
    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
            ,webelement);
    driver.findElement(By.cssSelector("a[href=\"http://dev-mage.com/store53/store/default/engraved-gifts/crystal-gifts/shopby/price-71-80\"]")).click();
    TimeUnit.SECONDS.sleep(3);
    assertEquals("1 item(s)", driver.findElement(By.cssSelector("p.amount")).getText());
    driver.findElement(By.linkText("reset")).click();
    TimeUnit.SECONDS.sleep(3);
    assertEquals("1 to 29 of 51 items", driver.findElement(By.cssSelector("p.amount")).getText());
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
