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
  public void testUntitled7() throws Exception {
	driver.manage().window().maximize();
    driver.get(baseUrl + "personalised-swarovski-crystal-heart-vase.html");
    driver.findElement(By.id("options_20310_text")).clear();
    driver.findElement(By.id("options_20310_text")).sendKeys("test test tes");
    assertEquals("13 of 13 Characters", driver.findElement(By.xpath("//fieldset[@id='product-options-wrapper']/div/dl/dd/div/p[2]")).getText());
    new Select(driver.findElement(By.id("options_20301_month"))).selectByVisibleText("01");
    new Select(driver.findElement(By.id("options_20301_day"))).selectByVisibleText("01");
    new Select(driver.findElement(By.id("options_20301_year"))).selectByVisibleText("2014");
    new Select(driver.findElement(By.id("options_20301_hour"))).selectByVisibleText("01");
    new Select(driver.findElement(By.id("options_20301_minute"))).selectByVisibleText("00");
    new Select(driver.findElement(By.id("options_20300_hour"))).selectByVisibleText("01");
    new Select(driver.findElement(By.id("options_20300_minute"))).selectByVisibleText("00");
    driver.findElement(By.id("options_20309_file")).sendKeys("C:\\Users\\Lana\\Pictures\\Screenshot_1.jpg");
    TimeUnit.SECONDS.sleep(5);
    new Select(driver.findElement(By.id("select_20308"))).selectByVisibleText("333 +£333.00");
    driver.findElement(By.xpath("//ul[@id='options-20307-list']/li[1]/span/label")).click();
    driver.findElement(By.xpath("//ul[@id='options-20306-list']/li[1]/span/label")).click();
    driver.findElement(By.xpath("//ul[@id='options-20306-list']/li[2]/span/label")).click(); 
    driver.findElement(By.xpath("//select[@id='select_20305']/option[1]")).click(); 
    new Select(driver.findElement(By.id("options_20302_month"))).selectByVisibleText("01");
    new Select(driver.findElement(By.id("options_20302_day"))).selectByVisibleText("01");
    new Select(driver.findElement(By.id("options_20302_year"))).selectByVisibleText("2014");
    new Select(driver.findElement(By.id("select_20299"))).selectByVisibleText("test1");
    driver.findElement(By.id("options_5005_text")).clear();
    driver.findElement(By.id("options_5005_text")).sendKeys("test test test test");
    driver.findElement(By.id("options_5004_text")).clear();
    driver.findElement(By.id("options_5004_text")).sendKeys("test test test test");
    driver.findElement(By.id("options_5003_text")).clear();
    driver.findElement(By.id("options_5003_text")).sendKeys("test test test test");
    driver.findElement(By.id("options_5002_text")).clear();
    driver.findElement(By.id("options_5002_text")).sendKeys("test test test test");
    driver.findElement(By.id("options_5044_text")).clear();
    driver.findElement(By.id("options_5044_text")).sendKeys("test");
    driver.findElement(By.cssSelector("button[title=\"Add to Basket\"]")).click();
    TimeUnit.SECONDS.sleep(5);
    driver.findElement(By.xpath("//a[2]/span")).click();
    TimeUnit.SECONDS.sleep(5);
    driver.findElement(By.xpath("//div/div[3]/div/span")).click();
    TimeUnit.SECONDS.sleep(3);
    assertEquals("test test tes", driver.findElement(By.cssSelector("dd")).getText());
    assertEquals("1/1/2014 1:00 AM", driver.findElement(By.xpath("//dd[2]")).getText());
    assertEquals("01:00 am", driver.findElement(By.xpath("//dd[3]")).getText());
    assertEquals("Screenshot_1.jpg", driver.findElement(By.linkText("Screenshot_1.jpg")).getText());
    assertEquals("333 - £333.00", driver.findElement(By.xpath("//dd[5]")).getText());
    assertEquals("444 - £444.00", driver.findElement(By.xpath("//dd[6]")).getText());
    assertEquals("555 - £555.00, 555 - £555.00", driver.findElement(By.xpath("//dd[7]")).getText());
    assertEquals("666", driver.findElement(By.xpath("//dd[8]")).getText());
    assertEquals("777 - £777.00", driver.findElement(By.xpath("//dd[9]")).getText());
    assertEquals("888 - £888.00", driver.findElement(By.xpath("//dd[10]")).getText());
    assertEquals("Jan 1, 2014", driver.findElement(By.xpath("//dd[11]")).getText());
    assertEquals("test1", driver.findElement(By.xpath("//dd[12]")).getText());
    assertEquals("test test test test", driver.findElement(By.xpath("//dd[13]")).getText());
    assertEquals("test test test test", driver.findElement(By.xpath("//dd[14]")).getText());
    assertEquals("test test test test", driver.findElement(By.xpath("//dd[15]")).getText());
    assertEquals("test test test test", driver.findElement(By.xpath("//dd[16]")).getText());
    assertEquals("test", driver.findElement(By.xpath("//dd[17]")).getText());
    driver.findElement(By.cssSelector("button.mfp-close")).click();
    TimeUnit.SECONDS.sleep(5);
    driver.findElement(By.xpath("//div/div[7]/a")).click();
    TimeUnit.SECONDS.sleep(5);
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
