package utils;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

/**
 * @author Phyllis
 * @Description ${todo}
 * @date 2019-02-14 10:31
 */
public class SingleDriver {
    /** 唯一实例 */
    public static AppiumDriver<WebElement> driver;

    /** 封闭程序，防止被实例化 */
    private SingleDriver() {}

    public static AppiumDriver<WebElement> getInstance() {
        if(driver == null) {
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability("deviceName", "emulator-5554");
            desiredCapabilities.setCapability("platformName", "android");
            desiredCapabilities.setCapability("appPackage", "com.rytong.hnair.nightly");
            desiredCapabilities.setCapability("appActivity", "com.rytong.hnair.main.SplashActivity");
            desiredCapabilities.setCapability("autoGrantPermissions", true);
            desiredCapabilities.setCapability("unicodeKeyboard", true);
            desiredCapabilities.setCapability ("clearSystemFiles", true);
            desiredCapabilities.setCapability("noReset", true);
            /**
            desiredCapabilities.setCapability("resetKeyboard", true);
             desiredCapabilities.setCapability("automationName","uiautomator2");
            desiredCapabilities.setCapability("app","/Users/phyllis/Downloads/7.1.0_nightly.55793.nightly.release.12622.7.1_3.apk");
            */

            try {
                driver = new AppiumDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
                driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
        }
        return driver;
    }

    public static void quit() { driver.quit(); }
}