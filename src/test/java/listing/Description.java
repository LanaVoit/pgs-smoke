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

public class Description extends PGS.pages.TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

    @Test
  public void Description() throws Exception {
    driver.manage().window().setSize(new Dimension(1366, 1050));
    driver.get(baseUrl + "personalised-birthday-gifts/for-babies.html");
    TimeUnit.SECONDS.sleep(3);
    assertEquals("If you're struggling to find those special birthday gifts for babies look no further than our fantastic range of presents.... READ MORE [+]", driver.findElement(By.cssSelector("div.short-desc > p")).getText());
    assertEquals("READ MORE [+]", driver.findElement(By.linkText("READ MORE [+]")).getText());
    driver.findElement(By.linkText("READ MORE [+]")).click();
    assertEquals("If you're struggling to find those special birthday gifts for babies look no further than our fantastic range of presents. From personalised breakfast sets to personalised name frames, personalised money boxes to personalised soft toys, we have 100's of unique and unusual birthday gift ideas for babies. Alternatively, take a look at our birthday gifts for kids and 1st Birthday Gifts, where you will find a huge range of birthday gifts. READ LESS [-]", driver.findElement(By.cssSelector("div.full-desc")).getText());
    assertEquals("READ LESS [-]", driver.findElement(By.linkText("READ LESS [-]")).getText());
    driver.findElement(By.linkText("READ LESS [-]")).click();
    assertEquals("If you're struggling to find those special birthday gifts for babies look no further than our fantastic range of presents.... READ MORE [+]", driver.findElement(By.cssSelector("div.short-desc > p")).getText());

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
