package pages;

import org.openqa.selenium.By;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import utils.SingleDriver;

public class AdsPage {
    public static AdsPage pageAds() {
        return new AdsPage();
    }

    //private By skipAds = By.id("com.rytong.hnair.nightly:id/btn_skip");
    private By gotoMainBtn = By.xpath("//android.widget.Button[@resource-id='com.rytong.hnair.nightly:id/btn_goto_main']");
    private By cancelUpgrade = By.id("com.rytong.hnair.nightly:id/btn_cancel");

    public MainPage gotoMainPage(){
        SingleDriver.getInstance().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        SingleDriver.getInstance().findElement(cancelUpgrade).click();
        (new TouchAction(SingleDriver.getInstance()))
                .press(PointOption.point(1006, 1092)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(66, 1092)).release().perform();
        (new TouchAction(SingleDriver.getInstance()))
                .press(PointOption.point(1022, 921)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(23, 921)).release().perform();
        SingleDriver.getInstance().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        SingleDriver.getInstance().findElement(gotoMainBtn).click();
        //SingleDriver.getInstance().findElement(skipAds).click();

        return new MainPage();
    }
}
