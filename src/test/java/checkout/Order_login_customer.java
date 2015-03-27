package checkout;

import java.util.regex.Matcher;
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

public class Order_login_customer extends PGS.pages.TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

    @Test
  public void Order_login_customer() throws Exception {
    driver.manage().window().setSize(new Dimension(1366, 1050));
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
   
    driver.get(baseUrl + "personalised-swarovski-crystal-heart-vase.html");
    TimeUnit.SECONDS.sleep(5);
    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
            ,driver.findElement(By.cssSelector("button[title=\"Add to Basket\"]")));
    TimeUnit.SECONDS.sleep(5);
    driver.findElement(By.cssSelector("button[title=\"Add to Basket\"]")).click();
    TimeUnit.SECONDS.sleep(5);
    driver.findElement(By.xpath("//a[2]/span")).click();
    TimeUnit.SECONDS.sleep(5);
    driver.get(baseUrl + "checkout/onepage/");
    TimeUnit.SECONDS.sleep(7);
          
    assertEquals ("SECURE CHECKOUT", driver.findElement(By.tagName("h1")).getText());
    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
            ,driver.findElement(By.cssSelector("#billing-buttons-container > button.button.btn-primary")));
    driver.findElement(By.cssSelector("#billing-buttons-container > button.button.btn-primary")).click();
    TimeUnit.SECONDS.sleep(10);
    driver.findElement(By.cssSelector("label[for='s_method_productmatrix_royal_mail_48']")).click();
    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
            ,driver.findElement(By.cssSelector("#shipping-method-buttons-container > button.button.btn-primary")));
    driver.findElement(By.cssSelector("#shipping-method-buttons-container > button.button.btn-primary")).click();
    TimeUnit.SECONDS.sleep(10);
    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
            ,driver.findElement(By.xpath("//*[@id='checkout-step-payment']/div[1]/h2")));
    TimeUnit.SECONDS.sleep(7);
    driver.findElement(By.cssSelector("label[for='p_method_checkmo']")).click();
    TimeUnit.SECONDS.sleep(10);
    driver.findElement(By.xpath("//ul[@id='checkout-payment-method-load']/li[5]/div/label")).click();
    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
            ,driver.findElement(By.cssSelector("#payment-buttons-container > button.button.btn-primary")));
    driver.findElement(By.cssSelector("#payment-buttons-container > button.button.btn-primary")).click();
    TimeUnit.SECONDS.sleep(10);
    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
            ,driver.findElement(By.xpath("//button[@type='submit']")));
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    TimeUnit.SECONDS.sleep(10);
    assertEquals("A BIG THANK YOU TOM NOW SEE BELOW WHAT YOU CAN DO", driver.findElement(By.cssSelector("h1")).getText());
    String order = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div/strong")).getText();
    String regex = "[0-9]\\d+";
    Pattern p = Pattern.compile(regex);
    Matcher m = p.matcher(order);
    if (m.find()) {
    	driver.get(baseUrl + "customer/account/logout");
        TimeUnit.SECONDS.sleep(5);
        driver.get(baseUrl + "dukkan");
        TimeUnit.SECONDS.sleep(5);
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("Turnkey@1986");
        driver.findElement(By.id("login")).clear();
        driver.findElement(By.id("login")).sendKeys("E/4zp^Gi79:heX6{wp");
        TimeUnit.SECONDS.sleep(5);
        driver.findElement(By.cssSelector("input.form-button")).click();
        TimeUnit.SECONDS.sleep(15);
        if(driver.findElement(By.cssSelector("a[title=\"close\"] > span")) != null){
        	driver.findElement(By.cssSelector("a[title=\"close\"] > span")).click();
        }   
        actions.moveToElement(driver.findElement(By.xpath("//*[@id='nav']/li[2]/a/span"))).build().perform();
        driver.findElement(By.xpath("//*[@id='nav']/li[2]/ul/li[1]/a/span")).click();
        TimeUnit.SECONDS.sleep(5);
	    driver.findElement(By.id("sales_order_grid_filter_am_real_order_id")).clear();
	    driver.findElement(By.id("sales_order_grid_filter_am_real_order_id")).sendKeys(m.group());
    	TimeUnit.SECONDS.sleep(5);
    	driver.findElement(By.cssSelector("button[title=\"Search\"]")).click();
        TimeUnit.SECONDS.sleep(10);
        driver.findElement(By.cssSelector("input[name=\"order_ids\"]")).click();
        TimeUnit.SECONDS.sleep(5);
        new Select(driver.findElement(By.id("sales_order_grid_massaction-select"))).selectByVisibleText("Cancel");
        driver.findElement(By.cssSelector("button[title=\"Submit\"]")).click();

        TimeUnit.SECONDS.sleep(10);
        assertEquals("1 order(s) have been canceled.", driver.findElement(By.cssSelector("li > span")).getText());

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
