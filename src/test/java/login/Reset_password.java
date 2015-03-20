package login;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Store;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Part;

import java.util.concurrent.TimeUnit;

import org.testng.*;
import org.testng.annotations.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import login.Reset_password.GetMulti;

public class Reset_password extends PGS.pages.TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

    @Test
  public void Reset_password() throws Exception {
    	driver.manage().window().setSize(new Dimension(1366, 1050));
	Actions actions = new Actions(driver);
    driver.get(baseUrl + "customer/account/login/");
   /* driver.findElement(By.linkText("forgot?")).click();
    TimeUnit.SECONDS.sleep(5);
    driver.findElement(By.id("email_address")).clear();
    driver.findElement(By.id("email_address")).sendKeys("quality_assurance@bk.ru");
    driver.findElement(By.cssSelector("button.button.btn-primary")).click();
    TimeUnit.SECONDS.sleep(5);
    assertEquals("If there is an account associated with quality_assurance@bk.ru you will receive an email with a link to reset your password.", driver.findElement(By.cssSelector("li > span")).getText());
    TimeUnit.SECONDS.sleep(60);*/
    class MailAuthenticator extends Authenticator {
		 
	    public PasswordAuthentication getPasswordAuthentication() {
	         return new PasswordAuthentication("quality_assurance@bk.ru", "parol123");
	    }
	}
	
    String SSL_FACTORY = "javax.net.ssl.SSLSocketFactory";
	Properties props = new Properties();
	props.setProperty("mail.pop3.socketFactory.class", SSL_FACTORY);
	props.setProperty("mail.pop3.socketFactory.fallback", "false");
	props.setProperty("mail.pop3.port", "995");
	props.setProperty("mail.pop3.socketFactory.port", "995");
       String host = "pop.mail.ru";
       String provider = "pop3";
        Session session = Session.getDefaultInstance(props,
                new MailAuthenticator());
        
        
        Store store = session.getStore(provider);
        store.connect(host, null, null);
 
        Folder inbox = store.getFolder("INBOX");
        inbox.open(Folder.READ_ONLY);
        
        Message[] messages = inbox.getMessages();
        
           
        GetMulti gmulti = new GetMulti();
        String textMessage = gmulti.getText(messages[messages.length - 1]);
        String regex = "https?://(.*)/customer/account/resetpassword/(.*)";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(textMessage);
        m.find(); 
        driver.get(baseUrl);
    	driver.findElement(By.id("search")).clear();
    	driver.findElement(By.id("search")).sendKeys(m.group(2));
    	TimeUnit.SECONDS.sleep(5); 
        	    
        	TimeUnit.SECONDS.sleep(10);
    
    
    
    
   /* 
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
        String regex = "http://mandrillapp.com/track/click/(.*)\\S ";
        String regex = "https?://(.*)/customer/account/resetpassword/(.*)\\S ";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(textMessage);
        if (m.find()) {     
        m.find();
        TimeUnit.SECONDS.sleep(60);
	        	String testtest = "http://dev.personalisedgiftsshop.co.uk/default/customer/account/resetpassword/";
	        	driver.findElement(By.id("email")).clear();
	        	driver.findElement(By.id("email")).sendKeys(m.group(1));
	        	TimeUnit.SECONDS.sleep(5);
	        	driver.get(testtest + m.group());
			    assertEquals("RESET A PASSWORD", driver.findElement(By.cssSelector("h1")).getText());
			    driver.findElement(By.cssSelector("div.buttons-set > button.button.btn-primary")).click();
			    assertEquals("This is a required field.", driver.findElement(By.id("advice-required-entry-password")).getText());
			    assertEquals("This is a required field.", driver.findElement(By.id("advice-required-entry-confirmation")).getText());
			    driver.findElement(By.id("password")).clear();
			    driver.findElement(By.id("password")).sendKeys("qwerty");
			    driver.findElement(By.id("confirmation")).clear();
			    driver.findElement(By.id("confirmation")).sendKeys("qwertyu");
			    driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
			    assertEquals("Please make sure your passwords match.", driver.findElement(By.id("advice-validate-cpassword-confirmation")).getText());
			    driver.findElement(By.id("confirmation")).clear();
			    driver.findElement(By.id("confirmation")).sendKeys("qwerty");
			    driver.findElement(By.xpath("(//button[@type='submit'])[2]")).click();
			    assertEquals("Your password has been updated.", driver.findElement(By.cssSelector("li.success-msg")).getText());
			    driver.findElement(By.id("email")).clear();
			    driver.findElement(By.id("email")).sendKeys("quality_assurance@bk.ru");
			    driver.findElement(By.id("pass")).clear();
			    driver.findElement(By.id("pass")).sendKeys("qwerty");
			    driver.findElement(By.id("send2")).click();
			    assertEquals("My dashboard", driver.findElement(By.cssSelector("h1")).getText());
			    assertEquals("Great to see you, Tom Johns!", driver.findElement(By.cssSelector("h3.hello")).getText());
			    TimeUnit.SECONDS.sleep(3);
			    WebElement my_account = driver.findElement(By.id("myaccount-menu-link"));
			    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
			            ,my_account);
			    TimeUnit.SECONDS.sleep(5);
			    actions.moveToElement(my_account).build().perform();
			    TimeUnit.SECONDS.sleep(5);
			    driver.findElement(By.xpath("(//a[contains(text(),'Sign Out')])[2]")).click();
			    TimeUnit.SECONDS.sleep(5);
			    assertEquals("Sign In", driver.findElement(By.linkText("Sign In")).getText());
			    assertEquals("register", driver.findElement(By.linkText("register")).getText());
			    String title = driver.getTitle();
			    String title_test = "Home page";
			    TimeUnit.SECONDS.sleep(5);
			    assertEquals(title_test, title);
			    TimeUnit.SECONDS.sleep(5);*/
        
        inbox.close(false);
        store.close();  
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
