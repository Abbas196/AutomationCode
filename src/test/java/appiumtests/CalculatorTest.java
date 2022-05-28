package appiumtests;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;

public class CalculatorTest {

	static AppiumDriver driver;
	
	
	static void openCalculator() throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "Abbas");
		cap.setCapability("udid","16c83669");
		cap.setCapability("platformName","Android");
		cap.setCapability("platformVersion","11");
		cap.setCapability("appPackage", "com.oneplus.calculator");
		cap.setCapability("appActivity", "com.oneplus.calculator.Calculator");
		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AndroidDriver(url,cap);
		System.out.println("Started..");
		WebElement two = driver.findElement(By.id("com.oneplus.calculator:id/digit_2"));
		WebElement plus = driver.findElement(By.id("com.oneplus.calculator:id/op_add"));
		WebElement three = driver.findElement(By.id("com.oneplus.calculator:id/digit_3"));
		WebElement equals = driver.findElement(By.id("com.oneplus.calculator:id/eq"));
		WebElement result = driver.findElement(By.id("com.oneplus.calculator:id/result")); 
		
		two.click();
		plus.click();
		three.click();
		equals.click();
		
		String res = result.getText();
		System.out.println("\nResult is : " + res);
		System.out.println("completed");
		
		
	}

	public static void main(String[] args) {
		try {
		openCalculator();
		}
		catch(Exception e){
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
			System.out.println(e.getStackTrace());
		}
		
	}

}
