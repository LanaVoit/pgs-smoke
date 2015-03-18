package listing;

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

public class Add_to_wishlist extends PGS.pages.TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

    @Test
  public void Add_to_wishlist() throws Exception {	
	driver.manage().window().maximize(); 
	Actions actions = new Actions(driver);
    driver.get(baseUrl + "personalised-birthday-gifts/for-babies.html");
    TimeUnit.SECONDS.sleep(3);
    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
            ,driver.findElement(By.xpath("//*[@id='item-12']")));
    actions.moveToElement(driver.findElement(By.xpath("//*[@id='item-12']"))).build().perform(); 
    TimeUnit.SECONDS.sleep(5);
    String heart_test = "rgba(0, 0, 0, 0) url(data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAA0AAAAMCAYAAAC5tzfZAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAyJpVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADw/eHBhY2tldCBiZWdpbj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDUuMy1jMDExIDY2LjE0NTY2MSwgMjAxMi8wMi8wNi0xNDo1NjoyNyAgICAgICAgIj4gPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4gPHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9IiIgeG1sbnM6eG1wPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvIiB4bWxuczp4bXBNTT0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wL21tLyIgeG1sbnM6c3RSZWY9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9zVHlwZS9SZXNvdXJjZVJlZiMiIHhtcDpDcmVhdG9yVG9vbD0iQWRvYmUgUGhvdG9zaG9wIENTNiAoV2luZG93cykiIHhtcE1NOkluc3RhbmNlSUQ9InhtcC5paWQ6Njk5NTBGMjZFQTMzMTFFMzhFRjJFN0IwNjI0MTEyRDgiIHhtcE1NOkRvY3VtZW50SUQ9InhtcC5kaWQ6Njk5NTBGMjdFQTMzMTFFMzhFRjJFN0IwNjI0MTEyRDgiPiA8eG1wTU06RGVyaXZlZEZyb20gc3RSZWY6aW5zdGFuY2VJRD0ieG1wLmlpZDo2OTk1MEYyNEVBMzMxMUUzOEVGMkU3QjA2MjQxMTJEOCIgc3RSZWY6ZG9jdW1lbnRJRD0ieG1wLmRpZDo2OTk1MEYyNUVBMzMxMUUzOEVGMkU3QjA2MjQxMTJEOCIvPiA8L3JkZjpEZXNjcmlwdGlvbj4gPC9yZGY6UkRGPiA8L3g6eG1wbWV0YT4gPD94cGFja2V0IGVuZD0iciI/Pg/qM6wAAADXSURBVHjaYmQAgoqKCkcg1Q3ERkD8HojnA3ELENcAcSIQCwLxOSAu7ejo2M8I1GAD5OwDYlYGVPAViLnRxH4DsRMTkGjHooEBiwYGqLp2kCZLBtKAJUjTHxI1/WGC+ocUsA+kqQzqaWIASF0ZIzTInYDUViDmwKPhFxB7AoN8HyNMBKjRD0itwRGSoKAOAWrYBOIwIssANUYBqcVAzIQk/A+I44AalsIEmJE1HTly5LKNjc1zINMXSTgdqGEBsjpmdHcANZ4DanwJZLoCcS5Qwyx0NQABBgDPrTbahsrmXAAAAABJRU5ErkJggg==) no-repeat scroll 50% 50% / auto padding-box border-box";        
    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
            ,driver.findElement(By.xpath("//*[@id='item-12']")));
    assertEquals(heart_test, driver.findElement(By.cssSelector("a[title=\"Add to Wishlist\"]")).getCssValue("background").toString());
    TimeUnit.SECONDS.sleep(5);
    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
            ,driver.findElement(By.xpath("//*[@id='item-12']")));
    TimeUnit.SECONDS.sleep(5);
    actions.moveToElement(driver.findElement(By.xpath("//*[@id='item-12']"))).build().perform(); 
    TimeUnit.SECONDS.sleep(5);
    driver.findElement(By.xpath("//*[@id='item-12']/a[2]")).click();
    TimeUnit.SECONDS.sleep(5);    
    driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("qatestingtestqa@gmail.com");
    driver.findElement(By.id("pass")).clear();
    driver.findElement(By.id("pass")).sendKeys("qwerty");
    driver.findElement(By.id("send2")).click();
    TimeUnit.SECONDS.sleep(10);
    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
            ,driver.findElement(By.xpath("//*[@id='item-12']")));
    actions.moveToElement(driver.findElement(By.xpath("//*[@id='item-12']"))).build().perform(); 
    TimeUnit.SECONDS.sleep(5);    
    driver.findElement(By.xpath("//*[@id='item-12']/a[2]")).click();
    TimeUnit.SECONDS.sleep(5);
    driver.findElement(By.cssSelector("span")).click();
    TimeUnit.SECONDS.sleep(5);
    assertEquals("Personalised Children's Pirate Ship Money Box has been added to your wishlist.", driver.findElement(By.cssSelector("span")).getText());
    driver.findElement(By.cssSelector("button.mfp-close")).click();
    TimeUnit.SECONDS.sleep(5);
    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
            ,driver.findElement(By.xpath("//*[@id='item-12']")));
    actions.moveToElement(driver.findElement(By.xpath("//*[@id='item-12']"))).build().perform(); 
    TimeUnit.SECONDS.sleep(5);
    String heart_test_red = "rgba(0, 0, 0, 0) url(data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAA0AAAAMCAYAAAC5tzfZAAAAGXRFWHRTb2Z0d2FyZQBBZG9iZSBJbWFnZVJlYWR5ccllPAAAAyJpVFh0WE1MOmNvbS5hZG9iZS54bXAAAAAAADw/eHBhY2tldCBiZWdpbj0i77u/IiBpZD0iVzVNME1wQ2VoaUh6cmVTek5UY3prYzlkIj8+IDx4OnhtcG1ldGEgeG1sbnM6eD0iYWRvYmU6bnM6bWV0YS8iIHg6eG1wdGs9IkFkb2JlIFhNUCBDb3JlIDUuMy1jMDExIDY2LjE0NTY2MSwgMjAxMi8wMi8wNi0xNDo1NjoyNyAgICAgICAgIj4gPHJkZjpSREYgeG1sbnM6cmRmPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5LzAyLzIyLXJkZi1zeW50YXgtbnMjIj4gPHJkZjpEZXNjcmlwdGlvbiByZGY6YWJvdXQ9IiIgeG1sbnM6eG1wPSJodHRwOi8vbnMuYWRvYmUuY29tL3hhcC8xLjAvIiB4bWxuczp4bXBNTT0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wL21tLyIgeG1sbnM6c3RSZWY9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9zVHlwZS9SZXNvdXJjZVJlZiMiIHhtcDpDcmVhdG9yVG9vbD0iQWRvYmUgUGhvdG9zaG9wIENTNiAoV2luZG93cykiIHhtcE1NOkluc3RhbmNlSUQ9InhtcC5paWQ6NzExQzBDOURFQTMzMTFFM0IzNDhFM0JCRkI4QkE5NzIiIHhtcE1NOkRvY3VtZW50SUQ9InhtcC5kaWQ6NzExQzBDOUVFQTMzMTFFM0IzNDhFM0JCRkI4QkE5NzIiPiA8eG1wTU06RGVyaXZlZEZyb20gc3RSZWY6aW5zdGFuY2VJRD0ieG1wLmlpZDo3MTFDMEM5QkVBMzMxMUUzQjM0OEUzQkJGQjhCQTk3MiIgc3RSZWY6ZG9jdW1lbnRJRD0ieG1wLmRpZDo3MTFDMEM5Q0VBMzMxMUUzQjM0OEUzQkJGQjhCQTk3MiIvPiA8L3JkZjpEZXNjcmlwdGlvbj4gPC9yZGY6UkRGPiA8L3g6eG1wbWV0YT4gPD94cGFja2V0IGVuZD0iciI/Pl86bI8AAADJSURBVHjaYvz//z/DtzQ2RwYGhm4gNgLi90A8H4hbgLgGiBOBWBCIzwFxKdesX/sZv6ay2gA5+4CYlQEVfAVibjSx30DsxAQk2rFoYMCigQGqrh2kyZKBNGAJ0vSHRE1/mKD+IQXsA2kqg3qaGABSV8YEDMIrQIYfEP8goOEXSB1IPcgmBiAD5MRwaJBiAyDxUKg6BiaYKFBgE5BKAOJ/aBpA/ESoPAOKJqjGZUAqA01TBlB8KYoIKBmhY2AqyQDiHyAamzxAgAEAlrFX0yGTZSkAAAAASUVORK5CYII=) no-repeat scroll 50% 50% / auto padding-box border-box";    
    assertEquals(heart_test_red, driver.findElement(By.cssSelector("a[title=\"Add to Wishlist\"]")).getCssValue("background").toString());   
    driver.get(baseUrl + "wishlist");
    /*WebElement my_account = driver.findElement(By.id("myaccount-menu-link"));
    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
            ,my_account);
    TimeUnit.SECONDS.sleep(5);
    actions.moveToElement(my_account).build().perform();
    driver.findElement(By.xpath("/html/body/div[2]/div[4]/div/div/div/ul/li[3]/a")).click();*/
    TimeUnit.SECONDS.sleep(5);
    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
            ,driver.findElement(By.cssSelector("img[alt=\"Personalised Children's Pirate Ship Money Box\"]")));
    TimeUnit.SECONDS.sleep(5);
    
    driver.findElement(By.linkText("Remove item")).click();
    assertTrue(closeAlertAndGetItsText().matches("^Are you sure you want to remove this product from your wishlist[\\s\\S]$"));
    TimeUnit.SECONDS.sleep(10);
    assertEquals("(0 items)", driver.findElement(By.cssSelector("span.item-count")).getText());  
    TimeUnit.SECONDS.sleep(5);
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
