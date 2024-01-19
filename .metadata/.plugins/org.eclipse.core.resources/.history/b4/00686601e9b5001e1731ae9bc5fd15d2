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

public class DragAndDropW3CActions {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub


		//Gather desired capabilities
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		   capabilities.setCapability("deviceName","OnePlus AC2001");
	        capabilities.setCapability("platformname", "Android");     
	        capabilities.setCapability("automationName","uiautomator2");
	        capabilities.setCapability("platformversion", "12");
	        //io.appium.android.apis/io.appium.android.apis.ApiDemos
	        capabilities.setCapability("appPackage","io.appium.android.apis");
	        capabilities.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
	        

	        URL url = URI.create("http://127.0.0.1:4723/").toURL();
	        
	        AndroidDriver driver = new AndroidDriver(url, capabilities);
	       
	        Thread.sleep(2000);
	       
	        System.out.println("Application Started");
	        
	        
	        //find view button
	       WebElement viewBtn =  driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Views\"]"));
	       viewBtn.click(); //perform click action on view button
	       
	       //find drag and drop button
	       WebElement dragAndDropBtn =  driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Drag and Drop\"]"));
	       dragAndDropBtn.click(); //perform click action on view button
	       
	       WebElement source =  driver.findElement(By.xpath("//android.view.View[@resource-id=\"io.appium.android.apis:id/drag_dot_1\"]"));
	     
	       WebElement destination =  driver.findElement(By.xpath("//android.view.View[@resource-id=\"io.appium.android.apis:id/drag_dot_2\"]"));
	
	       //find center of source and target web element
	       Point sourceElementCenter = getCenter(source);
			Point targetElementCenter = getCenter(destination);
			
			//PointerInput class to create a sequence of actions 
			//that move the pointer to the center of the element, 
			//press down on the element, and then release the element.

			
			PointerInput finger1 = new PointerInput (PointerInput.Kind.TOUCH,"finger1");
			
			//Sequence object, which is a list of actions that will be performed on the device

			Sequence sequence = new Sequence (finger1, 1)
					
					//move finger to the starting position
					.addAction (finger1.createPointerMove (Duration.ZERO, PointerInput.Origin.viewport(), sourceElementCenter))
					
					
					//finger coming down to contact with screen
					.addAction (finger1.createPointerDown(PointerInput.MouseButton. LEFT.asArg()))
					
					.addAction(new Pause(finger1, Duration.ofMillis(588)))
					
					//move finger to the end position
					.addAction(finger1.createPointerMove(Duration.ofMillis(588), PointerInput.Origin.viewport(), targetElementCenter))
					
					//move the finger up
					.addAction (finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
			
			//perform sequence of actions
			//driver.perform(Collections.singletonList(sequence));
		//
			driver.perform(Arrays.asList(sequence));
			Thread.sleep(2000);
			
			driver.quit(); //close session
	
	}
	

private static Point getCenter(WebElement element)
{
	//get location of the element
	Point location = element.getLocation();
	
	//get dimension (height & width of the element)
	Dimension size = element.getSize();
	
	//center point
	Point center = new Point (location.x + size.width/2, location.y + size.height/2);
	
	return center;
	
}

}
