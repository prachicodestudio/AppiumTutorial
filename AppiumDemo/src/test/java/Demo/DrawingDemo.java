package Demo;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class DrawingDemo {

	public static void main(String[] args) throws InterruptedException, MalformedURLException {
		// TODO Auto-generated method stub



		//Gather desired capabilities
		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("deviceName","OnePlus AC2001");
		capabilities.setCapability("platformname", "Android");     
		capabilities.setCapability("automationName","uiautomator2");
		capabilities.setCapability("platformversion", "12");
		//com.saucelabs.mydemoapp.rn/com.saucelabs.mydemoapp.rn.MainActivity
		capabilities.setCapability("appPackage","com.saucelabs.mydemoapp.rn");
		capabilities.setCapability("appActivity", "com.saucelabs.mydemoapp.rn.MainActivity");


		URL url = URI.create("http://127.0.0.1:4723/").toURL();

		AndroidDriver driver = new AndroidDriver(url, capabilities);

		Thread.sleep(2000);

		System.out.println("Application Started");


		//find menu button 
		WebElement menu =  driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"open menu\"]/android.widget.ImageView"));
		menu.click(); //perform click action on menu button

		//find drawing option in menu
		WebElement drawing =  driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"menu item drawing\"]"));
		drawing.click(); //perform click action on drawing button

		//find drawing panel 
		WebElement drawingPanel = driver.findElement(By.xpath("//android.webkit.WebView"));
		
		Point location = drawingPanel.getLocation();
		Dimension size = drawingPanel.getSize(); //getSize method gives height and width

		//find the position where you need to touch
		int startX = (location.x + (size.getWidth() / 2));
		int startY = location.y + 100 ;

		//position till you want to move your finger to swipe/draw
		int endX = startX;
		int endY = (location.y + (size.getHeight()));

		//PointerInput class to create a sequence of actions 
		PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");

		//Sequence object, which is a list of actions that will be performed on the device
		Sequence sequence = new Sequence(finger1, 1)
				.addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
				.addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
				.addAction(new Pause(finger1, Duration.ofMillis(200))) //wait for some time
				.addAction(finger1.createPointerMove(Duration.ofMillis(100), PointerInput.Origin.viewport(), endX, endY))
				.addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg())); 

		//		//perform sequence of actions

		driver.perform(Arrays.asList(sequence));
		Thread.sleep(5000);


		driver.quit();//close session
}
