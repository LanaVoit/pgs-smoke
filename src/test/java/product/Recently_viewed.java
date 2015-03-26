package product;

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

public class Recently_viewed extends PGS.pages.TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

    @Test
  public void Recently_viewed() throws Exception {
    	driver.manage().window().setSize(new Dimension(1366, 1050));
	Actions actions = new Actions(driver);
	driver.get(baseUrl);
	/*driver.findElement(By.xpath("//*[@id='header']/div/div[2]/div/div[1]/ul/li/a")).click();
	TimeUnit.SECONDS.sleep(5);
	driver.get("chrome://settings/clearBrowserData");

	final By cleanCacheIframe = By.xpath("//iframe[@src='chrome://settings-frame/clearBrowserData']");
	driver.switchTo().frame(driver.findElement(cleanCacheIframe));
	 
	driver.findElement(By.id("clear-browser-data-commit")).click();
	TimeUnit.SECONDS.sleep(5);*/
    driver.get(baseUrl + "personalised-swarovski-crystal-heart-vase.html");
    driver.navigate().refresh();
    TimeUnit.SECONDS.sleep(10);
    driver.get(baseUrl + "personalised-silver-plated-baby-photo-album.html");
    TimeUnit.SECONDS.sleep(10);
    driver.get(baseUrl + "personalised-purple-ronnie-godfather-chocolate-bar.html");
    TimeUnit.SECONDS.sleep(10);
    driver.get(baseUrl + "personalised-swarovski-diamante-vase-mr-and-mrs.html");
    TimeUnit.SECONDS.sleep(10);
    /*driver.get(baseUrl + "personalised-keep-calm-toffee-jar.html");
    TimeUnit.SECONDS.sleep(5);
    driver.get(baseUrl + "personalised-door-plaque-for-girls-animal-alphabet.html");
    TimeUnit.SECONDS.sleep(5);
    driver.get(baseUrl + "personalised-baby-blanket.html");
    TimeUnit.SECONDS.sleep(5);
    driver.get(baseUrl + "personalised-crystal-pint-tankard.html");
    TimeUnit.SECONDS.sleep(5);*/
    driver.get(baseUrl + "personalised-swarovski-crystal-heart-vase.html"); 
    //driver.navigate().refresh();
    TimeUnit.SECONDS.sleep(15);
    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
            ,driver.findElement(By.xpath("//div[5]/div/div/h2/span")));
    assertEquals("MY RECENTLY VIEWED ITEMS", driver.findElement(By.xpath("//div[5]/div/div/h2/span")).getText());
    assertEquals("TOTAL 4 PRODUCTS VIEWED", driver.findElement(By.cssSelector("div.left")).getText());
    assertEquals("VIEW ALL", driver.findElement(By.id("recently_view_all")).getText());
    assertEquals("CLEAR ALL", driver.findElement(By.id("recently_clear_all")).getText());
    actions.moveToElement(driver.findElement(By.xpath("//*[@id=\"recently-viewed-items\"]/li[1]/a[1]/img"))).build().perform();
    driver.findElement(By.cssSelector("ul#recently-viewed-items > li:first-child > a.recently_delete_item")).click();
    TimeUnit.SECONDS.sleep(10);
    assertEquals("TOTAL 3 PRODUCTS VIEWED", driver.findElement(By.cssSelector("div.left")).getText());
    TimeUnit.SECONDS.sleep(10);
    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
            ,driver.findElement(By.xpath("//div[5]/div/div/h2/span")));
    driver.findElement(By.id("recently_view_all")).click();
    TimeUnit.SECONDS.sleep(5);
    driver.findElement(By.cssSelector("ul.products-grid.row"));
    driver.get(baseUrl + "personalised-swarovski-crystal-heart-vase.html");
    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
            ,driver.findElement(By.xpath("//div[5]/div/div/h2/span")));
    driver.findElement(By.id("recently_clear_all")).click();
    TimeUnit.SECONDS.sleep(7);
    assertNotEquals("MY RECENTLY VIEWED ITEMS", driver.findElement(By.xpath("//div[5]/div/div/h2/span")).getText());
    
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
