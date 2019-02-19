import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import junit.framework.TestCase;
import pages.Mine.MinePage;
import pages.Mine.SettingsPage;
import utils.SingleDriver;
import java.util.concurrent.TimeUnit;

/**
 * @author Phyllis
 * @date 2019-02-19 12:08
 */
public class SettingsTest extends TestCase {
    public void testSettings() {
        SingleDriver.getInstance ();
        System.out.println ("\n" + "*** TEST SETTINGs ***");
        MinePage minePage = new MinePage ();
        SettingsPage settingsPage = minePage.gotoSettingsPage();
        settingsPage.gotoPrivacyPolicy ();
        SingleDriver.getInstance().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String textTitle = SingleDriver.getInstance ().findElementByXPath ("//android.widget.TextView[@resource-id='com.rytong.hnair.nightly:id/tv_middle_title']").getText ();
        assertEquals ("隐私条款",textTitle);
        System.out.println ("Privacy Policy is correct");
        (new TouchAction (SingleDriver.getInstance ())).tap(PointOption.point (70, 160)).perform ();
        settingsPage.backtoMinePage ();
    }
}
