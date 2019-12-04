package pages.iOSRegressionPages;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BasePage;
import utils.SingleDriver;
import java.util.List;

/**
 * @author Phyllis
 * @date 2019-08-05 10:59
 */
public class FfpPage extends BasePage {

    public LoginPage gotoLoginPage() {
        By login = By.id ("登录/注册");
        find(login).click ();
        return new LoginPage();
    }

    // 获取金鹏卡基本信息

    public String getBasicInfo(By byFfpInfo) {
        MobileElement waitFfpElement = (MobileElement) new WebDriverWait (SingleDriver.getInstance(),15)
                .until(ExpectedConditions.visibilityOfElementLocated(byFfpInfo));
        return find (byFfpInfo).getText ();
    }

    public String getFfpName() {
        By byName = By.id ("LIQIONGTEST ZHAOTEST");
        return this.getBasicInfo (byName);
    }

    public String getFfpCardNum() {
        By byCardNum = By.id ("7050 8120 98");
        return this.getBasicInfo (byCardNum);
    }

    public String getFfpLevel() {
        By byLevel = By.id ("金卡");
        return this.getBasicInfo (byLevel);
    }

    public String getFfpExpirationDate() {
        By byExpirationDate = By.id ("有效期至 2019.12.13");
        return this.getBasicInfo (byExpirationDate);
    }

    // 第一部分：消费积分信息
    public String getConsumptionTitle() {
        By byConsumptionTitle = By.id ("消费积分:");
        return this.getBasicInfo (byConsumptionTitle);
    }

    public String getConsumptionPoints() {
        By byConsumptionPoints = By.id ("90180");    // 90180
        return this.getBasicInfo (byConsumptionPoints);
    }

    public String getConsumptionExpiratin() {
        By byConsumptionExpiration = By.id ("过期日：2021.9.26");    // 2021.4.24
        return this.getBasicInfo (byConsumptionExpiration);
    }

    // 第二部分：积分透支信息
    public String getOverdraftOpenTitle() {
        By byOverdraftOpenTitle = By.id ("开启积分透支");
        return this.getBasicInfo(byOverdraftOpenTitle);
    }

    public String getOverdraftSwitchStatus() {
        By byOverdraftSwitchStatus = By.xpath ("//*/XCUIElementTypeTable/XCUIElementTypeCell[3]/XCUIElementTypeButton");
        String isOpenOverdraft = find (byOverdraftSwitchStatus).getAttribute ("enabled");
        return isOpenOverdraft;
    }

    public String getOverdraftBalanceTitle() {
        By byOverdraftBalanceTitle = By.id ("透支余额：");
        return this.getBasicInfo (byOverdraftBalanceTitle);
    }

    public String getOverdraftBalance() {
        By byOverdraftBalance = By.id ("10000");
        return this.getBasicInfo (byOverdraftBalance);
    }

    // 第三部分：升级进度信息
    public String getFfpLevelTitle() {
        By byFfpLevelTitle = By.id ("会员等级");
        List<WebElement> ffpLevelTitleList = SingleDriver.getInstance ().findElements (byFfpLevelTitle);
        WebElement ffpLevelTitle = ffpLevelTitleList.get (0);
        return ffpLevelTitle.getText ();
        /**
         * List<MobileElement> els1 = (MobileElement) driver.findElementsById("会员等级");
         * List<MobileElement> els2 = (MobileElement) driver.findElementsByXPath("//XCUIElementTypeStaticText[@name=\"会员等级\"]");
        */
        //By byLevelTitle = By.xpath ("//XCUIElementTypeStaticText[@name='会员等级']");
        //By byFfpLevelTitle = By.xpath ("//XCUIElementTypeApplication[@name='7.4.0Nightly']/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[4]//XCUIElementTypeStaticText[@name='会员等级']");
    }

    public WebElement getLevelGuideIcon() {
        By byLevelGuideIcon = By.id ("icon Info blueline");
        return find (byLevelGuideIcon);
    }

    public String getLevelUpgradeAndStayPageTitle() {
        this.getLevelGuideIcon ().click ();
        By byLevelUpgradeAndStayPageTitle = By.xpath ("//XCUIElementTypeOther[@name='升保级说明']");
        return this.getBasicInfo (byLevelUpgradeAndStayPageTitle);
    }

    public WebElement getGoBackToFfpPageIconFromHybird() {
        By byGoBackToFfpPageIcon = By.id ("arrow back Nav");
        return find (byGoBackToFfpPageIcon);
    }

    public String getLevelUpgradeInfo() {
        By byLevelUpgradeInfo = By.id ("升级还需100000.0定级积分/80.0定级航段");
        return this.getBasicInfo (byLevelUpgradeInfo);
    }

    public String getLevelStayInfo() {
        By byLevelStayInfo = By.id ("保级还需50000.0定级积分/40.0定级航段");
        return this.getBasicInfo (byLevelStayInfo);
    }

    // 第四部分：金鹏卡入口页面
    public WebElement getGoBackToFfpPageIconFromNative() {
        By byReturnFromNative = By.xpath ("//XCUIElementTypeNavigationBar[@name='机票预订']/XCUIElementTypeButton[1]");
        MobileElement waitFfpElement = (MobileElement) new WebDriverWait (SingleDriver.getInstance(),15)
                .until(ExpectedConditions.visibilityOfElementLocated(byReturnFromNative));
        return find (byReturnFromNative);
    }

    public WebElement getGoBackToFfpPageIconFromWeb() {
        this.doSleep ();
        this.getWebDriver ();
        By byHeaderParent = By.className ("hna-header");
        MobileElement waitHeaderParent = (MobileElement) new WebDriverWait (SingleDriver.getInstance(),25)
                .until(ExpectedConditions.visibilityOfElementLocated(byHeaderParent));
        List<WebElement> headerBtnsList= find (byHeaderParent).findElements (By.className ("hna-header-btn"));

        return headerBtnsList.get (0);
    }

    public WebElement getFunctionalEntrance(By byFunctionalEntrance) {
        MobileElement waitFfpElement = (MobileElement) new WebDriverWait (SingleDriver.getInstance(),25)
                .until(ExpectedConditions.visibilityOfElementLocated(byFunctionalEntrance));
        return find (byFunctionalEntrance);
    }

    public void gotoTicketExchangePage() {
        this.waitForMoreTime ();
        this.swipeUp ();
        By byTicketExchangeEntrance = By.id ("积分换机票");
        this.getFunctionalEntrance (byTicketExchangeEntrance).click ();
    }

    public void gotoFlightRecords() {
        By byFlightRecords = By.id ("飞行记录");
        this.getFunctionalEntrance (byFlightRecords).click ();
    }

    public void gotoPointsBill() {
        this.waitForMoreTime ();
        this.swipeUp ();
        //this.getNativeDriver ();
        By byPointsBill = By.id ("积分账单");
        this.getFunctionalEntrance (byPointsBill).click ();
    }

    public void gotoMemberHandbook() {
        this.getNativeDriver ();
        By byMemHandbook = By.id ("会员手册");
        this.getFunctionalEntrance (byMemHandbook).click ();
    }

    public void gotoFamilyAccount() {
        this.getNativeDriver ();
        By byFamilyAccount = By.id ("家庭账户");
        this.getFunctionalEntrance (byFamilyAccount).click ();
    }

    public void gotoPointsMall() {
        this.getNativeDriver ();
        this.swipeUp ();
        By byPointsMall = By.id ("积分商城");
        this.getFunctionalEntrance (byPointsMall).click ();
    }

    public void doTktExchange() {

    }

    public void clickToConfirmSearchRange() {
        // 搜索图标的触发由H5实现，需要注意！！！
        this.getWebDriver ();
        System.out.println (SingleDriver.getInstance ().getContext ());
        this.verifyNotFoundInstruction();
        // 搜索日期范围内的积分账单
        this.waitForMoreTime ();
        By bySearchIcon = By.className ("hna-flypoint-icon-refresh");
        for (int i=0; i<2; i++) {
            this.clickWebElement (bySearchIcon);
            System.out.println ("Click to search for the " + (i+1) + " time");
        }
    }

    public void verifyNotFoundInstruction() {
        this.waitForMoreTime ();
        // 查看为查询提示信息
        By byNotFound = By.className ("hna-flypoint-notip");
        //System.out.println ("Not found text: " + this.getWebElementText (byNotFound));
        for (int i=0; i<2; i++) {
            this.clickWebElement (byNotFound);
            System.out.println ("Click not found for the " + (i+1) + " time");
        }
        this.waitForMoreTime ();
        By byCloseNotFound = By.className ("hna-iframe-dlg-title-right");
        this.clickWebElement (byCloseNotFound);
        System.out.println ("Click the close icon for the 1st time");
    }

    public FltIntegralMadeupPage gotoFltIntegralMadeup() {
        //this.getNativeDriver ();
        By byPointsMadeup = By.id ("积分补登");
        this.getFunctionalEntrance (byPointsMadeup).click ();
        return new FltIntegralMadeupPage ();
    }
}
