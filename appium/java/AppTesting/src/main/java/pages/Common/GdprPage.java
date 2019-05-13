package pages.Common;

import org.openqa.selenium.By;
import utils.SingleDriver;

import java.util.concurrent.TimeUnit;

public class GdprPage {

    public static GdprPage gdprPage() {
        return new GdprPage();
    }

    private By gdprText = By.xpath("//android.view.View[@resource-id='uncheck_ipt']");
    private By gdprConfirmation = By.id("act_btn");

    public AuthPage gotoAuthPage(){
        SingleDriver.getInstance().findElement(gdprText).click();
        SingleDriver.getInstance().findElement(gdprConfirmation).click();

        return new AuthPage();
    }

    public AdsPage gotoAdsPage() {
        SingleDriver.getInstance().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        SingleDriver.getInstance().findElement(gdprText).click();
        SingleDriver.getInstance().findElement(gdprConfirmation).click();

        return new AdsPage();
    }
}
