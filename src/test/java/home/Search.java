package home;

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

public class Search extends PGS.pages.TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

    @Test
  public void Search() throws Exception {
    Actions actions = new Actions(driver);
    driver.manage().window().setSize(new Dimension(1366, 1050));
	driver.get(baseUrl);    
	
    assertEquals("", driver.findElement(By.id("search")).getText());
    assertEquals("FIND", driver.findElement(By.cssSelector("button[title=\"Find\"]")).getText());
    //driver.findElement(By.cssSelector("button[title=\"Find\"]")).click();
    
    driver.findElement(By.id("search")).clear();
    driver.findElement(By.id("search")).sendKeys("1");
    driver.findElement(By.cssSelector("button[title=\"Find\"]")).click();
    TimeUnit.SECONDS.sleep(5);
    assertEquals("SEARCH RESULTS FOR '1'", driver.findElement(By.cssSelector("h1")).getText());
    
    driver.get(baseUrl);

    driver.findElement(By.id("search")).clear();
    driver.findElement(By.id("search")).sendKeys("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Donec molestie, libero congue placerat posuere, mauris erat sodales sap");
    driver.findElement(By.cssSelector("button[title=\"Find\"]")).click();
    TimeUnit.SECONDS.sleep(5);
    assertEquals("Maximum words count is 10. In your search query was cut next part: libero congue placerat posuere, mauris erat sodales sap.", driver.findElement(By.cssSelector("p.note-msg")).getText());
    assertEquals("SEARCH RESULTS FOR 'LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISCING ELIT. DONEC MOLESTIE, LIBERO CONGUE PLACERAT POSUERE, MAURIS ERAT SODALES SAP'", driver.findElement(By.cssSelector("h1")).getText());
    TimeUnit.SECONDS.sleep(3);
    
    driver.get(baseUrl);
    driver.findElement(By.id("search")).clear();
    driver.findElement(By.id("search")).sendKeys("perso");
    TimeUnit.SECONDS.sleep(7);
    actions.moveToElement(driver.findElement(By.xpath("//div[@id='search_autocomplete']/ul/li[10]"))).build().perform();
    driver.findElement(By.xpath("//div[@id='search_autocomplete']/ul/li[10]")).click();
    TimeUnit.SECONDS.sleep(5);
    assertEquals("SEARCH RESULTS FOR 'PERSONALISED'", driver.findElement(By.cssSelector("h1")).getText());

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
