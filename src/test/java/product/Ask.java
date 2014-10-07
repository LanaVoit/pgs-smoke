package product;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.testng.*;
import org.testng.annotations.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Ask extends PGS.pages.TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  
  
    @Test
  public void testUntitled10() throws Exception {
    	
 
    	
    	driver.manage().window().maximize();
	Actions actions = new Actions(driver);
    driver.get(baseUrl + "personalised-swarovski-crystal-heart-vase.html");
    TimeUnit.SECONDS.sleep(5);
    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
            ,driver.findElement(By.cssSelector("dt.tab.last > span")));
    driver.findElement(By.cssSelector("dt.tab.last > span")).click();
    TimeUnit.SECONDS.sleep(5);
    driver.findElement(By.cssSelector("button[title=\"Ask Question\"]")).click();
    driver.findElement(By.cssSelector("button[title=\"Send Question\"]")).click();
    assertEquals("Name", driver.findElement(By.id("advice-required-entry-question_author_name")).getText());
    assertEquals("Email Address", driver.findElement(By.id("advice-required-entry-question_author_email")).getText());
    assertEquals("Question Content", driver.findElement(By.id("advice-required-entry-question_content")).getText());
    driver.findElement(By.id("question_author_name")).clear();
    driver.findElement(By.id("question_author_name")).sendKeys("test");
    driver.findElement(By.id("question_author_email")).clear();
    driver.findElement(By.id("question_author_email")).sendKeys("test@test.com");
    driver.findElement(By.id("question_content")).clear();
    driver.findElement(By.id("question_content")).sendKeys("test");
    TimeUnit.SECONDS.sleep(5);
    driver.findElement(By.cssSelector("#aw-pq2-question-form > div.buttons-set > button.button.btn-primary.aw-pq2-form__button")).click();
    HttpClient client = new DefaultHttpClient();
    HttpPost post = new HttpPost("http://dev.personalisedgiftsshop.co.uk/default/productquestion/question/add/");
    post.getURI();
    waitForAjax(100000);
    TimeUnit.SECONDS.sleep(10);
    assertEquals("Your question has been received. A notification will be sent once the answer is published.", driver.findElement(By.cssSelector("li > span")).getText());
    TimeUnit.SECONDS.sleep(5);
    driver.get(baseUrl + "admin");
    driver.findElement(By.id("username")).clear();
    driver.findElement(By.id("username")).sendKeys("admin");
    driver.findElement(By.id("login")).clear();
    driver.findElement(By.id("login")).sendKeys("admin123");
    driver.findElement(By.cssSelector("input.form-button")).click();
    driver.findElement(By.cssSelector("a[title=\"close\"] > span")).click();
    TimeUnit.SECONDS.sleep(5);
    actions.moveToElement(driver.findElement(By.xpath("//ul[@id='nav']/li[3]/a/span"))).build().perform();
    actions.moveToElement(driver.findElement(By.xpath("//ul[@id='nav']/li[3]/ul/li[10]/a/span"))).build().perform();
    driver.findElement(By.xpath("//ul[@id='nav']/li[3]/ul/li[10]/ul/li/a/span")).click();
    driver.findElement(By.id("pq2QuestionPendingGrid_filter_author_email")).clear();
    driver.findElement(By.id("pq2QuestionPendingGrid_filter_author_email")).sendKeys("test@test.com");
    driver.findElement(By.cssSelector("button[title=\"Search\"]")).click();
    TimeUnit.SECONDS.sleep(5);
    driver.findElement(By.cssSelector("input[name=\"id\"]")).click();
    TimeUnit.SECONDS.sleep(5);
    new Select(driver.findElement(By.id("pq2QuestionPendingGrid_massaction-select"))).selectByVisibleText("Change status");
    new Select(driver.findElement(By.id("visibility"))).selectByVisibleText("Approved");
    driver.findElement(By.cssSelector("button[title=\"Submit\"]")).click();
    TimeUnit.SECONDS.sleep(5);
    assertEquals("1 question has been updated successfully", driver.findElement(By.cssSelector("li > span")).getText());
    driver.get(baseUrl + "personalised-swarovski-crystal-heart-vase.html");
    TimeUnit.SECONDS.sleep(5);
    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
            ,driver.findElement(By.cssSelector("dt.tab.last > span")));
    driver.findElement(By.cssSelector("dt.tab.last > span")).click();
    TimeUnit.SECONDS.sleep(5);
    assertEquals("test", driver.findElement(By.cssSelector("ul.aw-pq2-list > li:last-child > div.aw-pq2-list__question-wrapper > div.aw-pq2-list__question > span.aw-pq2-list__question-content")).getText());
    TimeUnit.SECONDS.sleep(10);
  }
    
    public void waitForAjax(int timeoutInSeconds) {
    	System.out.println("Checking active ajax calls by calling jquery.active");
    	try {
    	if (driver instanceof JavascriptExecutor) {
    	       JavascriptExecutor jsDriver = (JavascriptExecutor)driver;

    	for (int i = 0; i< timeoutInSeconds; i++) 
    	    {
    	       Object numberOfAjaxConnections = jsDriver.executeScript("return jQuery.active");
    	       // return should be a number
    	       if (numberOfAjaxConnections instanceof Long) {
    	       Long n = (Long)numberOfAjaxConnections;
    	       System.out.println("Number of active jquery ajax calls: " + n);
    	       if (n.longValue() == 0L)
    	       break;
    	     }
    	     Thread.sleep(6000);
    	     }
    	}
    	     else {
    	           System.out.println("Web driver: " + driver + " cannot execute javascript");
    	           }
    	}
    	          catch (InterruptedException e) {
    	          System.out.println(e);
    	          }
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
