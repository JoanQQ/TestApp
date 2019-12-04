package utils;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.chrome.ChromeOptions;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import java.net.URL;

/**
 * @author Phyllis
 * @date 2019-10-15 13:25
 */
public class SingleDriver {
    /** 唯一实例 */
    public static AppiumDriver<WebElement> driver;

    /** 封闭程序，防止被实例化 */
    private SingleDriver() {}

    public static AppiumDriver<WebElement> getInstance() {
        if(driver == null) {
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities ();
            /**
            ChromeOptions options = new ChromeOptions ();
            options.setExperimentalOption ("androidProcess", "com.tencent.mm:tools");
            desiredCapabilities.setCapability("platformName", "Android");
            desiredCapabilities.setCapability("platformVersion", "8.0.0");
            desiredCapabilities.setCapability("deviceName", "APU7N16713000409");
            desiredCapabilities.setCapability("appPackage", "com.tencent.mm");
            desiredCapabilities.setCapability("appActivity", ".ui.LauncherUI");    // .plugin.webview.ui.tools.WebViewUI
            desiredCapabilities.setCapability("noReset", "True");
            desiredCapabilities.setCapability("automationName", "Appium");
            desiredCapabilities.setCapability ("chromedriverExecutableDir","/Users/phyllis/Downloads/ChromeDrivers&ChromePkg/2.39");
            desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
            desiredCapabilities.setCapability("browserName", "");
            */

            desiredCapabilities.setCapability("noReset", false);
            desiredCapabilities.setCapability("platformName", "iOS");
            desiredCapabilities.setCapability("autoAcceptAlerts", true);
            desiredCapabilities.setCapability("startIWDP", true);
            desiredCapabilities.setCapability("useNewWDA", true);
            desiredCapabilities.setCapability("automationName", "XCUITest");
            desiredCapabilities.setCapability("clearSystemFiles", true);
            desiredCapabilities.setCapability("deviceName", "iPhone Simulator");
            desiredCapabilities.setCapability("platformVersion", "12.1");
            desiredCapabilities.setCapability("app","/Users/phyllis/Library/Developer/Xcode/DerivedData/HNAApp-fnuotrdntdyikngnyfasfvxpflgk/Build/Products/DebugNightly-iphonesimulator/HNAApp.app");

            try {
                driver = new AppiumDriver<WebElement> (new URL ("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        return driver;
    }

    public static void quit() { driver.quit(); }
}
