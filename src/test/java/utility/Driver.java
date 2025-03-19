package utility;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Driver {
    private static AndroidDriver driver;
    private final static String platformName = ConfigReader.getProperty("platformName");
    private final static String automationName = ConfigReader.getProperty("automationName");
    private final static String deviceName = ConfigReader.getProperty("deviceName");
    private final static String udId = ConfigReader.getProperty("udId");
    private final static String platformVersion = ConfigReader.getProperty("platformVersion");
    private final static String appPackage = ConfigReader.getProperty("appPackage");
    private final static String appActivity = ConfigReader.getProperty("appActivity");

    private Driver() {
    }

    public static AndroidDriver getDriver() {
        if (driver == null) {
            DesiredCapabilities cap = new DesiredCapabilities();
            cap.setCapability("platformName", platformName);
            cap.setCapability("automationName", automationName);
            cap.setCapability("deviceName", deviceName);
            cap.setCapability("udid", udId);
            cap.setCapability("platformVersion", platformVersion);
            cap.setCapability("appPackage", appPackage);
            cap.setCapability("appActivity", appActivity);
            cap.setCapability("noReset", true);

            try {
                URL url = new URL("http://127.0.0.1:4723");
                driver = new AndroidDriver(url, cap);
            } catch (MalformedURLException e) {
                Assert.fail("Url not found");
            }
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
            try {
                Runtime.getRuntime().exec("adb shell am force-stop " + appPackage);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}