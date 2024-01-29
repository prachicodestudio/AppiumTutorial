package Demo;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.Collections;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class SwipeOrScroll {

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
		Thread.sleep(2000);
		System.out.println("Application Started");


		//click on view button
		driver.findElements(By.id("android:id/text1")).get(11).click();
		

		//Get Screen size
		Dimension size = driver.manage().window().getSize();
		
		//find the position where you need to touch
		int startX = size.getWidth() / 2;
		int startY = size.getHeight() / 2;
		
		//position till you want to move your finger to swipe
		int endX = startX;
		int endY = (int) (size.getHeight() * 0.25);
		
		//PointerInput class to create a sequence of actions 
		PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
		
		//Sequence object, which is a list of actions that will be performed on the device
		Sequence sequence = new Sequence(finger1, 1)
				.addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
				.addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
				.addAction(new Pause(finger1, Duration.ofMillis(200))) //wait for some time
				.addAction(finger1.createPointerMove(Duration.ofMillis(100), PointerInput.Origin.viewport(), endX, endY))
				.addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg())); 

		//perform the Sequence of action
		driver.perform(Collections.singletonList(sequence));
		
		Thread.sleep(2000);
		driver.quit();
		
		
	}

}
