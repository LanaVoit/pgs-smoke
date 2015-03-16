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

public class Order_logout extends PGS.pages.TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

    @Test
  public void testUntitled10() throws Exception {
	driver.manage().window().maximize();
	Actions actions = new Actions(driver);
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
    TimeUnit.SECONDS.sleep(5);
    driver.findElement(By.id("billing:firstname")).clear();
    driver.findElement(By.id("billing:firstname")).sendKeys("Tom");
    driver.findElement(By.id("billing:lastname")).clear();
    driver.findElement(By.id("billing:lastname")).sendKeys("Green");
    driver.findElement(By.id("billing:email")).clear();
    driver.findElement(By.id("billing:email")).sendKeys("qatestingtestqa@mail.ru");
    driver.findElement(By.id("billing:telephone")).clear();
    driver.findElement(By.id("billing:telephone")).sendKeys("89465123213");
    driver.findElement(By.id("billing:postcode")).clear();
    driver.findElement(By.id("billing:postcode")).sendKeys("AA11AA");
    driver.findElement(By.id("billing_cp_button_id")).click();
    TimeUnit.SECONDS.sleep(5);
    new Select(driver.findElement(By.id("crafty_postcode_lookup_result_option1"))).selectByVisibleText("THE BAKERY, 1 High Street, Crafty Valley, BIG CITY");
    TimeUnit.SECONDS.sleep(5);
    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
            ,driver.findElement(By.cssSelector("#billing-buttons-container > button.button.btn-primary")));
    driver.findElement(By.cssSelector("#billing-buttons-container > button.button.btn-primary")).click();
    TimeUnit.SECONDS.sleep(10);
    driver.findElement(By.cssSelector("label[for='s_method_freeshipping_freeshipping']")).click();
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
            ,driver.findElement(By.cssSelector("button[title='Place Order']")));
    driver.findElement(By.cssSelector("button[title='Place Order']")).click();
    TimeUnit.SECONDS.sleep(10);
    assertEquals("A BIG THANK YOU. NOW SEE BELOW WHAT YOU CAN DO", driver.findElement(By.cssSelector("h1")).getText());
    String order = driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[3]/div[2]/div[1]/div[2]/div/strong")).getText();
    String regex = "[0-9]\\d+";
    Pattern p = Pattern.compile(regex);
    Matcher m = p.matcher(order);
    if (m.find()) {
    	driver.get(baseUrl + "customer/account/logout");
        TimeUnit.SECONDS.sleep(5);
        driver.get(baseUrl + "admin");
        /*driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("admin1");
        driver.findElement(By.id("login")).clear();
        driver.findElement(By.id("login")).sendKeys("alex2014");
        driver.findElement(By.cssSelector("input.form-button")).click();
        driver.findElement(By.cssSelector("a[title=\"close\"] > span")).click();*/
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
