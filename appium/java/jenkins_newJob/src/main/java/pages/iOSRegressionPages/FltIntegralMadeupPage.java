package pages.iOSRegressionPages;

import org.openqa.selenium.By;
import utils.BasePage;

/**
 * @author Phyllis
 * @date 2019-11-28 15:51
 */
public class FltIntegralMadeupPage extends BasePage {

    public String getFltIntegralPageTitle() { return this.getNativePageTitle ("积分补登"); }

    public String getMadeupMethodTitle() {
        By byMadeupMethodTitle = By.id ("请选择积分补登方式:");
        return this.getWebElementText (byMadeupMethodTitle);
    }

    public String getMadeupMethodOne() {
        By byMethodOne = By.id ("自动获取行程，一键补登");
        return this.getWebElementText (byMethodOne);
    }

    public String getMadeupMethodTwo() {
        By byMethodTwo = By.id ("在线填写申请");
        return this.getWebElementText (byMethodTwo);
    }

    public String getMadeupMethodThree() {
        By byMethodThree = By.id ("上传乘机凭证");
        return this.getWebElementText (byMethodThree);
    }

    public String getMadeupRecordsEntrance() {
        By byMadeupEntrance = By.id ("我的积分补登记录");
        return this.getWebElementText (byMadeupEntrance);
    }

    public String getMadeupRemidnerTitle() {
        By byMadeupReminderTitle = By.id ("温馨提示:");
        return this.getWebElementText (byMadeupReminderTitle);
    }

    public String getMadeupRemidnerOne() {
        By byMadeupReminderOne = By.id ("1. 正常情况，积分是在行程结束后3天入账。如果超过3天未入账，您可以提交补登申请，进行积分补登；");
        return this.getWebElementText (byMadeupReminderOne);
    }

    public String getMadeupRemidnerSeven() {
        By byPartOne = By.id ("7. 其他更多信息，请查询");
        String strPartOne = this.getWebElementText (byPartOne);
        By byPartTwo = By.id ("积分补登温馨提示");
        String strPartTwo = this.getWebElementText (byPartTwo);
        By byPartThree = By.id ("或致电");
        String strPartThree = this.getWebElementText (byPartThree);
        By byPartFour = By.id ("950717");
        String strPartFour = this.getWebElementText (byPartFour);
        String strReminderSeven = strPartOne+strPartTwo+strPartThree+strPartFour;
        return strReminderSeven;
    }

    public void gotoMadeupMethod(int methodIndex) {
        By byEntrance = By.xpath ("//XCUIElementTypeOther[@name=\"HNA-APP\"]/XCUIElementTypeOther[3]/XCUIElementTypeOther[" + methodIndex + "]");
        this.clickWebElement (byEntrance);
    }

    // 自动获取行程，一键补登
    public void gotoOneBtnMadeupPage() {
        //this.waitForMoreTime ();
        this.gotoMadeupMethod (1);
    }

    public String getOneBtnMadeupPageTitle() {
        this.getWebDriver ();
        return this.getWebPageTitle ();
    }

    public String getNativeText(String strNativeElement) {
        this.getNativeDriver ();
        //By byStartDate = By.xpath ("//XCUIElementTypeOther[@name=\"HNA-APP\"]/XCUIElementTypeOther[3]");
        By byElement = By.id (strNativeElement);
        return this.getWebElementText (byElement);
    }

    public String getStartDateTitle() {
        return this.getNativeText ("出发日期");
    }

    public String getDefaultStartDate() {
        /**
        By byDefaultDate = By.xpath ("//XCUIElementTypeOther[@name="HNA-APP"]/XCUIElementTypeOther[3]");
        String strDefaultDate = this.getWebElementText (byDefaultDate);
        */

        String strMonth = (this.getCurrentMonth ()) + "月";
        String strDay = (this.getCurrentDay () - 3) + "日";
        String strYear = this.getCurrentYear () + "年";
        String strDefaultStartDate = strMonth + " " + strDay + " " + strYear;
        return strDefaultStartDate;
        //String strDefaultStartDate = this.getDefaultStartMonth () + this.getDefaultStartDay () + this.getDefaultStartYear ();
        //return this.getNativeText (strDefaultStartDate);
        //return this.getStartDate ();
    }

    public String getBookingCertTitle() {
        return this.getNativeText ("订座证件号");
    }

    public String getIdCertType() {
        return this.getNativeText ("身份证");
    }

    public String getIdCertNum() {
        return this.getNativeText ("110114198209147763");
    }

    public String getPpCertType() {
        return this.getNativeText ("护照");
    }

    public String getPpCertNum() {
        return this.getNativeText ("P2017080804");
    }

    public String getTaiwanCertType() {
        return this.getNativeText ("大陆居民往来台湾通行证");
    }

    public String getTaiwanCertNum() {
        return this.getNativeText ("TAIWAN0914");
    }

    public String getReEntryPermitType() {
        return this.getNativeText ("回乡证");
    }

    public String getReEntryPermitNum() {
        return this.getNativeText ("HUIXIANG0131");
    }

    public String getReminder() {
        String strPart1 = this.getNativeText ("您的会员档案中仅录入了以上证件，如您使用了其他证件购票，请先至");
        String strPart2 = this.getNativeText ("金鹏卡-会员档案");
        String strPart3 = this.getNativeText ("或致电会员热线");
        String strPart4 = this.getNativeText ("950717");
        String strPart5 = this.getNativeText ("添加该证件后，再来提交补登申请。");
        String strReminder = strPart1 + strPart2 + strPart3 + strPart4 + strPart5;
        return strReminder;
    }

    public void clickToGeMadeupItinerary() {
        By byGetItinerary = By.id ("获取行程");
        this.clickWebElement (byGetItinerary);
    }



    // 在线填写申请
    public void gotoOnlineMadeupPage() {
        this.getNativeDriver ();
        this.gotoMadeupMethod (2);
    }

    // 上传乘机凭证
    public void gotoMadeupByUploadCertPage() {
        this.getNativeDriver ();
        this.gotoMadeupMethod (3);
    }

    // 返回"积分补登"的主页
    public void goBackToMadeupMainPage() {
        this.doSleep ();
        for (int i=0;i<2;i++) {
            this.goBackToLevelOnePage ();
            //System.out.println ("第" + (i+1) + "次点击左上角的返回");
        }
    }
}
