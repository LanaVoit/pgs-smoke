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


public class Js_cart extends PGS.pages.TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

    @Test
  public void Js_cart() throws Exception {
		driver.manage().window().setSize(new Dimension(1366, 1050));
	    driver.get(baseUrl + "personalised-swarovski-crystal-heart-vase.html");
	    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
	            ,driver.findElement(By.cssSelector("button[title=\"Add to Basket\"]")));
	    TimeUnit.SECONDS.sleep(5);
	    driver.findElement(By.cssSelector("button[title=\"Add to Basket\"]")).click();
	    TimeUnit.SECONDS.sleep(5);
	    driver.findElement(By.xpath("//a[2]/span")).click();
	    TimeUnit.SECONDS.sleep(5);
	    assertEquals("YOUR SHOPPING BASKET", driver.findElement(By.cssSelector("h1")).getText());
	    assertEquals("ENGRAVED SWAROVSKI CRYSTAL HEART VASE", driver.findElement(By.xpath("(//a[contains(text(),'Engraved Swarovski Crystal Heart Vase')])[3]")).getText());

        
        Logs log = driver.manage().logs();
        List<LogEntry> logsEntries = log.get("browser").getAll();
        List<String> list = new ArrayList<String>();
        list.isEmpty();
        for (LogEntry entry: logsEntries) {        	
    		System.out.println(entry.getMessage());  
        }

		    assertEquals(list, logsEntries);
		    driver.findElement(By.xpath("//div[@class='item']/div[7]/a")).click();
		    TimeUnit.SECONDS.sleep(10);
		    assertEquals("SHOPPING CART IS EMPTY", driver.findElement(By.cssSelector("h1")).getText());

		    
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
