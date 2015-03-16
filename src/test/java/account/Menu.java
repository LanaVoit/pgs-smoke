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
  public void Menu() throws Exception {
	driver.manage().window().maximize();
	Actions actions = new Actions(driver);
	driver.get(baseUrl + "customer/account/login/");
	TimeUnit.SECONDS.sleep(5);
	driver.findElement(By.id("email")).clear();
	driver.findElement(By.id("email")).sendKeys("qatestingtestqa@gmail.com");
	driver.findElement(By.id("pass")).clear();
	driver.findElement(By.id("pass")).sendKeys("qwerty");
	driver.findElement(By.id("send2")).click();
	TimeUnit.SECONDS.sleep(5);
	assertEquals("MY DASHBOARD", driver.findElement(By.cssSelector("h1")).getText());
    assertEquals("GREAT TO SEE YOU, TOM JOHNS!", driver.findElement(By.cssSelector("h3.hello")).getText());
    TimeUnit.SECONDS.sleep(3);
    assertEquals("MY ACCOUNT", driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[3]/div/div[1]/h3")).getText());
    driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[3]/div/div[2]/ul/li[2]/a")).click();
    assertEquals("EDIT ACCOUNT INFORMATION", driver.findElement(By.cssSelector("h1")).getText());
    TimeUnit.SECONDS.sleep(3);
    driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[3]/div/div[2]/ul/li[3]/a")).click();
    assertEquals("MY ADDRESS BOOK", driver.findElement(By.cssSelector("h1")).getText());
    TimeUnit.SECONDS.sleep(3);
    driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[3]/div/div[2]/ul/li[4]/a")).click();
    assertEquals("MY ORDERS", driver.findElement(By.cssSelector("h1")).getText());
    TimeUnit.SECONDS.sleep(3);
    /*driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[3]/div/div[2]/ul/li[5]/a")).click();
    assertEquals("BILLING AGREEMENTS", driver.findElement(By.cssSelector("h1")).getText());
    TimeUnit.SECONDS.sleep(3);
    driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[3]/div/div[2]/ul/li[6]/a")).click();
    assertEquals("RECURRING PROFILES", driver.findElement(By.cssSelector("h1")).getText());
    TimeUnit.SECONDS.sleep(3);
    driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[3]/div/div[2]/ul/li[7]/a")).click();
    assertEquals("MY TAGS", driver.findElement(By.cssSelector("h1")).getText());
    TimeUnit.SECONDS.sleep(3);
    driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[3]/div/div[2]/ul/li[8]/a")).click();
    assertEquals("MY WISHLISTS", driver.findElement(By.cssSelector("h1")).getText());
    TimeUnit.SECONDS.sleep(3);
    driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[3]/div/div[2]/ul/li[9]/a")).click();
    assertEquals("MY APPLICATIONS", driver.findElement(By.cssSelector("h1")).getText());
    TimeUnit.SECONDS.sleep(3);
    driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[3]/div/div[2]/ul/li[10]/a")).click();
    assertEquals("MY DOWNLOADABLE PRODUCTS", driver.findElement(By.cssSelector("h1")).getText());
    TimeUnit.SECONDS.sleep(3);
    driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[3]/div/div[2]/ul/li[11]/a")).click();
    assertEquals("MY SUPPORT TICKETS", driver.findElement(By.cssSelector("h1")).getText());
    TimeUnit.SECONDS.sleep(3);
    driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[3]/div/div[2]/ul/li[12]/a")).click();
    assertEquals("MY PRODUCT QUESTIONS", driver.findElement(By.cssSelector("h1")).getText());
    TimeUnit.SECONDS.sleep(3);
    driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[3]/div/div[2]/ul/li[13]/a")).click();
    assertEquals("NEWSLETTER SUBSCRIPTION", driver.findElement(By.cssSelector("h1")).getText());
    TimeUnit.SECONDS.sleep(3);
    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
            ,driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[3]/div/div[2]/ul/li[14]/a")));
    driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[3]/div/div[2]/ul/li[14]/a")).click();
    assertEquals("MY STORE CREDIT", driver.findElement(By.cssSelector("h1")).getText());
    TimeUnit.SECONDS.sleep(3);
    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
            ,driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[3]/div/div[2]/ul/li[15]/a")));
    driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[3]/div/div[2]/ul/li[15]/a")).click();
    assertEquals("MY GIFT CARD", driver.findElement(By.cssSelector("h1")).getText());
    TimeUnit.SECONDS.sleep(3);
    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
            ,driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[3]/div/div[2]/ul/li[16]/a")));
    driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[3]/div/div[2]/ul/li[16]/a")).click();
    assertEquals("MY GIFT REGISTRY", driver.findElement(By.cssSelector("h1")).getText());
    TimeUnit.SECONDS.sleep(7);
    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
            ,driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[3]/div/div[2]/ul/li[17]/a")));
    driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[3]/div/div[2]/ul/li[17]/a")).click();
    assertEquals("MY INVITATIONS", driver.findElement(By.cssSelector("h1")).getText());
    TimeUnit.SECONDS.sleep(3);
    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
            ,driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[3]/div/div[2]/ul/li[18]/a")));
    driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[3]/div/div[2]/ul/li[18]/a")).click();
    assertEquals("REWARD POINTS", driver.findElement(By.cssSelector("h1")).getText());
    TimeUnit.SECONDS.sleep(3);*/
    driver.get(baseUrl + "customer/account/logout");
    TimeUnit.SECONDS.sleep(7);
    assertEquals("YOU ARE NOW LOGGED OUT", driver.findElement(By.cssSelector("h1")).getText());
    driver.get(baseUrl + "customer/account/login/");
    TimeUnit.SECONDS.sleep(10);

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
