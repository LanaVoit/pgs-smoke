package login;

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

public class Login extends PGS.pages.TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

    @Test
  public void testUntitled2() throws Exception {
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
    WebElement my_account = driver.findElement(By.id("myaccount-menu-link"));
    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
            ,my_account);
    TimeUnit.SECONDS.sleep(5);
    actions.moveToElement(my_account).build().perform();
    TimeUnit.SECONDS.sleep(5);
    driver.findElement(By.xpath("(//a[contains(text(),'Sign Out')])[2]")).click();
    TimeUnit.SECONDS.sleep(5);
    assertEquals("Sign In", driver.findElement(By.linkText("Sign In")).getText());
    assertEquals("register", driver.findElement(By.linkText("register")).getText());
    String title = driver.getTitle();
    String title_test = "Home page";
    TimeUnit.SECONDS.sleep(5);
    assertEquals(title_test, title);
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
