package checkout;

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

public class Email extends PGS.pages.TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

    @Test
  public void Email() throws Exception {
    	driver.manage().window().maximize();
    	driver.get(baseUrl);
    	class MailAuthenticator extends Authenticator {
     		 
    	    public PasswordAuthentication getPasswordAuthentication() {
    	         return new PasswordAuthentication("qatestingtestqa@mail.ru", "parol123");
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
            String regex = "Your Order #(.*)";
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(textMessage);
            m.find(); 
            	driver.get(baseUrl);
            	driver.findElement(By.id("search")).clear();
            	driver.findElement(By.id("search")).sendKeys(m.group());
            	TimeUnit.SECONDS.sleep(5); 

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
