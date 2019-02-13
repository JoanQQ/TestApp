import org.junit.After;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import utils.HnaDriver;
import org.junit.BeforeClass;
import org.junit.Test;
import pages.*;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertThat;

@RunWith(Parameterized.class)
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
        /**
        Page广告页 appStart = Page广告页.start();
        PageGdpr pageGdpr = PageGdpr.start();
        HnaDriver.getCurrentDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        */
    }

    @AfterClass
    public static void afterClass() {
        HnaDriver.quit();
    }

    @After
    public void after() {

    }

    @Test
    public void AgreeGdpr() {
        PageGdpr pageGdpr = new PageGdpr();
        //Page授权 page授权 = pageGdpr.gotoAuthPage();
        Page广告页 page广告页 = pageGdpr.gotoAdsPage();
        Page首页 mainPage1 = page广告页.gotoMainPage();
        Page登录 loginPage = mainPage1.gotoLoginPage();
        Page首页 mainPage2 = loginPage.gotoMainPage(username, password);
        Page我的 page我的 = mainPage2.gotoMinePage();
        Page常用邮寄地址 page常用邮寄地址 = page我的.gotoAddressPage();
        page常用邮寄地址.createAddress();
        page常用邮寄地址.verifyRequiredFileds();
    }
}
