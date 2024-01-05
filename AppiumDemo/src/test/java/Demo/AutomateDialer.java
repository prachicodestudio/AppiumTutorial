package Demo;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class AutomateDialer {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub

		//Gather Desired capabilities
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		//com.google.android.dialer/com.google.android.dialer.extensions.GoogleDialtactsActivity
		   capabilities.setCapability("deviceName","OnePlus AC2001");
	        capabilities.setCapability("platformname", "Android");     
	        capabilities.setCapability("automationName","uiautomator2");
	        capabilities.setCapability("platformversion", "12");
	        
	        capabilities.setCapability("appPackage","com.google.android.dialer");
	        capabilities.setCapability("appActivity", "com.google.android.dialer.extensions.GoogleDialtactsActivity");
	        
	        

	        URL url = URI.create("http://127.0.0.1:4723/").toURL();
	        
	        AndroidDriver driver = new AndroidDriver(url, capabilities);
	        Thread.sleep(5000);
	        System.out.println("Application Started");
	        
	       
	        
	        //click dial pad
	       driver.findElement(By.id("com.google.android.dialer:id/dialpad_fab")).click();
	    
	       //com.google.android.dialer:id/one
	     //  com.google.android.dialer:id/dialpad_voice_call_button
	       
	       //098100 12345
	       driver.findElement(By.id("com.google.android.dialer:id/zero")).click();
	       driver.findElement(By.id("com.google.android.dialer:id/nine")).click();
	       driver.findElement(By.id("com.google.android.dialer:id/eight")).click();
	       driver.findElement(By.id("com.google.android.dialer:id/one")).click();
	       driver.findElement(By.id("com.google.android.dialer:id/zero")).click();
	       driver.findElement(By.id("com.google.android.dialer:id/zero")).click();
	       driver.findElement(By.id("com.google.android.dialer:id/one")).click();
	       driver.findElement(By.id("com.google.android.dialer:id/two")).click();
	       driver.findElement(By.id("com.google.android.dialer:id/three")).click();
	       driver.findElement(By.id("com.google.android.dialer:id/four")).click();
	       driver.findElement(By.id("com.google.android.dialer:id/five")).click();
	       
	       //click in call button
	       driver.findElement(By.id("com.google.android.dialer:id/dialpad_voice_call_button")).click();

	       
	       Thread.sleep(5000);
	        driver.quit();//CLOSE SESSION
	}

}
