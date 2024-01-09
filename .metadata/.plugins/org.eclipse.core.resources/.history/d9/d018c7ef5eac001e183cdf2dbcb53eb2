package Demo;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class APKInstall {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub

		//Gather Desired capabilities
		//edited
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		   capabilities.setCapability("deviceName","OnePlus AC2001");
	        capabilities.setCapability("platformname", "Android");     
	        capabilities.setCapability("automationName","uiautomator2");
	        capabilities.setCapability("app", "C:\\Users\\ASUS\\Desktop\\Appium\\apkfiles\\sample Calculator_1.0_Apkpure.apk");
	        capabilities.setCapability("platformversion", "12");
	        
	        

	        URL url = URI.create("http://127.0.0.1:4723/").toURL();
	        
	        AndroidDriver driver = new AndroidDriver(url, capabilities);
	       
	        Thread.sleep(5000);
	        System.out.println("Application Started");
	        driver.quit();//CLOSE SESSION
	        
		
	}

}
