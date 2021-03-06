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

public class Next_page extends PGS.pages.TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

    @Test
  public void Next_page() throws Exception {
    	driver.manage().window().setSize(new Dimension(1366, 1050));
	Actions actions = new Actions(driver);
    driver.get(baseUrl + "personalised-birthday-gifts/for-babies.html");
    TimeUnit.SECONDS.sleep(3);
    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
            ,driver.findElement(By.cssSelector("a.next-page > img")));
   // assertEquals("1 to 29 of 418 items", driver.findElement(By.cssSelector("div.toolbar-bottom > div.toolbar > div.pager > p.amount")).getText());
    driver.findElement(By.cssSelector("a.next-page > img")).click();
    TimeUnit.SECONDS.sleep(5);
  //  assertEquals("30 to 58 of 418 items", driver.findElement(By.cssSelector("p.amount")).getText());

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
