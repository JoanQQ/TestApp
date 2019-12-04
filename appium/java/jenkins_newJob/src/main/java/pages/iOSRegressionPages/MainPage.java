package pages.iOSRegressionPages;

import org.openqa.selenium.By;
import utils.BasePage;

public class MainPage extends BasePage {
    public static MainPage mainPage() { return new MainPage(); }

    public LoginPage gotoFfpPageWithouLogin() {
        this.waitForMoreTime ();
        By byFfpTab = By.id ("金鹏卡");
        this.clickWebElement (byFfpTab);
        return new LoginPage ();
    }

    public FfpPage gotoFfpPageWithLogin() {
        By byFfpTab = By.id ("金鹏卡");
        this.clickWebElement (byFfpTab);
        return new FfpPage ();
    }

    public void cancelUpgrade() {
        //By byCancelUpgrade = By.id("com.rytong.hnair.nightly:id/btn_cancel");
        By byCancelUpgrade = By.id ("以后再说");
        this.clickWebElement (byCancelUpgrade);
    }

    public void closePopupPromotin() {
        By byClostBtn = By.id ("btn ad close");
        this.clickWebElement (byClostBtn);
    }
}