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

public class Image extends PGS.pages.TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

    @Test
  public void Image() throws Exception {
    	driver.manage().window().setSize(new Dimension(1366, 1050));
    driver.get(baseUrl + "personalised-swarovski-crystal-heart-vase.html");
    String img = "http://dev.personalisedgiftsshop.co.uk/media/catalog/product/cache/1/image/400x/9df78eab33525d08d6e5fb8d27136e95/p/e/personalised-swarovski-crystal-heart-vase.jpg";
    assertEquals(img, driver.findElement(By.cssSelector("div.product-image.product-image-zoom a img")).getAttribute("src").toString());
   /* ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
            ,driver.findElement(By.xpath("(//img[@alt='Engraved Swarovski Crystal Heart Vase'])[4]")));*/
   // driver.findElement(By.cssSelector("button.slick-next")).click();
   // driver.findElement(By.cssSelector("button.slick-prev")).click();   
  //  driver.findElement(By.xpath("//img[contains(@src,'http://dev-mage.com/store53/store/media/catalog/product/cache/1/thumbnail/110x/9df78eab33525d08d6e5fb8d27136e95/s/c/screenshot_2_5.jpg')]")).click();
    driver.findElement(By.cssSelector("div.product-image.product-image-zoom a img")).click();
    TimeUnit.SECONDS.sleep(5);
    driver.findElement(By.xpath("(//button[@title='Next (Right arrow key)'])")).click();
    TimeUnit.SECONDS.sleep(5);
    driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
    //driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
    //driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
   // driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
   // driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
   // driver.findElement(By.cssSelector("button.mfp-close")).click();

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
