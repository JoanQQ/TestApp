package pages;

import utils.HnaDriver;
import io.appium.java_client.touch.WaitOptions;
import java.time.Duration;
import org.openqa.selenium.By;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

import java.util.concurrent.TimeUnit;

public class PageGdpr {
    public static PageGdpr gdprPage() {
        return new PageGdpr();
    }

    private By gdprText = By.xpath("//android.view.View[@resource-id='uncheck_ipt']");
    private By gdprConfirmation = By.id("act_btn");
    private By gotoMainBtn = By.xpath("//android.widget.Button[@resource-id='com.rytong.hnair.nightly:id/btn_goto_main']");
    private By cancelUpgrade = By.id("com.rytong.hnair.nightly:id/btn_cancel");

    public Page首页 gotoMainPage(){
        HnaDriver.getCurrentDriver().findElement(gdprText).click();
        HnaDriver.getCurrentDriver().findElement(gdprConfirmation).click();
        HnaDriver.getCurrentDriver().findElement(cancelUpgrade).click();

        HnaDriver.getCurrentDriver().manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        (new TouchAction(HnaDriver.getCurrentDriver()))
                .press(PointOption.point(859, 910)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3))).moveTo(PointOption.point(155, 898)).release().perform();
        (new TouchAction(HnaDriver.getCurrentDriver()))
                .press(PointOption.point(898, 987)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3))).moveTo(PointOption.point(132, 941)).release().perform();
        HnaDriver.getCurrentDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        HnaDriver.getCurrentDriver().findElement(gotoMainBtn).click();
        return new Page首页();
    }
}
