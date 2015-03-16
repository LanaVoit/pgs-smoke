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


public class Js_checkout extends PGS.pages.TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

    @Test
  public void Js_checkout() throws Exception {
    	Actions actions = new Actions(driver);
    	driver.manage().window().maximize();
        driver.get(baseUrl + "personalised-door-plaque-for-girls-animal-alphabet.html");
        WebElement add_to_cart = driver.findElement(By.cssSelector("button[title=\"Add to Basket\"]"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
                ,add_to_cart);   
        add_to_cart.click();      
        TimeUnit.SECONDS.sleep(5);
        driver.get(baseUrl + "checkout/onepage/");     
        TimeUnit.SECONDS.sleep(5);
        
        
        WebElement h1 = driver.findElement(By.tagName("h1"));
        assertEquals ("SECURE CHECKOUT", h1.getText());
        
        Logs log = driver.manage().logs();
        List<LogEntry> logsEntries = log.get("browser").getAll();
        List<String> list = new ArrayList<String>();
        list.isEmpty();
        for (LogEntry entry: logsEntries) {        	
    		System.out.println(entry.getMessage());  
        }

		    assertEquals(list, logsEntries);
		    driver.get(baseUrl + "checkout/cart/");
		    driver.findElement(By.xpath("//div[@class='item']/div[7]/a")).click();
		    TimeUnit.SECONDS.sleep(5);
		    assertEquals("SHOPPING CART IS EMPTY", driver.findElement(By.cssSelector("h1")).getText());
		   // driver.quit(); 
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
