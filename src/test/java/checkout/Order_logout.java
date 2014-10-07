package checkout;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.*;
import org.testng.annotations.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Order_logout extends PGS.pages.TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

    @Test
  public void testUntitled10() throws Exception {
	driver.manage().window().maximize();
    driver.get(baseUrl + "personalised-swarovski-crystal-heart-vase.html");
    driver.findElement(By.xpath("//button[@type='button']")).click();
    driver.get(baseUrl + "/default/checkout/cart/");
    driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
    TimeUnit.SECONDS.sleep(5);
    driver.findElement(By.id("billing:firstname")).clear();
    driver.findElement(By.id("billing:firstname")).sendKeys("Tom");
    driver.findElement(By.id("billing:lastname")).clear();
    driver.findElement(By.id("billing:lastname")).sendKeys("Green");
    driver.findElement(By.id("billing:email")).clear();
    driver.findElement(By.id("billing:email")).sendKeys("qatestingtestqa@mail.ru");
    driver.findElement(By.id("billing:telephone")).clear();
    driver.findElement(By.id("billing:telephone")).sendKeys("89465123213");
    driver.findElement(By.id("billing:postcode")).clear();
    driver.findElement(By.id("billing:postcode")).sendKeys("AA11AA");
    driver.findElement(By.id("billing_cp_button_id")).click();
    new Select(driver.findElement(By.id("crafty_postcode_lookup_result_option1"))).selectByVisibleText("THE BAKERY, 1 High Street, Crafty Valley, BIG CITY");
    driver.findElement(By.cssSelector("#billing-buttons-container > button.button.btn-primary")).click();
    TimeUnit.SECONDS.sleep(5);
    driver.findElement(By.id("s_method_freeshipping_freeshipping")).click();
    driver.findElement(By.cssSelector("#shipping-method-buttons-container > button.button.btn-primary")).click();
    TimeUnit.SECONDS.sleep(5);
    driver.findElement(By.id("p_method_ccsave")).click();
    driver.findElement(By.xpath("//ul[@id='checkout-payment-method-load']/li[4]/div/label")).click();
    driver.findElement(By.id("ccsave_cc_owner")).clear();
    driver.findElement(By.id("ccsave_cc_owner")).sendKeys("Tom Green");
    new Select(driver.findElement(By.id("ccsave_cc_type"))).selectByVisibleText("Visa");
    driver.findElement(By.id("ccsave_cc_number")).clear();
    driver.findElement(By.id("ccsave_cc_number")).sendKeys("4444333322221111");
    new Select(driver.findElement(By.id("ccsave_expiration"))).selectByVisibleText("01 - January");
    new Select(driver.findElement(By.id("ccsave_expiration_yr"))).selectByVisibleText("2017");
    driver.findElement(By.cssSelector("#payment-buttons-container > button.button.btn-primary")).click();
    TimeUnit.SECONDS.sleep(5);
    driver.findElement(By.xpath("(//button[@type='submit'])[3]")).click();
    TimeUnit.SECONDS.sleep(5);
    assertEquals("Thank you for your subscription.", driver.findElement(By.cssSelector("li > span")).getText());
    assertEquals("A big thank you. Now see below what you can do", driver.findElement(By.cssSelector("h1")).getText());

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
