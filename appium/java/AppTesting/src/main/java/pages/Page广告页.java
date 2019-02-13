package pages;

import utils.HnaDriver;
import org.openqa.selenium.By;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class Page广告页 {
    private By skipAds = By.id("com.rytong.hnair.nightly:id/btn_skip");
    private By gotoMainBtn = By.xpath("//android.widget.Button[@resource-id='com.rytong.hnair.nightly:id/btn_goto_main']");
    private By cancelUpgrade = By.id("com.rytong.hnair.nightly:id/btn_cancel");

    public Page首页 gotoMainPage(){
        HnaDriver.getCurrentDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        HnaDriver.getCurrentDriver().findElement(cancelUpgrade).click();
        (new TouchAction(HnaDriver.getCurrentDriver()))
                .press(PointOption.point(1006, 1092)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(66, 1092)).release().perform();
        (new TouchAction(HnaDriver.getCurrentDriver()))
                .press(PointOption.point(1022, 921)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(23, 921)).release().perform();
        HnaDriver.getCurrentDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        HnaDriver.getCurrentDriver().findElement(gotoMainBtn).click();
        //HnaDriver.getCurrentDriver().findElement(skipAds).click();

        return new Page首页();
    }
}
