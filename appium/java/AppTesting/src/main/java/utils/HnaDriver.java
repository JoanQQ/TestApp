package utils;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

/**
 * @author Phyllis
 * @date 2019-01-13 21:43
 */
public class HnaDriver {

    private static AppiumDriver<WebElement> driver;

    public static void setUpApp() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName", "emulator-5554");
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("appPackage", "com.rytong.hnair.nightly");
        desiredCapabilities.setCapability("appActivity", "com.rytong.hnair.main.SplashActivity");
        desiredCapabilities.setCapability("autoGrantPermissions", true);
        //desiredCapabilities.setCapability("app","/Users/phyllis/Downloads/7.1.0_nightly.55793.nightly.release.12622.7.1_3.apk");

        try {
            driver = new AppiumDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
            driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public static AppiumDriver getCurrentDriver() {
        return driver;
    }

    public static void quit() { driver.quit(); }

    public static void installApp() {
        //todo: install app
    }
}