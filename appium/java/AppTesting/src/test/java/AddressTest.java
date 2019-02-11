import org.junit.AfterClass;
import org.junit.runners.Parameterized;
import utils.HnaDriver;
import org.junit.BeforeClass;
import org.junit.Test;
import pages.*;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

public class AddressTest {
    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][] {
                {"7050812098", "121321"}
        };
    }
    @Parameterized.Parameter
    public String username;
    @Parameterized.Parameter(1)
    public String password;

    @BeforeClass
    public static void beforeClass() throws MalformedURLException {
        HnaDriver.launchHnaApp();
        //Page广告页 appStart = Page广告页.start();
        //PageGdpr pageGdpr = PageGdpr.start();
        //HnaDriver.getCurrentDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void afterClass() {
        HnaDriver.quit();
    }

    @Test
    public void AgreeGdpr() {
        PageGdpr pageGdpr = new PageGdpr();
        Page首页 mainPage1 = pageGdpr.gotoMainPage();
        Page登录 loginPage = mainPage1.gotoLoginPage();
        Page首页 mainPage2 = loginPage.gotoMainPage(username, password);
        Page我的 page我的 = mainPage2.gotoMinePage();
    }
}
