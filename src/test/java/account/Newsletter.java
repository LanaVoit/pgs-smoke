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

public class Newsletter extends PGS.pages.TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

    @Test
  public void Newsletter() throws Exception {
    driver.manage().window().setSize(new Dimension(1366, 1050));
	Actions actions = new Actions(driver);
    driver.get(baseUrl + "customer/account/login/");
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("qatestingtestqa@gmail.com");
    driver.findElement(By.id("pass")).clear();
    driver.findElement(By.id("pass")).sendKeys("qwerty");
    driver.findElement(By.id("send2")).click();
    TimeUnit.SECONDS.sleep(5);
    assertEquals("MY DASHBOARD", driver.findElement(By.cssSelector("h1")).getText());
    assertEquals("GREAT TO SEE YOU, TOM JOHNS!", driver.findElement(By.cssSelector("h3.hello")).getText());
    TimeUnit.SECONDS.sleep(3);
    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
            ,driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[3]/div/div[2]/ul/li[13]/a")));
    driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[3]/div/div[2]/ul/li[13]/a")).click();   
    TimeUnit.SECONDS.sleep(3);
    driver.findElement(By.id("list-1b734fadd7")).click();
    driver.findElement(By.id("list-76ad4233d2")).click();
    driver.findElement(By.cssSelector("div.buttons-set > button.button")).click();
    TimeUnit.SECONDS.sleep(3);
    driver.findElement(By.id("list-76ad4233d2")).click();
    driver.findElement(By.id("list-1b734fadd7")).click();
    driver.findElement(By.cssSelector("div.buttons-set > button.button")).click();
    TimeUnit.SECONDS.sleep(3);
    WebElement signout = driver.findElement(By.linkText("Sign Out"));
    WebElement my_account = driver.findElement(By.linkText("My Account"));
    actions.moveToElement(my_account).build().perform();
    signout.click();

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
