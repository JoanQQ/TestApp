package RegressionTests;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import pages.iOSRegressionPages.LoginPage;
import pages.iOSRegressionPages.FfpPage;
import pages.iOSRegressionPages.FltIntegralMadeupPage;
import utils.SingleDriver;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author Phyllis
 * @date 2019-11-28 16:21
 */
@Epic("金鹏卡")
@Feature("金鹏卡 - 积分补登")
@TestMethodOrder (MethodOrderer.OrderAnnotation.class)
public class E_FltIntegralMadeupTest {
    FltIntegralMadeupPage fltIntegralMadeupPage = new FltIntegralMadeupPage ();

    @Test
    @Order(1)
    @Story("去访问\"金鹏卡 - 积分补登\"")
    @Severity(SeverityLevel.NORMAL)
    @Description("从\"金鹏卡\"的一级页面访问\"积分补登\"")
    @DisplayName("testGotoMemProfile： 积分补登入口校验")
    public void testGotoFltIntegralMadeup() {
        SingleDriver.getInstance();
        /**
        GdprPage gdprPage = new GdprPage ();
        AdsPage adsPage = gdprPage.gotoAdsPage ();
        MainPage mainPage = adsPage.gotoMainPage ();
        */
        //MainPage mainPage = new MainPage ();

        //LoginPage loginPage =mainPage.gotoFfpPageWithouLogin ();
        LoginPage loginPage = new LoginPage ();
        FfpPage ffpPage = loginPage.gotoFfpPage ("7050812098","121123");
        ffpPage.waitForMoreTime ();

        //FfpPage ffpPage = mainPage.gotoFfpPageWithLogin ();
        ffpPage.swipeUp ();
        //FfpPage ffpPage = new FfpPage ();
        fltIntegralMadeupPage = ffpPage.gotoFltIntegralMadeup ();
    }

    @Test
    @Order (2)
    @Story ("验证\"积分补登\"页的静态信息")
    @Description("验证\"积分补登\"页以下静态信息：页面标题、积分补登方式、补登记录入口文字、温馨提示")
    @Severity (SeverityLevel.NORMAL)
    @DisplayName ("testFltIntegralStaticInfo：验证\"积分补登\"页面的静态信息")
    public void testFltIntegralStaticInfo() {
        this.verifyPageTitle ();
        this.verifyMadeupMethodsTitle();
        this.verifyMadeupRecordEntrance();
        this.verifyWarmPrompt();
    }

    @Step("页面标题:积分补登")
    public void verifyPageTitle() {
        assertThat(fltIntegralMadeupPage.getFltIntegralPageTitle (),equalTo("积分补登"));
    }

    @Step("积分补登方式：自动获取行程，一键补登；在线填写申请；上传乘机凭证")
    public void verifyMadeupMethodsTitle() {
        assertThat (fltIntegralMadeupPage.getMadeupMethodTitle (),equalTo ("请选择积分补登方式:"));
        assertThat (fltIntegralMadeupPage.getMadeupMethodOne (),equalTo ("自动获取行程，一键补登"));
        assertThat (fltIntegralMadeupPage.getMadeupMethodTwo (),equalTo ("在线填写申请"));
        assertThat (fltIntegralMadeupPage.getMadeupMethodThree (),equalTo ("上传乘机凭证"));
    }

    @Step("我的积分补登记录:入口校验")
    public void verifyMadeupRecordEntrance() {
        assertThat (fltIntegralMadeupPage.getMadeupRecordsEntrance (),equalTo ("我的积分补登记录"));
    }

    @Step("温馨提示:只比对第1,7条")
    public void verifyWarmPrompt() {
        assertThat (fltIntegralMadeupPage.getMadeupRemidnerTitle (),equalTo ("温馨提示:"));
        assertThat (fltIntegralMadeupPage.getMadeupRemidnerOne (),equalTo ("1. 正常情况，积分是在行程结束后3天入账。如果超过3天未入账，您可以提交补登申请，进行积分补登；"));
        assertThat (fltIntegralMadeupPage.getMadeupRemidnerSeven (),equalTo ("7. 其他更多信息，请查询积分补登温馨提示或致电950717"));
    }

    @Test
    @Order (3)
    @Story ("验证\"积分补登\"页的第一种补登方式")
    @Severity (SeverityLevel.NORMAL)
    @Description("验证\"积分补登 --- 自动获取行程，一键补登\"")
    @DisplayName ("testOneBtnMadeup：验证\"一键补登\"页面的静态信息")
    public void testOneBtnMadeup() {
        this.verifyOneBtnMadeupTitle ();
        this.verifyStartDateArea();
        this.verifyBookingCertsArea();
        this.verifyReminder();
        /**
        this.verifyOneBtnMadeupInstruction();
        this.verifyItineraryById();
        this.verifyItineraryByPp();
        this.verifyItineraryByTaiwanCert();
        this.verifyItineraryByRetireCert();
        */
        this.goBack ();
    }

    @Step("一键补登页面标题:积分补登")
    public void verifyOneBtnMadeupTitle() {
        fltIntegralMadeupPage.gotoOneBtnMadeupPage();
        assertThat (fltIntegralMadeupPage.getOneBtnMadeupPageTitle (),equalTo ("积分补登"));
    }

    @Step("出发日期:抬头,默认显示日期")
    public void verifyStartDateArea() {
        assertThat (fltIntegralMadeupPage.getStartDateTitle (),equalTo ("出发日期"));
        assertThat (fltIntegralMadeupPage.getDefaultStartDate (),equalTo ("12月 1日 2019年"));
    }

    @Step("订座证件号:抬头,身份证,护照,大陆居民往来台湾通行证")
    public void verifyBookingCertsArea() {
        assertThat (fltIntegralMadeupPage.getBookingCertTitle (),equalTo ("订座证件号"));
        assertThat (fltIntegralMadeupPage.getIdCertType (),equalTo ("身份证"));
        assertThat (fltIntegralMadeupPage.getIdCertNum (),equalTo ("110114198209147763"));
        assertThat (fltIntegralMadeupPage.getPpCertType (),equalTo ("护照"));
        assertThat (fltIntegralMadeupPage.getPpCertNum (),equalTo ("P2017080804"));
        assertThat (fltIntegralMadeupPage.getTaiwanCertType (),equalTo ("大陆居民往来台湾通行证"));
        assertThat (fltIntegralMadeupPage.getTaiwanCertNum (),equalTo ("TAIWAN0914"));
        assertThat (fltIntegralMadeupPage.getReEntryPermitType (),equalTo ("回乡证"));
        assertThat (fltIntegralMadeupPage.getReEntryPermitNum (),equalTo ("HUIXIANG0131"));
    }

    @Step("提示信息:您的会员档案中仅录入了以上证件,如您使用了其他证件购票,请先至......")
    public void verifyReminder() {
        assertThat (fltIntegralMadeupPage.getReminder (),equalTo ("您的会员档案中仅录入了以上证件，如您使用了其他证件购票，请先至金鹏卡-会员档案或致电会员热线950717添加该证件后，再来提交补登申请。"));
    }

    @Step("")
    public void verifyOneBtnMadeupInstruction() {}

    @Step("按身份证获取补登行程:")
    public void verifyItineraryById() {}

    @Step("按护照获取补登行程:")
    public void verifyItineraryByPp() {}

    @Step("按大陆居民往来台湾通行证获取补登行程:")
    public void verifyItineraryByTaiwanCert() {}

    @Step("按回乡证获取补登行程:")
    public void verifyItineraryByRetireCert() {}

    @Step("返回积分补登一级页面")
    public void goBack() {fltIntegralMadeupPage.goBackToMadeupMainPage ();}


    @Test
    @Order (4)
    @Story ("验证\"积分补登\"页的第二种补登方式")
    @Description("验证\"积分补登 --- 在线填写行程\"")
    @Severity (SeverityLevel.NORMAL)
    @DisplayName ("testOnlineApply：验证\"在线填写-积分补登\"页面的静态信息")
    public void testOnlineApply() {
        this.verifyOnlineMadeupTitle ();
        //fltIntegralMadeupPage.goBackToMadeupMainPage ();
        this.goBackFromOnline ();
    }

    @Step("在线填写补登行程页面标题:积分补登")
    public void verifyOnlineMadeupTitle() {
        fltIntegralMadeupPage.gotoOnlineMadeupPage ();
        assertThat (fltIntegralMadeupPage.getWebPageTitle (),equalTo ("积分补登"));
    }

    @Step("返回积分补登一级页面")
    public void goBackFromOnline() {fltIntegralMadeupPage.goBackToMadeupMainPage ();}

    @Test
    @Order (5)
    @Story ("验证\"积分补登\"页的第三种补登方式")
    @Description("验证\"积分补登 --- 上传乘机凭证\"")
    @Severity (SeverityLevel.NORMAL)
    @DisplayName ("testFlyCertUpload：验证\"上传乘机凭证-积分补登\"页面的静态信息")
    public void testFlyCertUpload() {
        this.verifyUploadCertPageTitle ();
        this.goBackFromUpload();
    }

    @Step("上传乘机凭证页面标题:积分补登")
    public void verifyUploadCertPageTitle() {
        fltIntegralMadeupPage.gotoMadeupByUploadCertPage ();
        assertThat (fltIntegralMadeupPage.getWebPageTitle (),equalTo ("积分补登"));
        fltIntegralMadeupPage.goBackToMadeupMainPage ();
    }

    @Step("返回积分补登一级页面")
    public void goBackFromUpload() {fltIntegralMadeupPage.goBackToMadeupMainPage ();}
}
