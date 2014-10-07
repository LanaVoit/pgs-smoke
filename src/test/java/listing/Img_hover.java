package listing;

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

public class Img_hover extends PGS.pages.TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

    @Test
  public void testUntitled() throws Exception {
	driver.manage().window().maximize(); 
	Actions actions = new Actions(driver);
    driver.get(baseUrl + "crystal-gifts");
    TimeUnit.SECONDS.sleep(3);
    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
            ,driver.findElement(By.cssSelector("li#item-1914 a.product-image")));
    String img_test = "http://dev-mage.com/store53/store/media/catalog/product/cache/1/small_image/335x/9df78eab33525d08d6e5fb8d27136e95/e/n/engraved-swarovski-crystal-heart-vase.jpg";
    assertEquals(img_test, driver.findElement(By.cssSelector("li#item-1914 a.product-image img")).getAttribute("src").toString());
    
    actions.moveToElement(driver.findElement(By.xpath("//img[contains(@src,'http://dev-mage.com/store53/store/media/customoptions/options/20299/8096/50x/Screenshot_2.jpg')]"))).build().perform(); 
    String img_test2 = "http://dev-mage.com/store53/store/media/customoptions/options/20299/8096/335x/Screenshot_2.jpg";
    assertEquals(img_test2, driver.findElement(By.cssSelector("li#item-1914 a.product-image img")).getAttribute("src").toString());
    
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
