package cart;

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

public class Move_wishlist extends PGS.pages.TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

    @Test
  public void Move_wishlist() throws Exception {
	driver.manage().window().maximize();
	Actions actions = new Actions(driver);
	driver.get(baseUrl + "customer/account/login/");
	driver.findElement(By.id("email")).clear();
    driver.findElement(By.id("email")).sendKeys("qatestingtestqa@gmail.com");
    driver.findElement(By.id("pass")).clear();
    driver.findElement(By.id("pass")).sendKeys("qwerty");
    driver.findElement(By.id("send2")).click();
    TimeUnit.SECONDS.sleep(10);
    driver.get(baseUrl + "personalised-swarovski-crystal-heart-vase.html");
    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
            ,driver.findElement(By.cssSelector("button[title=\"Add to Basket\"]")));
    driver.findElement(By.cssSelector("button[title=\"Add to Basket\"]")).click();
    TimeUnit.SECONDS.sleep(5);
    driver.findElement(By.xpath("/html/body/div[2]/div/div[1]/div/div[1]/a[2]/span")).click();
    TimeUnit.SECONDS.sleep(7);
    assertEquals("YOUR SHOPPING BASKET", driver.findElement(By.cssSelector("h1")).getText());
    assertEquals("ENGRAVED SWAROVSKI CRYSTAL HEART VASE", driver.findElement(By.xpath("(//a[contains(text(),'Engraved Swarovski Crystal Heart Vase')])[3]")).getText());
    driver.findElement(By.xpath("//div[@class='item']/div[3]/div/a[2]/span")).click();
    TimeUnit.SECONDS.sleep(3);
    driver.findElement(By.cssSelector("span")).click();
    TimeUnit.SECONDS.sleep(3);
    driver.findElement(By.cssSelector("span")).click();
    TimeUnit.SECONDS.sleep(5);
    assertEquals("Engraved Swarovski Crystal Heart Vase has been added to your wishlist.", driver.findElement(By.cssSelector("span")).getText());
    driver.findElement(By.cssSelector("button.mfp-close")).click();
    assertEquals("SHOPPING CART IS EMPTY", driver.findElement(By.cssSelector("h1")).getText());
    WebElement my_account = driver.findElement(By.id("myaccount-menu-link"));
    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
            ,my_account);
    TimeUnit.SECONDS.sleep(5);
    actions.moveToElement(my_account).build().perform();
    TimeUnit.SECONDS.sleep(5);
    driver.findElement(By.linkText("My Wishlist")).click();
    TimeUnit.SECONDS.sleep(5);
    assertEquals("Engraved Swarovski Crystal Heart Vase", driver.findElement(By.cssSelector("div.columns.small-6 > h3.product-name > a[title=\"Engraved Swarovski Crystal Heart Vase\"]")).getText());
    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
            ,driver.findElement(By.cssSelector("div.columns.small-6 > h3.product-name > a[title=\"Engraved Swarovski Crystal Heart Vase\"]")));
    driver.findElement(By.cssSelector("div.r-tbody > div:last-child > div.columns.small-1 > a.btn-remove.btn-remove2")).click();
    assertTrue(closeAlertAndGetItsText().matches("^Are you sure you want to remove this product from your wishlist[\\s\\S]$"));
    TimeUnit.SECONDS.sleep(10);
    WebElement signout = driver.findElement(By.linkText("Sign Out"));
    actions.moveToElement(driver.findElement(By.linkText("My Account"))).build().perform();
    signout.click();
    TimeUnit.SECONDS.sleep(5);
    TimeUnit.SECONDS.sleep(10);
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
