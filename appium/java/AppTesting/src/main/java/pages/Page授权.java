package pages;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.HnaDriver;
import org.openqa.selenium.By;
import java.util.concurrent.TimeUnit;

/**
 * @author Phyllis
 * @date 2019-02-12 16:47
 */
public class Page授权 extends BasePage {
    private By permissionAllow = By.xpath("//*[@resource-id='com.android.packageinstaller:id/permission_allow_button' and @text='ALLOW']");
    private By getPermissionDeny = By.xpath("//*[@resource-id='com.android.packageinstaller:id/permission_deny_button' and @text='DENY']");
    private By cancelUpgrade = By.id("com.rytong.hnair.nightly:id/btn_cancel");

    public Page广告页 gotoAdsPage(){
        HnaDriver.getCurrentDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        MobileElement allowPerm = (MobileElement) new WebDriverWait(HnaDriver.getCurrentDriver(), 2)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='com.android.packageinstaller:id/permission_allow_button']")));
        find(permissionAllow).click();
        MobileElement denyPerm = (MobileElement) new WebDriverWait(HnaDriver.getCurrentDriver(), 2)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='com.android.packageinstaller:id/permission_deny_button']")));
        find(getPermissionDeny).click();

        MobileElement cancelUp = (MobileElement) new WebDriverWait(HnaDriver.getCurrentDriver(), 5)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@resource-id='com.rytong.hnair.nightly:id/btn_cancel']")));
        find(cancelUpgrade).click();

        return new Page广告页();
    }
}