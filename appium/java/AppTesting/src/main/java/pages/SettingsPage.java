package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.SingleDriver;

import java.util.concurrent.TimeUnit;

public class SettingsPage extends BasePage {
    public static SettingsPage settingsPage() { return new SettingsPage (); }

    private By newmsgSwitch = By.xpath ("//android.view.View[@text='新消息接收开关']");
    private By securitySetting = By.xpath ("//android.view.View[@text='安全设置']");
    private By clearCache = By.xpath ("//android.view.View[@text='清除缓存']");
    private By appUpgrade = By.xpath ("//android.view.View[@text='应用更新']");
    private By appRecommendation = By.xpath ("//android.view.View[@text='应用推荐']");
    private By appScored = By.xpath ("//android.view.View[@text='应用打分']");
    private By versionText = By.xpath ("//android.view.View[@text='版本说明']");
    private By privacyPolicy = By.xpath ("//android.view.View[@text='隐私条款']");

    public void gotoPrivacyPolicy() {
        find(privacyPolicy).click ();
        By title = By.id ("com.rytong.hnair.nightly:id/tv_middle_title");
        final MobileElement waitOrders = (MobileElement) new WebDriverWait(SingleDriver.getInstance(),25)
                .until(ExpectedConditions.visibilityOfElementLocated(title));
    }
}
