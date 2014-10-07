package cart;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.testng.*;
import org.testng.annotations.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Coupon extends PGS.pages.TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

    @Test
  public void testUntitled2() throws Exception {
	driver.manage().window().maximize();
    driver.get(baseUrl + "personalised-swarovski-crystal-heart-vase.html");
    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
            ,driver.findElement(By.cssSelector("button[title=\"Add to Basket\"]")));
    driver.findElement(By.cssSelector("button[title=\"Add to Basket\"]")).click();
    TimeUnit.SECONDS.sleep(5);
    driver.findElement(By.xpath("//a[2]/span")).click();
    TimeUnit.SECONDS.sleep(5);
    assertEquals("YOUR SHOPPING BASKET", driver.findElement(By.cssSelector("h1")).getText());
    assertEquals("ENGRAVED SWAROVSKI CRYSTAL HEART VASE", driver.findElement(By.xpath("(//a[contains(text(),'Engraved Swarovski Crystal Heart Vase')])[3]")).getText());
    assertEquals("Discount Code", driver.findElement(By.xpath("//form[@id='discount-coupon-form']/fieldset/div/label")).getText());
    assertEquals("Gift Cards", driver.findElement(By.xpath("//form[@id='giftcard-form']/fieldset/div/label")).getText());
    driver.findElement(By.cssSelector("button.button.btn-lg")).click();
    TimeUnit.SECONDS.sleep(3);
    assertEquals("This is a required field.", driver.findElement(By.id("advice-required-entry-coupon_code")).getText());
    driver.findElement(By.xpath("//button[@value='Add Card']")).click();
    TimeUnit.SECONDS.sleep(3);
    assertEquals("This is a required field.", driver.findElement(By.id("advice-required-entry-giftcard_code")).getText());
    driver.findElement(By.id("giftcard_code")).clear();
    driver.findElement(By.id("giftcard_code")).sendKeys("050UO7GSA81E");
    driver.findElement(By.xpath("//button[@value='Add Card']")).click();
    TimeUnit.SECONDS.sleep(3);
    assertEquals("Gift Card \"050UO7GSA81E\" was added.", driver.findElement(By.cssSelector("li > span")).getText());
    assertEquals("Gift Card (050UO7GSA81E)", driver.findElement(By.cssSelector("th.a-right")).getText());
    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
            ,driver.findElement(By.cssSelector("th.a-right > a.btn-remove")));
    driver.findElement(By.cssSelector("th.a-right > a.btn-remove")).click();
    TimeUnit.SECONDS.sleep(3);
    assertEquals("Gift Card \\\"050UO7GSA81E\\\" was removed.<\\/span><\\/li><\\/ul><\\/li><\\/ul>", driver.findElement(By.cssSelector("span")).getText());
    driver.findElement(By.id("giftcard_code")).clear();
    driver.findElement(By.id("giftcard_code")).sendKeys("050UO7GSA81E");
    driver.findElement(By.xpath("//*[@id=\"giftcard-form\"]/fieldset/div[4]/a")).click();    
    TimeUnit.SECONDS.sleep(3);
    assertEquals("Gift Card: 050UO7GSA81E", driver.findElement(By.cssSelector("div.gift-card-info > p")).getText());
    assertEquals("£100.00", driver.findElement(By.cssSelector("strong > span.price")).getText());
    driver.findElement(By.id("coupon_code")).clear();
    driver.findElement(By.id("coupon_code")).sendKeys("FABO10");
    driver.findElement(By.cssSelector("button.button.btn-lg")).click();
    TimeUnit.SECONDS.sleep(3);
    assertEquals("Coupon code \"FABO10\" is not valid.", driver.findElement(By.cssSelector("li > span")).getText());
    TimeUnit.SECONDS.sleep(3);
    driver.findElement(By.id("giftcard_code")).clear();
    driver.findElement(By.id("giftcard_code")).sendKeys("FABO10");
    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
            ,driver.findElement(By.xpath("//button[@value='Add Card']")));
    driver.findElement(By.xpath("//button[@value='Add Card']")).click();
    TimeUnit.SECONDS.sleep(5);
    assertEquals("Wrong gift card code.", driver.findElement(By.cssSelector("li > span")).getText());
    driver.navigate().refresh();
    TimeUnit.SECONDS.sleep(5);
    driver.findElement(By.id("coupon_code")).clear();
    driver.findElement(By.id("coupon_code")).sendKeys("test123qa");
    driver.findElement(By.cssSelector("button.button.btn-lg")).click();
    TimeUnit.SECONDS.sleep(5);
    assertEquals("Coupon code \"test123qa\" was applied.", driver.findElement(By.cssSelector("li > span")).getText());
    assertEquals("Discount (test123qa)", driver.findElement(By.xpath("//tr[2]/td")).getText());
    driver.findElement(By.xpath("//button[@value='Cancel Coupon']")).click();
    TimeUnit.SECONDS.sleep(5);
    assertEquals("Coupon code was canceled.", driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[1]/div[3]/div[1]/div[2]/ul/li/ul/li/span")).getText());
    
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
