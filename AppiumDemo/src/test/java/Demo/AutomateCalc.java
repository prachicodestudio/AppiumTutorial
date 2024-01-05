package Demo;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class AutomateCalc {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub

		//Gather Desired capabilities
		
				DesiredCapabilities capabilities = new DesiredCapabilities();
				
				   capabilities.setCapability("deviceName","OnePlus AC2001");
			        capabilities.setCapability("platformname", "Android");     
			        capabilities.setCapability("automationName","uiautomator2");
			        capabilities.setCapability("platformversion", "12");
			        
			        capabilities.setCapability("appPackage","com.oneplus.calculator");
			        capabilities.setCapability("appActivity", "com.oneplus.calculator.Calculator");
			        
			        

			        URL url = URI.create("http://127.0.0.1:4723/").toURL();
			        
			        AndroidDriver driver = new AndroidDriver(url, capabilities);
			        Thread.sleep(5000);
			        System.out.println("Application Started");
			        
			        
			        //click on number 8
			       WebElement num8 =  driver.findElement(By.id("com.oneplus.calculator:id/digit_8"));
			       num8.click(); //perform click action on number 8
			       
			       //click on plus sign
			       WebElement plus =  driver.findElement(By.id("com.oneplus.calculator:id/op_add"));
			       plus.click(); //perform click action on number 8
			    
			        //click on number 2
			       WebElement num2 =  driver.findElement(By.id("com.oneplus.calculator:id/digit_2"));
			       num2.click(); //perform click action on number 8
			    
			       
			        //click on equal sign
			       WebElement equal =  driver.findElement(By.id("com.oneplus.calculator:id/eq"));
			       equal.click(); //perform click action on number 8
			    
			       
			       //click on result sign
			       WebElement result =  driver.findElement(By.id("com.oneplus.calculator:id/result"));
			      String resultString = result.getText();
			      
			      if(resultString.equals("10"))
			      {
			    	  System.out.println("Pass");
			      }
			      else
			      {
			    	  System.out.println("fail");
			      }
			      
			    
			 
			        driver.quit();//CLOSE SESSION
			        
	}

}
