package account;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.*;
import org.testng.annotations.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Address extends PGS.pages.TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

    @Test
  public void testUntitled3() throws Exception {
	driver.manage().window().maximize();
    driver.get(baseUrl + "customer/account/");
    driver.findElement(By.linkText("Address Book")).click();
    assertEquals("Address Book", driver.findElement(By.cssSelector("h1")).getText());
    driver.findElement(By.cssSelector("div.buttons-set > button.button")).click();
    TimeUnit.SECONDS.sleep(5);
    driver.findElement(By.id("telephone")).clear();
    driver.findElement(By.id("telephone")).sendKeys("123456789");
    driver.findElement(By.id("zip")).clear();
    driver.findElement(By.id("zip")).sendKeys("AA11AA");
    driver.findElement(By.id("_cp_button_id")).click();
    new Select(driver.findElement(By.id("crafty_postcode_lookup_result_option1"))).selectByVisibleText("THE BAKERY, 1 High Street, Crafty Valley, BIG CITY");
    driver.findElement(By.cssSelector("div.buttons-set.form-buttons > button.button")).click();
    TimeUnit.SECONDS.sleep(5);
    assertEquals("The address has been saved.", driver.findElement(By.cssSelector("li > span")).getText());
    driver.findElement(By.xpath("(//a[contains(text(),'Delete Address')])[5]")).click();
    assertTrue(closeAlertAndGetItsText().matches("^Are you sure you want to delete this address[\\s\\S]$"));
    TimeUnit.SECONDS.sleep(5);
    assertEquals("The address has been deleted.", driver.findElement(By.cssSelector("li > span")).getText());

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
