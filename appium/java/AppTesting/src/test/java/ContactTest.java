import org.junit.Test;
import junit.framework.TestCase;
import utils.SingleDriver;
import pages.Mine.MinePage;
import pages.Mine.ContactPage;
import org.junit.BeforeClass;
import pages.Common.AdsPage;
import pages.Common.GdprPage;
import pages.Common.LoginPage;
import pages.Main.MainPage;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;

/**
 * @author Phyllis
 * @date 2019-02-19 09:41
 */
public class ContactTest {

    //public static MinePage minePage1,minePage2;

    @BeforeClass
    public static void openApp() {
        System.out.println ("BeforeClass");
        SingleDriver.getInstance();
        GdprPage gdprPage = new GdprPage();
        AdsPage adsPage = gdprPage.gotoAdsPage();
        MainPage mainPage = adsPage.gotoMainPage();
        //MinePage minePage1 = mainPage.gotoMinePage ();
        mainPage.gotoMinePage ();
    }

    @Test
    public void testLogin() {
        SingleDriver.getInstance ();
        System.out.println ("*** TEST LOGIN ***");
        MinePage minePage = new MinePage ();
        LoginPage loginPage = minePage.gotoLoginPage();
        loginPage.gotoMinePage("7050812098","121321");
        SingleDriver.getInstance().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @Test
    public void testContact() {
        SingleDriver.getInstance ();
        MinePage minePage = new MinePage ();
        ContactPage contactPage = minePage.gotoContactPage ();
        //contactPage.addContact ();
        //contactPage.verifyRequiredFileds ();
        contactPage.delContact ();
        contactPage.backtoMinePage ();
    }
}