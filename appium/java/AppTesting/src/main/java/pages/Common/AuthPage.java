package pages.Common;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import utils.SingleDriver;

import java.util.concurrent.TimeUnit;

/**
 * @author Phyllis
 * @date 2019-02-12 16:47
 */
public class AuthPage extends BasePage {
    private By permissionAllow = By.xpath("//*[@resource-id='com.android.packageinstaller:id/permission_allow_button' and @text='ALLOW']");
    private By getPermissionDeny = By.xpath("//*[@resource-id='com.android.packageinstaller:id/permission_deny_button' and @text='DENY']");
    private By cancelUpgrade = By.id("com.rytong.hnair.nightly:id/btn_cancel");

    public AdsPage gotoAdsPage(){
        SingleDriver.getInstance().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        MobileElement allowPerm = (MobileElement) new WebDriverWait(SingleDriver.getInstance(), 2)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='com.android.packageinstaller:id/permission_allow_button']")));
        find(permissionAllow).click();
        MobileElement denyPerm = (MobileElement) new WebDriverWait(SingleDriver.getInstance(), 2)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='com.android.packageinstaller:id/permission_deny_button']")));
        find(getPermissionDeny).click();

        MobileElement cancelUp = (MobileElement) new WebDriverWait(SingleDriver.getInstance(), 5)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='com.rytong.hnair.nightly:id/btn_cancel']")));
        find(cancelUpgrade).click();

        return new AdsPage();
    }
}