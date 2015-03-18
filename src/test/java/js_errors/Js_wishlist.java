package js_errors;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.testng.*;
import org.testng.annotations.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.Logs;
import org.openqa.selenium.support.ui.Select;

import net.jsourcerer.webdriver.jserrorcollector.JavaScriptError;


public class Js_wishlist extends PGS.pages.TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

    @Test
  public void Js_wishlist() throws Exception {
    	Actions actions = new Actions(driver);
    	driver.manage().window().maximize();
        driver.get(baseUrl + "customer/account/login/");
        WebElement email = driver.findElement(By.id("email"));
        email.clear();
        email.sendKeys("qatestingtestqa@gmail.com");
        WebElement pass = driver.findElement(By.id("pass"));
        pass.clear();
        pass.sendKeys("qwerty");
        WebElement submit = driver.findElement(By.cssSelector("button[title=\"Login\"]"));
        submit.click();
        TimeUnit.SECONDS.sleep(5);
        WebElement h1 = driver.findElement(By.tagName("h1"));
        assertEquals ("MY DASHBOARD", h1.getText());
        driver.findElement(By.linkText("My Wishlists")).click();
        TimeUnit.SECONDS.sleep(5);
        Logs log = driver.manage().logs();
        List<LogEntry> logsEntries = log.get("browser").getAll();
        List<String> list = new ArrayList<String>();
        list.isEmpty();
        for (LogEntry entry: logsEntries) {        	
    		System.out.println(entry.getMessage());  
    		//driver.quit();
        }
        WebElement signout = driver.findElement(By.linkText("Sign Out"));
        WebElement my_account = driver.findElement(By.linkText("My Account"));
        actions.moveToElement(my_account).build().perform();
        signout.click();
        TimeUnit.SECONDS.sleep(5);
		    assertEquals(list, logsEntries);

		    
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
