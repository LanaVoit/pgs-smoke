package wishlist;

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

public class Create_delete_wishlist extends PGS.pages.TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

    @Test
  public void Create_delete_wishlist() throws Exception {
    	driver.manage().window().setSize(new Dimension(1366, 1050));
	Actions actions = new Actions(driver);
    driver.get(baseUrl + "customer/account/login/");
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("qatestingtestqa@gmail.com");
    driver.findElement(By.id("pass")).clear();
    driver.findElement(By.id("pass")).sendKeys("qwerty");
    TimeUnit.SECONDS.sleep(5);
    driver.findElement(By.id("send2")).click();
    TimeUnit.SECONDS.sleep(5);
    assertEquals("MY DASHBOARD", driver.findElement(By.cssSelector("h1")).getText());
    assertEquals("GREAT TO SEE YOU, TOM JOHNS!", driver.findElement(By.cssSelector("h3.hello")).getText());
    TimeUnit.SECONDS.sleep(3);
    driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[3]/div/div[2]/ul/li[8]/a")).click();
    assertEquals("MY WISHLISTS", driver.findElement(By.cssSelector("h1")).getText());
    TimeUnit.SECONDS.sleep(3);
    driver.findElement(By.id("wishlist-create-button")).click();
    TimeUnit.SECONDS.sleep(3);
    driver.findElement(By.id("wishlist-name")).clear();
    driver.findElement(By.id("wishlist-name")).sendKeys("Test 123");
    driver.findElement(By.cssSelector("button.button.btn-save")).click();
    TimeUnit.SECONDS.sleep(10);
    assertEquals("Wishlist \"Test 123\" was successfully saved", driver.findElement(By.cssSelector("li > span")).getText());
    assertEquals("Test 123 / Edit (0 items)", driver.findElement(By.cssSelector("div.box-title > h3")).getText());
    driver.findElement(By.xpath("//*[@id='wishlist-view-form']/fieldset/div/button/span/span")).click();
    TimeUnit.SECONDS.sleep(7);
    assertTrue(closeAlertAndGetItsText().matches("^You are about to delete your wish list\\.\nThis action cannot be undone\\.\nDo you want to proceed[\\s\\S]$"));
    TimeUnit.SECONDS.sleep(7);
    assertEquals("Wishlist \"Test 123\" has been deleted.", driver.findElement(By.cssSelector("li > span")).getText());
    driver.get(baseUrl + "customer/account/logout");
    TimeUnit.SECONDS.sleep(7);
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
