package RegressionTests;

import io.qameta.allure.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import pages.iOSRegressionPages.MainPage;

/**
 * @author Phyllis
 * @date 2019-05-20 16:54
 */
@Epic("首页")
@Feature("打开APP后，默认进入\"首页\"")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class D_MainpageTest {
    @Test
    @Story("用户默认看到的是\"首页\"")
    //@DisplayName ("营销广告")
    @Description("成功滑过营销广告，打开APP首页")
    @Severity (SeverityLevel.NORMAL)
    public void testMain() {
        //SingleDriver.getInstance();
        MainPage mainPage = new MainPage ();
        mainPage.cancelUpgrade ();
        //mainPage.gotoMinePage();
        //mainPage.gotoFfpPageWithLogin ();
        mainPage.gotoFfpPageWithouLogin ();
        //System.out.println("访问海南航空App首页");
    }
}
