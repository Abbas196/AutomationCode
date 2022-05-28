package AppiumTests.AppTest;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class SessionsBefore {
    private static final String APP = "https://github.com/cloudgrey-io/the-app/releases/download/v1.9.0/TheApp-v1.9.0.apk";
    private final String APPIUM = "http://127.0.0.1:4723/wd/hub";
    private AndroidDriver driver;

    @Before
    public void setup() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("platformName","Android");
        dc.setCapability("platformVersion","9");
        dc.setCapability("deviceName","Android Emulator");
        dc.setCapability("automationName","UiAutomator2");
        dc.setCapability("app",APP);
        driver = new AndroidDriver(new URL(APPIUM),dc);
        try{Thread.sleep(3000);}catch (Exception e){}
    }

    @After
    public void tearDown(){
        if(driver != null){driver.quit();}
    }

    @Test
    public void test(){
        WebElement element = driver.findElement(MobileBy.AccessibilityId("Login Screen"));
    }

}
