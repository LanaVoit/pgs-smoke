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

public class Edit extends PGS.pages.TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

    @Test
  public void testUntitled5() throws Exception {
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
    driver.findElement(By.xpath("(//a[contains(text(),'Edit')])[2]")).click();
    TimeUnit.SECONDS.sleep(5);
    driver.findElement(By.id("options_5005_text")).clear();
    driver.findElement(By.id("options_5005_text")).sendKeys("TEST QA");
    new Select(driver.findElement(By.id("options_20301_month"))).selectByVisibleText("01");
    new Select(driver.findElement(By.id("options_20301_day"))).selectByVisibleText("01");
    driver.findElement(By.cssSelector("#options_20301_day > option[value=\"1\"]")).click();
    new Select(driver.findElement(By.id("options_20301_year"))).selectByVisibleText("2014");
    new Select(driver.findElement(By.id("options_20301_hour"))).selectByVisibleText("01");
    new Select(driver.findElement(By.id("options_20300_hour"))).selectByVisibleText("01");
    driver.findElement(By.cssSelector("#options_20300_hour > option[value=\"1\"]")).click();
    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
            ,driver.findElement(By.xpath("(//button[@type='button'])[4]")));
    driver.findElement(By.xpath("(//button[@type='button'])[4]")).click();
    TimeUnit.SECONDS.sleep(5);
    assertEquals("Engraved Swarovski Crystal Heart Vase was updated in your shopping cart.", driver.findElement(By.cssSelector("li > span")).getText());
    driver.findElement(By.xpath("//div/div[3]/div/span")).click();
    TimeUnit.SECONDS.sleep(3);
    assertEquals("1/1/2014 1:00 AM", driver.findElement(By.cssSelector("dd")).getText());
    assertEquals("01:00 am", driver.findElement(By.xpath("//dd[2]")).getText());
    assertEquals("777 - £777.00", driver.findElement(By.xpath("//dd[3]")).getText());
    assertEquals("888 - £888.00", driver.findElement(By.xpath("//dd[4]")).getText());
    assertEquals("TEST QA", driver.findElement(By.xpath("//dd[5]")).getText());
    driver.findElement(By.cssSelector("button.mfp-close")).click();
    TimeUnit.SECONDS.sleep(5);
    driver.findElement(By.xpath("//div[@class='item']/div[7]/a")).click();
    TimeUnit.SECONDS.sleep(5);
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
