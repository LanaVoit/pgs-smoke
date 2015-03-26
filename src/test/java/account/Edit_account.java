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

public class Edit_account extends PGS.pages.TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

    @Test
  public void Edit_account() throws Exception {
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
    driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[4]/div[1]/div/div[2]/div[1]/div[1]/div[1]/a")).click();
    TimeUnit.SECONDS.sleep(3);
    driver.findElement(By.id("firstname")).clear();
    driver.findElement(By.id("firstname")).sendKeys("Tom2");
    driver.findElement(By.id("lastname")).clear();
    driver.findElement(By.id("lastname")).sendKeys("Johns2");
    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
            ,driver.findElement(By.xpath("(//button[@type='submit'])[2]")));
    driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
    TimeUnit.SECONDS.sleep(10);
    assertEquals("The account information has been saved.", driver.findElement(By.cssSelector("li > span")).getText());
    assertEquals("GREAT TO SEE YOU, TOM2 JOHNS2!", driver.findElement(By.cssSelector("h3.hello")).getText());
    TimeUnit.SECONDS.sleep(10);
    driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[4]/div[1]/div/div[2]/div[1]/div[1]/div[1]/a")).click();
    TimeUnit.SECONDS.sleep(3);
    driver.findElement(By.id("firstname")).clear();
    driver.findElement(By.id("firstname")).sendKeys("Tom");
    driver.findElement(By.id("lastname")).clear();
    driver.findElement(By.id("lastname")).sendKeys("Johns");
    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
            ,driver.findElement(By.xpath("(//button[@type='submit'])[2]")));

    driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
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
