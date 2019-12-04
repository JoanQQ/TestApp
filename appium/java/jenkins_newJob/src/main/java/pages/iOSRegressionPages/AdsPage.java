package pages.iOSRegressionPages;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import pages.iOSRegressionPages.MainPage;
import utils.BasePage;
import utils.SingleDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class AdsPage extends BasePage {
    public static AdsPage adsPage() {
        return new AdsPage();
    }

    public MainPage gotoMainPage(){
        SingleDriver.getInstance().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        //SingleDriver.getInstance().findElement(cancelUpgrade).click();
        (new TouchAction(SingleDriver.getInstance()))
                .press(PointOption.point(339, 328)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(46, 328)).release().perform();
        SingleDriver.getInstance().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        SingleDriver.getInstance().findElementByAccessibilityId("开始体验").click();
        //SingleDriver.getInstance().findElement(skipAds).click();

        return new MainPage();
    }

    public MainPage closePromotionAds() {
        //By byCloseAdsBtn = By.xpath ("//XCUIElementTypeButton[@name=\"关闭\"]");
        this.doSleep ();
        By byCloseAdsBtn = By.id ("关闭");
        this.clickWebElement (byCloseAdsBtn);
        return new MainPage ();
    }
}
