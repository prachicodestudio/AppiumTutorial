package Demo;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class SwitchHandling {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub
		//Gather Desired capabilities

		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("deviceName","OnePlus AC2001");
		capabilities.setCapability("platformname", "Android");     
		capabilities.setCapability("automationName","uiautomator2");
		capabilities.setCapability("platformversion", "12");

		capabilities.setCapability("appPackage","io.appium.android.apis");
		capabilities.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
		//io.appium.android.apis/io.appium.android.apis.ApiDemos


		URL url = URI.create("http://127.0.0.1:4723/").toURL();

		AndroidDriver driver = new AndroidDriver(url, capabilities);
		Thread.sleep(5000);
		System.out.println("Application Started");


		//click on view button
		driver.findElements(By.id("android:id/text1")).get(11).click();
		
		//scroll on web page
		String MobElementToScroll = "Switches";
	
		WebElement SwitchElement = driver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true))" +
						".scrollIntoView(new UiSelector().text(\"" + MobElementToScroll + "\"))"));
		
		SwitchElement.click();
		
		
		WebElement monitoredSwitch = driver.findElement(By.id("io.appium.android.apis:id/monitored_switch"));
	   
		if(monitoredSwitch.isSelected()==true)
		{
			System.out.println("Monitoried Switch is ON");
		}
		else
		{
			System.out.println("Monitoried Switch is OFF. Doing Switch On");
			monitoredSwitch.click();
		}
		
		
		Thread.sleep(5000);
	        driver.quit();//CLOSE SESSION

	}

}
