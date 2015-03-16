package account;

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

public class Address extends PGS.pages.TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

    @Test
  public void testUntitled3() throws Exception {
	driver.manage().window().maximize();
	Actions actions = new Actions(driver);
    driver.get(baseUrl + "customer/account/login/");
    TimeUnit.SECONDS.sleep(5);
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("qatestingtestqa@gmail.com");
    driver.findElement(By.id("pass")).clear();
    driver.findElement(By.id("pass")).sendKeys("qwerty");
    driver.findElement(By.id("send2")).click();
    TimeUnit.SECONDS.sleep(3);
    assertEquals("MY DASHBOARD", driver.findElement(By.cssSelector("h1")).getText());
    assertEquals("GREAT TO SEE YOU, TOM JOHNS!", driver.findElement(By.cssSelector("h3.hello")).getText());
    TimeUnit.SECONDS.sleep(3);
    driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[3]/div/div[2]/ul/li[3]/a")).click();
    assertEquals("MY ADDRESS BOOK", driver.findElement(By.cssSelector("h1")).getText());
    TimeUnit.SECONDS.sleep(3);
    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
            ,driver.findElement(By.cssSelector("div.buttons-set > button.button")));
    driver.findElement(By.cssSelector("div.buttons-set > button.button")).click();
    TimeUnit.SECONDS.sleep(5);
    driver.findElement(By.id("telephone")).clear();
    driver.findElement(By.id("telephone")).sendKeys("123456789");
    driver.findElement(By.id("zip")).clear();
    driver.findElement(By.id("zip")).sendKeys("AA11AA");
    driver.findElement(By.id("_cp_button_id")).click();
    new Select(driver.findElement(By.id("crafty_postcode_lookup_result_option1"))).selectByVisibleText("THE BAKERY, 1 High Street, Crafty Valley, BIG CITY");
    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
            ,driver.findElement(By.cssSelector("div.buttons-set.form-buttons > button.button")));
    driver.findElement(By.cssSelector("div.buttons-set.form-buttons > button.button")).click();
    TimeUnit.SECONDS.sleep(5);
    assertEquals("The address has been saved.", driver.findElement(By.cssSelector("li > span")).getText());
    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
            ,driver.findElement(By.xpath("(//a[contains(text(),'Delete Address')])[5]")));
    driver.findElement(By.xpath("(//a[contains(text(),'Delete Address')])[5]")).click();
    assertTrue(closeAlertAndGetItsText().matches("^Are you sure you want to delete this address[\\s\\S]$"));
    TimeUnit.SECONDS.sleep(5);
    assertEquals("The address has been deleted.", driver.findElement(By.cssSelector("li > span")).getText());
    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
            ,driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[3]/div/div[2]/ul/li[19]/a")));
    driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[3]/div/div[2]/ul/li[19]/a")).click();
    TimeUnit.SECONDS.sleep(3);
    assertEquals("YOU ARE NOW LOGGED OUT", driver.findElement(By.cssSelector("h1")).getText());
    driver.get(baseUrl + "customer/account/login/");

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
