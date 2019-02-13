package pages;

import utils.HnaDriver;
import org.openqa.selenium.By;

public class PageGdpr {

    public static PageGdpr gdprPage() {
        return new PageGdpr();
    }

    private By gdprText = By.xpath("//android.view.View[@resource-id='uncheck_ipt']");
    private By gdprConfirmation = By.id("act_btn");

    public Page授权 gotoAuthPage(){
        HnaDriver.getCurrentDriver().findElement(gdprText).click();
        HnaDriver.getCurrentDriver().findElement(gdprConfirmation).click();

        return new Page授权();
    }

    public Page广告页 gotoAdsPage() {
        HnaDriver.getCurrentDriver().findElement(gdprText).click();
        HnaDriver.getCurrentDriver().findElement(gdprConfirmation).click();

        return new Page广告页();
    }
}
