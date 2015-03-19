package wishlist;

import java.io.IOException;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import javax.mail.Authenticator;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;

import login.Reset_password.GetMulti;

import org.testng.*;
import org.testng.annotations.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Share extends PGS.pages.TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

    @Test
  public void Share() throws Exception {
    	driver.manage().window().maximize();
    	Actions actions = new Actions(driver);
        driver.get(baseUrl + "personalised-swarovski-crystal-heart-vase.html");
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
                ,driver.findElement(By.cssSelector("li > a.button > span")));
        driver.findElement(By.cssSelector("li > a.button > span")).click();
        TimeUnit.SECONDS.sleep(5);
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("qatestingtestqa@gmail.com");
        driver.findElement(By.id("pass")).clear();
        driver.findElement(By.id("pass")).sendKeys("qwerty");
        driver.findElement(By.id("send2")).click();
        TimeUnit.SECONDS.sleep(10);
        driver.findElement(By.cssSelector("span")).click();
        TimeUnit.SECONDS.sleep(3);
        driver.findElement(By.cssSelector("span")).click();
        TimeUnit.SECONDS.sleep(3);
        assertEquals("Engraved Swarovski Crystal Heart Vase has been added to your wishlist.", driver.findElement(By.cssSelector("span")).getText());
        driver.findElement(By.cssSelector("button.mfp-close")).click();
        TimeUnit.SECONDS.sleep(3);
    
        driver.get(baseUrl + "wishlist/");
        assertEquals("Engraved Swarovski Crystal Heart Vase", driver.findElement(By.cssSelector("div.columns.small-6 > h3.product-name > a[title=\"Engraved Swarovski Crystal Heart Vase\"]")).getText());
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
                ,driver.findElement(By.cssSelector("div.columns.small-6 > h3.product-name > a[title=\"Engraved Swarovski Crystal Heart Vase\"]")));
        
    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
            ,driver.findElement(By.name("save_and_share")));
    driver.findElement(By.name("save_and_share")).click();
    TimeUnit.SECONDS.sleep(5);
    driver.findElement(By.id("email_address")).clear();
    driver.findElement(By.id("email_address")).sendKeys("qatestingtestqa@gmail.com");
    driver.findElement(By.id("message")).clear();
    driver.findElement(By.id("message")).sendKeys("test share");
    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
            ,driver.findElement(By.xpath("(//button[@type='submit'])[2]")));
    driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
    TimeUnit.SECONDS.sleep(5);
    assertEquals("Your Wishlist has been shared.", driver.findElement(By.cssSelector("li > span")).getText());
    WebElement signout = driver.findElement(By.linkText("Sign Out"));
    WebElement my_account = driver.findElement(By.linkText("My Account"));
    actions.moveToElement(my_account).build().perform();
    signout.click();
    TimeUnit.SECONDS.sleep(5);
    TimeUnit.SECONDS.sleep(60);
    
        class MailAuthenticator extends Authenticator {
      		 
    	    public PasswordAuthentication getPasswordAuthentication() {
    	         return new PasswordAuthentication("qatestingtestqa@gmail.com", "parol123");
    	    }
    	}
    	
    	Properties props = new Properties();
    	
    	props.put("mail.smtp.user", "qatestingtestqa@gmail.com");
    	props.put("mail.host", "pop.gmail.com");
    	props.put("mail.store.protocol", "pop3s");
        props.put("mail.pop3s.auth", "true");
        props.put("mail.pop3s.port", 995);
    	props.put("mail.smtp.starttls.enable","true");
    	props.put("mail.smtp.debug", "true");
    	props.put("mail.smtp.auth", "true");
    	props.put("mail.smtp.socketFactory.port", 995);
    	props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
    	props.put("mail.smtp.socketFactory.fallback", "false");

    	Session session = Session.getInstance(props, new MailAuthenticator());
    	session.setDebug(true);
   	
	        Store store = session.getStore("pop3s");
	        store.connect("pop.gmail.com", "qatestingtestqa@gmail.com", "parol123");
	 
	        Folder inbox = store.getFolder("INBOX");
	        inbox.open(Folder.READ_ONLY);
	        
	        Message[] messages = inbox.getMessages();
	        
	           
	        GetMulti gmulti = new GetMulti();
	        String textMessage = gmulti.getText(messages[messages.length - 1]);
	        String regex = "test share";
	        Pattern p = Pattern.compile(regex);
	        Matcher m = p.matcher(textMessage);
	        if (m.find()) {
	        	    driver.get(baseUrl);
	        	    driver.findElement(By.id("search")).clear();
	        	    driver.findElement(By.id("search")).sendKeys(m.group());
	        	TimeUnit.SECONDS.sleep(5);
	        	   
	        }
	        inbox.close(false);
	        store.close();  

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
  
  public class GetMulti {
	    
	    public  boolean textIsHtml = false;
	 
	    /**
	     * Return the primary text content of the message.
	     */
	    public String getText(Part p) throws MessagingException, IOException {
	        if (p.isMimeType("text/*")) {
	            String s = (String)p.getContent();
	            textIsHtml = p.isMimeType("text/html");
	            return s;
	        }
	 
	        if (p.isMimeType("multipart/alternative")) {
	            // prefer html text over plain text
	            Multipart mp = (Multipart)p.getContent();
	            String text = null;
	            for (int i = 0; i < mp.getCount(); i++) {
	                Part bp = mp.getBodyPart(i);
	                if (bp.isMimeType("text/plain")) {
	                    if (text == null)
	                        text = getText(bp);
	                    continue;
	                } else if (bp.isMimeType("text/html")) {
	                    String s = getText(bp);
	                    if (s != null)
	                        return s;
	                } else {
	                    return getText(bp);
	                }
	            }
	            return text;
	        } else if (p.isMimeType("multipart/*")) {
	            Multipart mp = (Multipart)p.getContent();
	            for (int i = 0; i < mp.getCount(); i++) {
	                String s = getText(mp.getBodyPart(i));
	                if (s != null)
	                    return s;
	            }
	        }
	 
	        return null;
	    }
	 
	}
}
