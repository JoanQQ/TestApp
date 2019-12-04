package pages.iOSRegressionPages;

import org.openqa.selenium.By;
import pages.iOSRegressionPages.MainPage;
import utils.BasePage;
import utils.SingleDriver;

import java.util.concurrent.TimeUnit;

public class GdprPage extends BasePage {
    public static GdprPage gdprPage() {
        return new GdprPage();
    }

    public String getGdprTitle() {
        By byTitle = By.id ("海南航空APP使用须知");
        return this.getWebElementText (byTitle);
    }

    public void gotoPrivacyPage() {
        this.getNativeDriver ();
        By byPrivacy = By.id ("隐私条款");
        this.clickWebElement (byPrivacy);
    }

    public void gotoCookiePage() {
        this.getNativeDriver ();
        By byCookie = By.id ("Cookie政策");
        this.clickWebElement (byCookie);
    }

    public void closePrivacyOrCookie() {
        this.getWebDriver ();
        By byClose = By.className ("close-icon");
        this.clickWebElement (byClose);
    }

    public void clickToTickItem() {
        this.getNativeDriver ();
        By byItemTitle = By.id ("我已阅读并理解使用条款、隐私政策及cookie使用V1.1");
        this.clickWebElement (byItemTitle);
    }

    public void clickToContinue() {
        By byContinueBtn = By.id ("继    续");
        this.clickWebElement (byContinueBtn);
    }

    public AdsPage gotoAdsPage() {
        //this.getNativeDriver ();
        //SingleDriver.getInstance().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        //SingleDriver.getInstance().findElementByAccessibilityId("我已阅读并理解使用条款、隐私政策及cookie使用V1.1").click();
        //SingleDriver.getInstance().findElementByAccessibilityId("继    续").click();
        this.clickToTickItem ();
        this.clickToContinue ();

        return new AdsPage();
    }

    public MainPage gotoMainPage() {
        SingleDriver.getInstance().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        SingleDriver.getInstance().findElementByAccessibilityId("我已阅读并理解使用条款、隐私政策及cookie使用V1.1").click();
        SingleDriver.getInstance().findElementByAccessibilityId("继    续").click();

        return new MainPage ();
    }
}
