package register;

import java.util.Random;
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

public class Valide_fields extends PGS.pages.TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

    @Test
  public void Valide_fields() throws Exception {
    	Random rand = new Random();

        String AlphabetString = "ABCDEFGHIKLMNOPQRSTVXYZabcdefghiklmnopqrstvxyz";

        char [] alphabet = AlphabetString.toCharArray();
        
        StringBuilder generator = new StringBuilder(); 

        for(int i = 0; i < 7; i++){
        	generator.append(alphabet[rand.nextInt(alphabet.length)]);
           
        }
        String email = generator.toString();
        
        driver.manage().window().setSize(new Dimension(1366, 1050));
	Actions actions = new Actions(driver);
	driver.get(baseUrl + "dukkan");
    driver.findElement(By.id("username")).clear();
    driver.findElement(By.id("username")).sendKeys("Turnkey@1986");
    driver.findElement(By.id("login")).clear();
    driver.findElement(By.id("login")).sendKeys("E/4zp^Gi79:heX6{wp");
    driver.findElement(By.cssSelector("input.form-button")).click();
    TimeUnit.SECONDS.sleep(25);
    
    Boolean test1 = isElementPresent(By.cssSelector("a[title=\"close\"] > span"));
    if(test1 == true){        	
    	driver.findElement(By.cssSelector("a[title=\"close\"] > span")).click();
    	TimeUnit.SECONDS.sleep(5);
    }   
    actions.moveToElement(driver.findElement(By.xpath("//*[@id='nav']/li[16]/a/span"))).build().perform();
    driver.findElement(By.xpath("//*[@id='nav']/li[16]/ul/li[21]/a/span")).click();
    TimeUnit.SECONDS.sleep(5);
    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
            ,driver.findElement(By.xpath("//ul[@id='system_config_tabs']/li[8]/dl/dd[1]/a/span")));
    TimeUnit.SECONDS.sleep(5);
    driver.findElement(By.xpath("//ul[@id='system_config_tabs']/li[9]/dl/dd[2]/a")).click();
    TimeUnit.SECONDS.sleep(5);
    /*driver.findElement(By.id("customer_captcha-head")).click();
    TimeUnit.SECONDS.sleep(3);*/
    new Select(driver.findElement(By.id("customer_captcha_enable"))).selectByVisibleText("No");
    driver.findElement(By.cssSelector("button[title=\"Save Config\"]")).click();
    TimeUnit.SECONDS.sleep(5);
    assertEquals("The configuration has been saved.", driver.findElement(By.cssSelector("li > span")).getText());
    String email_test = email+"@"+email+".com";
	
    driver.get(baseUrl + "customer/account/create/");    
    driver.findElement(By.id("firstname")).clear();
    driver.findElement(By.id("firstname")).sendKeys("Tom");
    driver.findElement(By.id("lastname")).clear();
    driver.findElement(By.id("lastname")).sendKeys("Test");
    driver.findElement(By.id("email_address")).clear();
    driver.findElement(By.id("email_address")).sendKeys(email_test);
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("qwerty");
    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
            ,driver.findElement(By.id("confirmation")));
    driver.findElement(By.id("password")).clear();
    driver.findElement(By.id("password")).sendKeys("qwerty");
    driver.findElement(By.id("confirmation")).clear();
    driver.findElement(By.id("confirmation")).sendKeys("qwerty");   
    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
            ,driver.findElement(By.cssSelector("div.buttons-set > button.button.btn-primary")));
    driver.findElement(By.cssSelector("div.buttons-set > button.button.btn-primary")).click();
    TimeUnit.SECONDS.sleep(5);
    assertEquals("Thank you for registering with Personalised Gifts Shop.", driver.findElement(By.cssSelector("li > span")).getText());
    assertEquals("MY DASHBOARD", driver.findElement(By.cssSelector("h1")).getText());
    assertEquals("GREAT TO SEE YOU, TOM TEST!", driver.findElement(By.cssSelector("h3.hello")).getText());
    WebElement my_account = driver.findElement(By.id("myaccount-menu-link"));
    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
            ,my_account);
    TimeUnit.SECONDS.sleep(5);
    actions.moveToElement(my_account).build().perform();
    TimeUnit.SECONDS.sleep(5);
    driver.findElement(By.xpath("(//a[contains(text(),'Sign Out')])[2]")).click();
    TimeUnit.SECONDS.sleep(10);
    
    driver.get(baseUrl + "dukkan");
    actions.moveToElement(driver.findElement(By.xpath("//ul[@id='nav']/li[16]/a/span"))).build().perform();
    driver.findElement(By.xpath("//ul[@id='nav']/li[16]/ul/li[21]/a/span")).click();
    TimeUnit.SECONDS.sleep(5);
    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
            ,driver.findElement(By.xpath("//ul[@id='system_config_tabs']/li[8]/dl/dd[1]/a/span")));
    driver.findElement(By.xpath("//ul[@id='system_config_tabs']/li[9]/dl/dd[2]/a/span")).click();
   //driver.findElement(By.id("customer_captcha-head")).click();
   // TimeUnit.SECONDS.sleep(3);
    new Select(driver.findElement(By.id("customer_captcha_enable"))).selectByVisibleText("Yes");
    driver.findElement(By.cssSelector("button[title=\"Save Config\"]")).click();
    TimeUnit.SECONDS.sleep(5);
    assertEquals("The configuration has been saved.", driver.findElement(By.cssSelector("li > span")).getText());
    TimeUnit.SECONDS.sleep(5);
    actions.moveToElement(driver.findElement(By.xpath("//*[@id='nav']/li[5]/a/span"))).build().perform();
    driver.findElement(By.xpath("//*[@id='nav']/li[5]/ul/li[1]/a/span")).click();
    TimeUnit.SECONDS.sleep(5);
    driver.findElement(By.id("customerGrid_filter_email")).clear();
    driver.findElement(By.id("customerGrid_filter_email")).sendKeys(email_test);
    driver.findElement(By.cssSelector("button[title=\"Search\"]")).click();
    TimeUnit.SECONDS.sleep(5);
    driver.findElement(By.cssSelector("input[name=\"customer\"]")).click();
    TimeUnit.SECONDS.sleep(5);
    new Select(driver.findElement(By.id("customerGrid_massaction-select"))).selectByVisibleText("Delete");
    driver.findElement(By.cssSelector("button[title=\"Submit\"]")).click();
    assertTrue(closeAlertAndGetItsText().matches("^Are you sure[\\s\\S]$"));
    TimeUnit.SECONDS.sleep(5);
    assertEquals("Total of 1 record(s) were deleted.", driver.findElement(By.cssSelector("li > span")).getText());

    
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
