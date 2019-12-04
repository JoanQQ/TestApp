package utils;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * @author Phyllis
 * @date 2019-07-23 09:28
 */
public class SingleDriver {
    /** 唯一实例 */
    public static AppiumDriver<WebElement> driver;

    /** 封闭程序，防止被实例化 */
    private SingleDriver() {}

    public static AppiumDriver<WebElement> getInstance() {
        if(driver == null) {
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            ChromeOptions chromeOptions = new ChromeOptions ();
            chromeOptions.setExperimentalOption ("androidProcess", "com.tencent.mm:tools");
            desiredCapabilities.setCapability("platformName", "Android");
            desiredCapabilities.setCapability("platformVersion", "8.0.0");
            desiredCapabilities.setCapability("deviceName", "APU7N16713000409");
            desiredCapabilities.setCapability("appPackage", "com.tencent.mm");
            desiredCapabilities.setCapability("appActivity", ".ui.LauncherUI");    // .plugin.webview.ui.tools.WebViewUI
            desiredCapabilities.setCapability("noReset", "True");
            desiredCapabilities.setCapability("automationName", "Appium");
            desiredCapabilities.setCapability ("chromedriverExecutableDir","/Users/phyllis/Downloads/ChromeDrivers&ChromePkg/2.39");
            desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
            desiredCapabilities.setCapability("browserName", "");

            try {
                driver = new AppiumDriver<WebElement> (new URL ("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        return driver;
    }

    public void quit() { driver.quit(); }
}
