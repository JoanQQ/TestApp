package RegressionTests;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import utils.SingleDriver;

/**
 * @author Phyllis
 * @date 2019-12-04 15:03
 */

@Owner("Phyllis Zhao")
@TestMethodOrder(MethodOrderer.class)
public class ReportWithStepTest {
    pages.NewJob newJob = new pages.NewJob ();

    /**
     @Story ("Story : testOpenNewJob,从微信打开海航App小程序")
     @Step ("打开微信，点击 发现-小程序")
     */
    @Test
    @Order(1)
    @DisplayName("Allure描述：testOpenNewJob")
    @Story("Allure注释描述：从微信打开海航App小程序")
    @Severity(SeverityLevel.BLOCKER)
    @Description("用例描述：打开HnaApp")
    public void testOpenNewJob() {
        this.initWechatApp ();
        //System.out.println ("Open HNA Wechat App successfully");
        //newJob.remindToOpenWechatSuccessfully ();
        this.gotoDiscoverPage ();
        this.gotoWechatAppPage ();
        this.gotoHnaAppPage ();
    }

    @Step("初始化微信小程序")
    public void initWechatApp() { SingleDriver.getInstance (); }

    @Step("去往\"发现\"")
    public void gotoDiscoverPage() { newJob.gotoDiscoverPage (); }

    @Step("去往\"微信小程序\"")
    public void gotoWechatAppPage() { newJob.gotoWechatAppPage (); }

    @Step("去往\"海南航空App\"")
    public void gotoHnaAppPage() { newJob.gotoHnaAppPage (); }

    @Test
    @Order (2)
    @DisplayName ("Allure描述：testOpenTwo")
    @Story ("Allure注释描述：打开功能页")
    @Severity (SeverityLevel.CRITICAL)
    @Description ("用例描述：打开App小程序的功能页")
    public void testOpenNewJobTwo() {
        this.swipeUp ();
        this.gotoFltService ();
        //SingleDriver.quit ();
    }

    @Step("向上滑动屏幕，以显示功能菜单")
    public void swipeUp() { newJob.swipeUp (); }

    @Step("访问功能页")
    public void gotoFltService() { newJob.gotoFunctionalPage (3); }
}
