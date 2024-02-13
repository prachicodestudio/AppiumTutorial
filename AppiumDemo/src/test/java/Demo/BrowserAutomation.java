package Demo;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class BrowserAutomation {

	public static void main(String[] args) throws InterruptedException, MalformedURLException {
		// TODO Auto-generated method stub

		//Gather Desired capabilities
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		   capabilities.setCapability("deviceName","OnePlus AC2001");
	        capabilities.setCapability("platformname", "Android");     
	        capabilities.setCapability("automationName","uiautomator2");
	        capabilities.setCapability("platformversion", "12");
	        capabilities.setCapability("browserName", "Chrome");
	        capabilities.setCapability("chromedriverExecutable","C:\\Users\\ASUS\\Desktop\\Appium\\AppiumDemo\\driver\\chromedriver-win64\\chromedriver.exe");;
	      //  capabilities.setCapability("appPackage","com.oneplus.calculator");
	       // capabilities.setCapability("appActivity", "com.oneplus.calculator.Calculator");
	        
	        

	        URL url = URI.create("http://127.0.0.1:4723/").toURL();
	        
	        AndroidDriver driver = new AndroidDriver(url, capabilities);
	        
	        driver.get("https://www.google.com/");
	        
	        //find search box web element
	        WebElement searchBox = driver.findElement(By.name("q"));
	        
	        searchBox.sendKeys("Taj mahal");
	        searchBox.sendKeys(Keys.RETURN);
	        
	        Thread.sleep(3000);
	        driver.quit();
	        
	        
	}

}
