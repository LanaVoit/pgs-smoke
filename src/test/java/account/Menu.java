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

public class Menu extends PGS.pages.TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

    @Test
  public void testUntitled7() throws Exception {
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
    assertEquals("Account Dashboard", driver.findElement(By.cssSelector("strong")).getText());
    driver.findElement(By.linkText("Account Information")).click();
    assertEquals("Edit Account Information", driver.findElement(By.cssSelector("h1")).getText());
    driver.findElement(By.linkText("Address Book")).click();
    assertEquals("Address Book", driver.findElement(By.cssSelector("h1")).getText());
    driver.findElement(By.linkText("My Orders")).click();
    assertEquals("My Orders", driver.findElement(By.cssSelector("h1")).getText());
    driver.findElement(By.linkText("Billing Agreements")).click();
    assertEquals("Billing agreements", driver.findElement(By.cssSelector("h1")).getText());
    driver.findElement(By.linkText("Recurring Profiles")).click();
    assertEquals("Recurring Profiles", driver.findElement(By.cssSelector("h1")).getText());
    driver.findElement(By.linkText("My Product Reviews")).click();
    assertEquals("My Product Reviews", driver.findElement(By.cssSelector("h1")).getText());
    driver.findElement(By.linkText("My Wishlists")).click();
    assertEquals("My Wishlists", driver.findElement(By.cssSelector("h1")).getText());
    driver.findElement(By.linkText("My Applications")).click();
    assertEquals("My Applications", driver.findElement(By.cssSelector("h1")).getText());
    driver.findElement(By.linkText("My Downloadable Products")).click();
    assertEquals("My Downloadable Products", driver.findElement(By.cssSelector("h1")).getText());
    driver.findElement(By.linkText("Help Desk")).click();
    assertEquals("My Support Tickets", driver.findElement(By.cssSelector("h1")).getText());
    driver.findElement(By.linkText("Product Questions")).click();
    assertEquals("My Product Questions", driver.findElement(By.cssSelector("h1")).getText());
    driver.findElement(By.linkText("Newsletter Subscriptions")).click();
    assertEquals("Newsletter Subscription", driver.findElement(By.cssSelector("h1")).getText());
    driver.findElement(By.linkText("Shop Credit")).click();
    assertEquals("Store Credit", driver.findElement(By.cssSelector("h1")).getText());
    driver.findElement(By.linkText("Gift Card")).click();
    assertEquals("Gift card", driver.findElement(By.cssSelector("h1")).getText());
    driver.findElement(By.linkText("Gift Registry")).click();
    assertEquals("Gift Registry", driver.findElement(By.cssSelector("h1")).getText());
    driver.findElement(By.linkText("Reward Points")).click();
    assertEquals("Reward points", driver.findElement(By.cssSelector("h1")).getText());
    driver.findElement(By.linkText("My Invitations")).click();
    assertEquals("My Invitations", driver.findElement(By.cssSelector("h1")).getText());
    driver.findElement(By.linkText("Google Connect")).click();
    assertEquals("Google Connect", driver.findElement(By.cssSelector("h1")).getText());
    driver.findElement(By.linkText("Facebook Connect")).click();
    assertEquals("Facebook Connect", driver.findElement(By.cssSelector("h1")).getText());
    driver.findElement(By.linkText("Twitter Connect")).click();
    assertEquals("Twitter Connect", driver.findElement(By.cssSelector("h1")).getText());
    driver.findElement(By.linkText("Sign Out")).click();
    assertEquals("You are now logged out", driver.findElement(By.cssSelector("h1")).getText());

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
