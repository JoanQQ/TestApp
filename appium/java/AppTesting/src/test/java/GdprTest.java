import utils.HnaDriver;
import org.junit.Before;
import org.junit.Test;
import pages.*;

import java.util.concurrent.TimeUnit;
//import pages.Page广告页;
//import javax.xml.ws.handler.LogicalHandler;

public class GdprTest {
    @Before
    public void appStart() {
        Page广告页 appStart = Page广告页.start();
    }

    @Test
    public void AgreeGdpr() {
        HnaDriver.getCurrentDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        PageGdpr pageGdpr = new PageGdpr();
        Page首页 mainPage1 = pageGdpr.gotoMainPage();
        Page登录 loginPage = mainPage1.gotoLoginPage();
        Page首页 mainPage2 = loginPage.gotoMainPage("7050812098","121321");
        HnaDriver.getCurrentDriver().manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        Page常用邮寄地址 addressPage = mainPage2.gotoMinePage().gotoAddressPage();
    }
}
