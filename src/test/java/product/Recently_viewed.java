package product;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.*;
import org.testng.annotations.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Recently_viewed extends PGS.pages.TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

    @Test
  public void testUntitled5() throws Exception {
	driver.manage().window().maximize();
    driver.get(baseUrl + "personalised-swarovski-crystal-heart-vase.html");
    driver.get(baseUrl + "personalised-10-things-i-love-about-you-box.html");
    driver.get(baseUrl + "personalised-valentine-bear.html");
    driver.get(baseUrl + "personalised-candle-for-boys-church-design.html");
    driver.get(baseUrl + "personalised-candle-for-girls-church-design.html");
    driver.get(baseUrl + "personalised-pink-polka-dot-rocking-horse-photo-album.html");
    driver.get(baseUrl + "personalised-babys-first-christmas-bauble.html");
    driver.get(baseUrl + "engraved-shot-glass.html");
    driver.get(baseUrl + "personalised-swarovski-crystal-heart-vase.html");   
    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
            ,driver.findElement(By.xpath("//div[5]/div/div/h2/span")));
    assertEquals("My Recently Viewed Items", driver.findElement(By.xpath("//div[5]/div/div/h2/span")).getText());
    assertEquals("Total 7 products viewed", driver.findElement(By.cssSelector("div.left")).getText());
    assertEquals("View all", driver.findElement(By.id("recently_view_all")).getText());
    assertEquals("Clear all", driver.findElement(By.id("recently_clear_all")).getText());
    driver.findElement(By.cssSelector("ul#recently-viewed-items > li:first-child > a.recently_delete_item")).click();
    TimeUnit.SECONDS.sleep(5);
    assertEquals("Total 6 products viewed", driver.findElement(By.cssSelector("div.left")).getText());
    driver.findElement(By.id("recently_view_all")).click();
    TimeUnit.SECONDS.sleep(5);
    driver.findElement(By.cssSelector("ul.products-grid.row"));
    driver.get(baseUrl + "personalised-swarovski-crystal-heart-vase.html");
    driver.findElement(By.id("recently_clear_all")).click();
    TimeUnit.SECONDS.sleep(5);
    assertNotEquals("My Recently Viewed Items", driver.findElement(By.xpath("//div[5]/div/div/h2/span")).getText());
    TimeUnit.SECONDS.sleep(5);
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
