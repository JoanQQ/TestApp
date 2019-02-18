import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import junit.framework.TestCase;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;
import utils.SingleDriver;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

/**
 * @author Phyllis
 * @date 2019-02-14 14:03
 */
public class MineTest {
    public static MinePage minePage;

    @BeforeClass
    public static void openApp() {
        System.out.println ("BeforeClass");
        SingleDriver.getInstance();
        GdprPage gdprPage = new GdprPage();
        AdsPage adsPage = gdprPage.gotoAdsPage();
        MainPage mainPage = adsPage.gotoMainPage();
        minePage = mainPage.gotoMinePage();
    }

    @Test
    public void testLogin() {
        System.out.println ("*** TEST LOGIN ***");
        LoginPage loginPage = minePage.gotoLoginPage();
        MinePage minePage2 = loginPage.gotoMinePage("7050812098","121321");
        SingleDriver.getInstance().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        assertEquals("LIQIONGTEST ZHAOTEST", minePage2.getUsername());
        System.out.println("Username is correct");
        assertEquals("金卡 7050812098", minePage2.getFfpid());
        System.out.println("FFP card level and ID are correct");
        assertEquals("可用积分 12881.1", minePage2.getScore());
        System.out.println("Available point is correct");
        assertEquals ("已实名认证", minePage2.getCertificationStatus ());
        System.out.println("Certification is correct");
    }

    @Test
    public void testSetting() {
        System.out.println ("*** TEST SETTINGs ***");
        minePage.gotoSettingsPage ().gotoPrivacyPolicy ();
        SingleDriver.getInstance().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String textTitle = SingleDriver.getInstance ().findElementByXPath ("//android.widget.TextView[@resource-id='com.rytong.hnair.nightly:id/tv_middle_title']").getText ();
        assertEquals ("隐私条款",textTitle);
        (new TouchAction (SingleDriver.getInstance ())).tap(PointOption.point (70, 160)).perform ();
        System.out.println ("Privacy Policy is correct");
    }

    @Test
    public void testCenterMenu() {
        MinePage minePage = new MinePage ();
        minePage.backFromOrder();
        minePage.backFromCoupon ();
        minePage.backFromFavor ();
    }

    @AfterClass
    public static void afterClass() {
        SingleDriver.quit ();
        System.out.println("@AfterClass");
    }
}
