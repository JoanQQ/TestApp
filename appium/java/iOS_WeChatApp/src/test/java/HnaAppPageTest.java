import org.junit.jupiter.api.*;
import pages.DefaultPage;
import pages.DiscoverPage;
import pages.HnaAppPage;
import pages.WeChatAppPage;
import utils.SingleDriver;

import static org.hamcrest.CoreMatchers.equalTo;

/**
 * @author Phyllis
 * @date 2019-09-05 10:37
 */
@TestMethodOrder (MethodOrderer.OrderAnnotation.class)
public class HnaAppPageTest {
    HnaAppPage hnaAppPage = new HnaAppPage ();

    @BeforeAll
    @DisplayName("启动Android设备上的微信应用")
    public static void testStartBrowser(){
        SingleDriver.getInstance ();
    }

    @Test
    @Order(1)
    @DisplayName ("testGotoHnaWeChatAppPage: 在微信中打开'发现'页")
    public void testGotoHnaWeChatAppPage(){
        DefaultPage defaultPage = new DefaultPage ();
        DiscoverPage discoverPage = defaultPage.gotoDiscoverPage ();
        WeChatAppPage weChatAppPage = discoverPage.gotoWeChatAppPage ();
        hnaAppPage = weChatAppPage.gotoHnaAppPage ();
        assertThat(hnaAppPage.getPageTitle (),equalTo("海南航空"));
        assertThat(hnaAppPage.getClassificationName (),equalTo ("行程服务"));
    }

    @Test
    @Order(2)
    @DisplayName ("testGotoAllFunctionPages: 在'海南航空'微信小程序中依次打开所有功能页且返回")
    public void testGotoAllFunctionPages(){
        hnaAppPage.clickToEnterAllFunctionPages ();
    }
}
