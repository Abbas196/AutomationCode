package AppiumTests.AppTest;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
    }

    @After
    public void tearDown(){
        if(driver != null){driver.quit();}
    }

    @Test
    public void test(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement screen = wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("Login Screen")));
        screen.click();
        WebElement username = wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.AccessibilityId("username")));
        username.sendKeys("alice");
        WebElement password = driver.findElement(MobileBy.AccessibilityId("password"));
        password.sendKeys("mypassword");
        WebElement login = driver.findElement(MobileBy.AccessibilityId("loginBtn"));
        login.click();
        WebElement loginText = wait.until(
                ExpectedConditions.
                        presenceOfElementLocated(By.xpath("//android.widget.TextView[contains(@text,'You are logged in')]")));
        assert(loginText.getText().contains("alice"));
    }

}
