package RegressionTests;

import io.qameta.allure.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import pages.iOSRegressionPages.GdprPage;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@Epic ("Gdpr功能回归")
@Feature ("首次下载客户端的用户启动App后，同意Gdpr相关条款后，方可使用APP")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class B_GdprTest {
    GdprPage gdprPage = new GdprPage ();

    @Test
    @Order (1)
    @Story ("用户打开App，通过Logo页后，看到Gdpr页")
    //@DisplayName ("启动App，打开Gdpr页")
    @Description("成功打开App，并成功加载Gdpr页: 页面标题是'海南航空APP使用须知'")
    @Severity (SeverityLevel.CRITICAL)
    public void testAccessGdpr() {
        //SingleDriver.getInstance();
        assertThat(gdprPage.getGdprTitle (), equalTo("海南航空APP使用须知"));
        //gdprPage.gotoAdsPage();
        //pageGdpr.gotoAuthPage();
    }

    @Test
    @Order (2)
    @Story ("用户可以在Gdrp页访问'隐私条款'")
    //@DisplayName ("访问'隐私条款'")
    @Description("成功打开'隐私条款'")
    @Severity (SeverityLevel.NORMAL)
    public void testGotoPrivacy() {
        gdprPage.gotoPrivacyPage ();
        gdprPage.closePrivacyOrCookie ();
    }

    @Test
    @Order (3)
    @Story ("用户可以在Gdrp页访问'Cookie政策'")
    //@DisplayName ("访问'Cookie政策'")
    @Description("成功打开'Cookie政策'")
    @Severity (SeverityLevel.NORMAL)
    public void testGotoCookie() {
        gdprPage.gotoCookiePage ();
        gdprPage.closePrivacyOrCookie ();
    }

    @Test
    @Order (4)
    @Story ("用户同意Gdpr条款后，方可继续使用App")
    //@DisplayName ("同意Gdpr条款，并继续使用App")
    @Description("同意Gdpr相关内容，可以继续使用App")
    @Severity (SeverityLevel.CRITICAL)
    public void testAgreeGdpr() {
        gdprPage.gotoAdsPage ();
    }
}
