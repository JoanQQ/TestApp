package RegressionTests;

import io.qameta.allure.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import pages.iOSRegressionPages.AdsPage;

/**
 * @author Phyllis
 * @date 2019-05-14 13:46
 */
@Epic ("营销广告")
@Feature ("首次下载客户端的用户启动App后，同意Gdpr相关条款后，即可读取到营销广告")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class C_AdsTest {
    AdsPage adsPage = new AdsPage ();

    @Test
    @Order (1)
    @Story("用户下载客户端后，首次启动APP后，可以看到营销广告/升级广告")
    //@DisplayName ("营销广告")
    @Description("成功滑过营销广告，开始体验APP")
    @Severity (SeverityLevel.NORMAL)
    public void testAds() {
        //SingleDriver.getInstance();
        //GdprPage gdprPage = new GdprPage ();
        //AdsPage adsPage = gdprPage.gotoAdsPage ();
        AdsPage adsPage = new AdsPage ();
        adsPage.gotoMainPage();
    }
}
