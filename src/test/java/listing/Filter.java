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
  public void Filter() throws Exception {
    	driver.manage().window().setSize(new Dimension(1366, 1050));
    TimeUnit.SECONDS.sleep(3);
    driver.get(baseUrl + "personalised-birthday-gifts/for-babies.html");
    assertEquals("REFINE BY", driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[3]/div[3]/div[1]/p")).getText());
    //assertEquals("MOST POPULAR", driver.findElement(By.cssSelector("dt")).getText());
    //assertEquals("REFINE BY", driver.findElement(By.cssSelector("div.block-content > p.block-subtitle")).getText());
   // assertEquals("PRICE", driver.findElement(By.cssSelector("dt.last.odd")).getText());
    TimeUnit.SECONDS.sleep(3);
    WebElement webelement = driver.findElement(By.cssSelector("a[href=\"http://dev.personalisedgiftsshop.co.uk/default/personalised-birthday-gifts/for-babies/shopby/price-110-.html\"]"));
    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
            ,webelement);
    driver.findElement(By.cssSelector("a[href=\"http://dev.personalisedgiftsshop.co.uk/default/personalised-birthday-gifts/for-babies/shopby/price-110-.html\"]")).click();
    TimeUnit.SECONDS.sleep(3);
    assertEquals("17 item(s)", driver.findElement(By.cssSelector("p.amount")).getText());
    driver.findElement(By.linkText("reset")).click();
    TimeUnit.SECONDS.sleep(3);
    assertEquals("1 to 29 of 583 items", driver.findElement(By.cssSelector("p.amount")).getText());

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
