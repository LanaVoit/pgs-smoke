package wishlist;

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

public class Add_all_cart extends PGS.pages.TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

    @Test
  public void testUntitled8() throws Exception {
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
    driver.get(baseUrl + "wishlist/");
    driver.findElement(By.linkText("Rtttt")).click();
    TimeUnit.SECONDS.sleep(3);
    driver.findElement(By.id("select-all")).click();
    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
            ,driver.findElement(By.cssSelector("button.button.btn-add")));
    driver.findElement(By.cssSelector("button.button.btn-add")).click();
    driver.get(baseUrl + "checkout/cart/");
    assertEquals("YOUR SHOPPING BASKET", driver.findElement(By.cssSelector("h1")).getText());
    assertEquals("Personalised Months of the Year Book", driver.findElement(By.xpath("(//a[contains(text(),'Personalised Months of the Year Book')])[3]")).getText());
    assertEquals("Personalised Designer Wedding Pilsner Glass - Hats Design", driver.findElement(By.xpath("(//a[contains(text(),'Personalised Designer Wedding Pilsner Glass - Hats Design')])[3]")).getText());
    driver.findElement(By.xpath("//div[@id='cart-item-2481389']/div[3]/div/a[2]/span")).click();
    TimeUnit.SECONDS.sleep(3);
	driver.findElement(By.cssSelector("span")).click();
	TimeUnit.SECONDS.sleep(3);
	driver.findElement(By.xpath("(//a[@id='6446']/span)[4]")).click();
	TimeUnit.SECONDS.sleep(5);
	assertEquals("Personalised Months of the Year Book has been added to your wishlist.", driver.findElement(By.cssSelector("span")).getText());
	driver.findElement(By.cssSelector("button.mfp-close")).click();
	
	driver.findElement(By.xpath("//div[@id='cart-item-2481390']/div[3]/div/a[2]/span")).click();
    TimeUnit.SECONDS.sleep(3);
	driver.findElement(By.cssSelector("span")).click();
	TimeUnit.SECONDS.sleep(3);
	driver.findElement(By.xpath("(//a[@id='2662']/span)[4]")).click();
	TimeUnit.SECONDS.sleep(5);
	assertEquals("Personalised Designer Wedding Pilsner Glass - Hats Design has been added to your wishlist.", driver.findElement(By.cssSelector("span")).getText());
	driver.findElement(By.cssSelector("button.mfp-close")).click();
	assertEquals("Shopping Cart is Empty", driver.findElement(By.cssSelector("h1")).getText());
	

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
