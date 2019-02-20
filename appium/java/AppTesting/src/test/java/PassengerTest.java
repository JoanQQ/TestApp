import io.appium.java_client.MobileElement;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Common.AdsPage;
import pages.Common.GdprPage;
import pages.Main.MainPage;
import pages.Mine.MinePage;
import utils.SingleDriver;

import java.util.concurrent.TimeUnit;

/**
 * @author Phyllis
 * @date 2019-02-20 09:53
 */
public class PassengerTest {
    @BeforeClass
    public static void openApp() {
        SingleDriver.getInstance();
        /**
        GdprPage gdprPage = new GdprPage();
        AdsPage adsPage = gdprPage.gotoAdsPage();
        MainPage mainPage = adsPage.gotoMainPage();
        */
        MainPage mainPage = new MainPage ();
        mainPage.cancelUpgrade ();
        final MinePage minePage = mainPage.gotoMinePage ();
    }

    @Test
    public void testPassenger() {
        MinePage minePage = new MinePage ();
        minePage.gotoPassengerPage();
    }
}
