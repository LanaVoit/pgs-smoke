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

public class Menu extends PGS.pages.TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

    @Test
  public void Menu() throws Exception {
	Actions actions = new Actions(driver);
	driver.manage().window().setSize(new Dimension(1366, 1050));
    driver.get(baseUrl);
    actions.moveToElement(driver.findElement(By.xpath("//*[@id='nav']/li[2]/a/span"))).build().perform();
    //actions.moveToElement(driver.findElement(By.xpath("//ul[@id='nav']/li[1]/a/span"))).build().perform();
    //assertEquals("alcohol\npersonalised champagne\npersonalised cava\npersonalised sparkling rose wines\npersonalised rose wines\npersonalised white wines\npersonalised red port\npersonalised vodka\npersonalised whisky\npersonalised beer / cider / lager\npersonalised alcohol sets\npersonalised champagne\npersonalised champagne\nshow more", driver.findElement(By.xpath("//ul[@id='nav']/li[3]/ul/li")).getText());
    assertEquals("Personalised", driver.findElement(By.linkText("Personalised")).getText());
    assertEquals("Family", driver.findElement(By.linkText("Family")).getText());
    assertEquals("Years", driver.findElement(By.linkText("Years")).getText());
    assertEquals("How About?",driver.findElement(By.linkText("How About?")).getText());
    assertEquals("Trending", driver.findElement(By.linkText("Trending")).getText());

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
