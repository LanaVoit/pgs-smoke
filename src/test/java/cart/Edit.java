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

public class Edit extends PGS.pages.TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

    @Test
  public void Edit() throws Exception {
	driver.manage().window().maximize();
    driver.get(baseUrl + "personalised-swarovski-crystal-heart-vase.html");
    TimeUnit.SECONDS.sleep(5);
    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
            ,driver.findElement(By.cssSelector("button[title=\"Add to Basket\"]")));
    driver.findElement(By.cssSelector("button[title=\"Add to Basket\"]")).click();
    TimeUnit.SECONDS.sleep(5);
    driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div[1]/a[2]/span")).click();
    TimeUnit.SECONDS.sleep(5);
    assertEquals("YOUR SHOPPING BASKET", driver.findElement(By.cssSelector("h1")).getText());
    assertEquals("ENGRAVED SWAROVSKI CRYSTAL HEART VASE", driver.findElement(By.xpath("(//a[contains(text(),'Engraved Swarovski Crystal Heart Vase')])[3]")).getText());
    driver.findElement(By.xpath("(//a[contains(text(),'Edit')])[2]")).click();
    TimeUnit.SECONDS.sleep(5);
    driver.findElement(By.id("options_32498_text")).clear();
    driver.findElement(By.id("options_32498_text")).sendKeys("Test");
    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
            ,driver.findElement(By.cssSelector("button[title=\"Update Cart\"]")));
    driver.findElement(By.cssSelector("button[title=\"Update Cart\"]")).click();
    TimeUnit.SECONDS.sleep(5);
    assertEquals("Engraved Swarovski Crystal Heart Vase was updated in your shopping cart.", driver.findElement(By.cssSelector("li > span")).getText());
    driver.findElement(By.xpath("//div/div[3]/div/span")).click();
    TimeUnit.SECONDS.sleep(3);
    assertEquals("Test", driver.findElement(By.cssSelector("dd")).getText());   
    driver.findElement(By.cssSelector("button.mfp-close")).click();
    TimeUnit.SECONDS.sleep(5);
    driver.findElement(By.xpath("//div[@class='item']/div[7]/a")).click();
    TimeUnit.SECONDS.sleep(5);
    
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
