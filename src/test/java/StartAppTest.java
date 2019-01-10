/**
 * Description: TestApp
 * Created by Phyllis on 2018-12-28 12:15
 */
import java.net.MalformedURLException;
import java.net.URL;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StartAppTest {
    private AndroidDriver<WebElement> driver=null;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName", "emulator-5554");
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("appPackage", "com.rytong.hnair.nightly");
        desiredCapabilities.setCapability("appActivity", "com.rytong.hnair.main.SplashActivity");

        URL remoteUrl = new URL("http://0.0.0.0:4723/wd/hub");

        driver = new AndroidDriver<WebElement>(remoteUrl, desiredCapabilities);
    }

    @Test
    public void GdprTest() {
        /** GDPR页 */
        MobileElement searchCheckBtn = (MobileElement) new WebDriverWait(driver, 60)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[@resource-id='uncheck_ipt']")));
        driver.findElementByXPath("//android.view.View[@resource-id='uncheck_ipt']").click();
        driver.findElementById("act_btn").click();
    }

    @Test
    public void PemissionTest() {
        /** 赋予权限 */
        MobileElement searchAllowBtn = (MobileElement) new WebDriverWait(driver, 60)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='com.android.packageinstaller:id/permission_allow_button']")));
        driver.findElementByXPath("//*[@resource-id='com.android.packageinstaller:id/permission_allow_button' and @text='ALLOW']").click();
        driver.findElementByXPath("//*[@resource-id='com.android.packageinstaller:id/permission_deny_button' and @text='DENY']").click();
    }

    @Test
    public void UpgradeTest() {

    }

    @Test
    public void LoginTest() {

    }

}
