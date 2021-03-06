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

public class Update extends PGS.pages.TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

    @Test
  public void Update() throws Exception {
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
    driver.findElement(By.cssSelector("input.input-text.qty")).clear();
    driver.findElement(By.cssSelector("input.input-text.qty")).sendKeys("3");
    driver.findElement(By.xpath("//div[@class='item']/div[5]/a[1]")).click();
    TimeUnit.SECONDS.sleep(5);
    assertEquals("Your shopping cart was updated.", driver.findElement(By.cssSelector("li > span")).getText());
    TimeUnit.SECONDS.sleep(5);
    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
            , driver.findElement(By.xpath("//div[@class='item']/div[7]/a")));
    driver.findElement(By.xpath("//div[@class='item']/div[7]/a")).click();
    TimeUnit.SECONDS.sleep(7);
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
