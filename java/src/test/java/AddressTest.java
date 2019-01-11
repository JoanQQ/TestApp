import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Description: TestApp
 * Created by Phyllis on 2018-12-28 09:42
 */
public class AddressTest {
    private AndroidDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName", "emulator-5554");
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("appPackage", "com.rytong.hnair.nightly");
        desiredCapabilities.setCapability("appActivity", "com.rytong.hnair.main.SplashActivity");

        URL remoteUrl = new URL("http://0.0.0.0:4723/wd/hub");

        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
    }

    @Test
    public void sampleTest() {
        /** GDPR页 */
        MobileElement searchCheckBtn = (MobileElement) new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.view.View[@resource-id='uncheck_ipt']")));
        driver.findElementByXPath("//android.view.View[@resource-id='uncheck_ipt']").click();
        driver.findElementById("act_btn").click();
        /** 赋予权限 */
        MobileElement searchAllowBtn = (MobileElement) new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='com.android.packageinstaller:id/permission_allow_button']")));
        driver.findElementByXPath("//*[@resource-id='com.android.packageinstaller:id/permission_allow_button' and @text='ALLOW']").click();
        driver.findElementByXPath("//*[@resource-id='com.android.packageinstaller:id/permission_deny_button' and @text='DENY']").click();
        /** 浏览广告 开始体验 */
        MobileElement searchGotoBtn = (MobileElement) new WebDriverWait(driver, 5)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@resource-id='com.rytong.hnair.nightly:id/btn_goto_main']")));
        driver.findElementByXPath("//android.widget.Button[@resource-id='com.rytong.hnair.nightly:id/btn_goto_main']").click();

/** 登录 */
        MobileElement searchLoginPage = (MobileElement) new WebDriverWait(driver, 6)
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("com.rytong.hnair.nightly:id/btn_login")));
        driver.findElementById("com.rytong.hnair.nightly:id/btn_login").click();
        MobileElement searchLoginBtn = (MobileElement) new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("com.rytong.hnair.nightly:id/et_username")));
        driver.findElementById("com.rytong.hnair.nightly:id/et_username").sendKeys("7050812098");
        driver.findElementById("com.rytong.hnair.nightly:id/et_password").sendKeys("121321");
        /** */
        /** */

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}