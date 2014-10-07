package checkout;

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

public class Order_login_customer extends PGS.pages.TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

    @Test
  public void testUntitled9() throws Exception {
	driver.manage().window().maximize();
	Actions actions = new Actions(driver);
    driver.get(baseUrl + "customer/account/login/");
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("qatestingtestqa@gmail.com");
    driver.findElement(By.id("pass")).clear();
    driver.findElement(By.id("pass")).sendKeys("qwerty");
    driver.findElement(By.id("send2")).click();
    assertEquals("My dashboard", driver.findElement(By.cssSelector("h1")).getText());
    assertEquals("Great to see you, Tom Johns!", driver.findElement(By.cssSelector("h3.hello")).getText());
    TimeUnit.SECONDS.sleep(3);
    driver.get(baseUrl + "personalised-swarovski-crystal-heart-vase.html");
    driver.findElement(By.cssSelector("button[title=\"Add to Basket\"]")).click();
    TimeUnit.SECONDS.sleep(5);
    driver.get(baseUrl + "/default/checkout/cart/");
    driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
    TimeUnit.SECONDS.sleep(5);
    driver.findElement(By.cssSelector("button.button.btn-primary")).click();
    TimeUnit.SECONDS.sleep(5);
    driver.findElement(By.cssSelector("#shipping-method-buttons-container > button.button.btn-primary")).click();
    driver.findElement(By.id("p_method_ccsave")).click();
    TimeUnit.SECONDS.sleep(5);
    driver.findElement(By.xpath("//ul[@id='checkout-payment-method-load']/li[4]/div/label")).click();
    TimeUnit.SECONDS.sleep(5);
    driver.findElement(By.id("ccsave_cc_owner")).clear();
    driver.findElement(By.id("ccsave_cc_owner")).sendKeys("Tom Green");
    new Select(driver.findElement(By.id("ccsave_cc_type"))).selectByVisibleText("Visa");
    driver.findElement(By.id("ccsave_cc_number")).clear();
    driver.findElement(By.id("ccsave_cc_number")).sendKeys("4444333322221111");
    new Select(driver.findElement(By.id("ccsave_expiration"))).selectByVisibleText("01 - January");
    new Select(driver.findElement(By.id("ccsave_expiration_yr"))).selectByVisibleText("2017");
    driver.findElement(By.cssSelector("#payment-buttons-container > button.button.btn-primary")).click();
    TimeUnit.SECONDS.sleep(5);
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    TimeUnit.SECONDS.sleep(5);
    assertEquals("A big thank you Tom now see below what you can do", driver.findElement(By.cssSelector("h1")).getText());
    driver.findElement(By.cssSelector("div.order-success-block > a.button.btn-primary > span")).click();
    assertEquals("Delivery", driver.findElement(By.cssSelector("div.box-title > h3")).getText());
    assertEquals("Billing", driver.findElement(By.xpath("//div[2]/div/div/h3")).getText());
    assertEquals("Items Ordered", driver.findElement(By.cssSelector("h2.table-caption")).getText());
    assertEquals("£42.99", driver.findElement(By.cssSelector("strong > span.price")).getText());
    assertEquals("Grand Total", driver.findElement(By.cssSelector("div.columns.small-3 > strong")).getText());

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
