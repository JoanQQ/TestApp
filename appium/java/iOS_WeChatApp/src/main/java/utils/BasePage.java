package utils;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Calendar;
import java.util.List;

import static java.lang.Thread.sleep;

/**
 * @author Phyllis
 * @date 2019-07-23 09:42
 */
public class BasePage {
    public static WebElement find(By locator) {
        return SingleDriver.getInstance().findElement(locator);
    }

    static By locate(String locator) {
        if(locator.matches("/.*")) {
            return By.xpath(locator);
        }else {
            return By.id(locator);
        }
    }

    static By text(String content) {
        return By.xpath("//*[@text='"+ content + "']");
    }

    //判断是否有 WEBVIEW
    public static void getWeChatAppDriver() {
        // io.appium.java_client.NoSuchContextException
        try {
            sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace ( );
        }
        SingleDriver.getInstance ().context ("WEBVIEW_com.tencent.mm:tools");
        //String contextName = SingleDriver.getInstance().getContextHandles().toArray ()[1].toString ();
        //SingleDriver.getInstance().context("WEBVIEW_com.tencent.mm:appbrand0");
    }

    public static void getWebDriver() {
        try {
            sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace ( );
        }
        String contextName = SingleDriver.getInstance().getContextHandles().toArray ()[1].toString ();
        SingleDriver.getInstance().context(contextName);
    }

    //判断是否有 NATIVEAPP
    public static void getNativeDriver() {
        try {
            sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace ( );
        }
        String contextName = SingleDriver.getInstance().getContextHandles().toArray ()[0].toString ();
        SingleDriver.getInstance().context(contextName);
    }

    public static void doSleep() {
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace ( );
        }
    }

    public void waitForMoreTime() {
        try {
            sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace ( );
        }
    }

    // 点击页面元素
    public void clickWebElement(By byWebElement) {
        MobileElement waitWebElement = (MobileElement) new WebDriverWait (SingleDriver.getInstance(),15)
                .until(ExpectedConditions.visibilityOfElementLocated(byWebElement));
        find (byWebElement).click();
    }

    // 获取元素内容
    public String getWebElementText(By byWebElement) {
        MobileElement waitWebElement = (MobileElement) new WebDriverWait (SingleDriver.getInstance(),15)
                .until(ExpectedConditions.visibilityOfElementLocated(byWebElement));
        return find (byWebElement).getText ();
    }

    // WeChatApp的WebviewText
    public String getWebviewText(String strViewText) {
        this.doSleep ();
        By byViewText = By.xpath ("//android.view.View[@text='" + strViewText + "']");
        return this.getWebElementText (byViewText);
    }

    public String getkWebElementText(WebElement webElement) {
        return webElement.getText ();
    }

    // 获取Toast内容
    public String getToastMsg() {
        By byToast = By.className ("toastView");
        MobileElement waitToast = (MobileElement) new WebDriverWait (SingleDriver.getInstance(),15)
                .until(ExpectedConditions.visibilityOfElementLocated(byToast));
        return find (byToast).getText ();
    }

    // 获取常用页的列表父节点
    public WebElement getNormalListParent() {
        By byNormalParent = By.className ("iscroll-content");
        MobileElement waitNormalParent = (MobileElement) new WebDriverWait (SingleDriver.getInstance(), 30)
                .until (ExpectedConditions.visibilityOfElementLocated (byNormalParent));
        WebElement normalParent = find (byNormalParent);
        return normalParent;
    }

    public String getNormalPagesToastMsg() {
        By byToast = By.className ("toastView");
        MobileElement waitToast = (MobileElement) new WebDriverWait (SingleDriver.getInstance(), 8)
                .until (ExpectedConditions.visibilityOfElementLocated (byToast));
        String strToastMsg = find (byToast).getText ();
        return strToastMsg;
    }

    public void saveNormalAddBtn() {
        By bySaveNewAddBtn = By.className ("panel-bbtn");
        MobileElement waitNormalAddBtn = (MobileElement) new WebDriverWait (SingleDriver.getInstance ( ), 6)
                .until (ExpectedConditions.visibilityOfElementLocated (bySaveNewAddBtn));
        find (bySaveNewAddBtn).click ();
    }

    public String getNormalSaveToast() {
        this.doSleep ();
        this.saveNormalAddBtn ();
        return this.getNormalPagesToastMsg ();
    }

    public WebElement getReturnIconFromNormalAdd() {
        By byHeaderParent = By.className ("hna-header");
        MobileElement waitReturnIcon = (MobileElement) new WebDriverWait (SingleDriver.getInstance(), 25)
                .until (ExpectedConditions.visibilityOfElementLocated (byHeaderParent));
        WebElement headerParent = find (byHeaderParent);
        //List<WebElement> listHeaderIcons = headerParent.findElements (By.className ("hna-header-btn"));
        List<WebElement> listHeaderIcons = headerParent.findElements (By.className ("hna-icon-size-20"));
        System.out.println ("图标的data-src属性值：" + listHeaderIcons.get (0).getAttribute ("data-src"));
        return listHeaderIcons.get (0);
    }

    public Dimension getWindowSize() {
        return SingleDriver.getInstance().manage().window().getSize ();
    }

    public int getWindowHeight() {
        return this.getWindowSize ().height;
    }

    public int getWindowWidth() {
        return this.getWindowSize ().width;
    }

    public void swipeUp() {
        this.doSleep ();
        int height = this.getWindowHeight ();    // iOS:553    Android:1812
        int width = this.getWindowWidth ();      // iOS:375    Android:1080
        this.doSleep ();
        (new TouchAction (SingleDriver.getInstance())).
                press(PointOption.point(width/2, height-100)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(width/2, 3*height/4+75)).release().perform();    // 10个像素左右可能是1天的位置跨度
    }

    // 滑动一个单位的年、月、日
    public void swipeDownYear() {
        new TouchAction (SingleDriver.getInstance())
                .longPress(PointOption.point(180, 1497))
                .moveTo(PointOption.point(180, 1593)).release().perform();
    }

    public void swipeUpMonth() {
        new TouchAction (SingleDriver.getInstance())
                .longPress(PointOption.point(538, 1593))
                .moveTo(PointOption.point(538, 1497)).release().perform();
    }

    public void swipeUpDay() {
        new TouchAction (SingleDriver.getInstance())
                .longPress(PointOption.point(900, 1593))
                .moveTo(PointOption.point(900, 1497)).release().perform();
    }

    public void swipeUpFltDate() {
        new TouchAction (SingleDriver.getInstance())
                .longPress(PointOption.point(540, 1720))                   // Selected:[279,1380][801,1524]
                .moveTo(PointOption.point(540, 1605)).release().perform(); // Bottom:[279,1524][801,1722]
    }

    public void swipeDown() {
        int height = this.getWindowHeight ();
        int width = this.getWindowWidth ();
        new TouchAction(SingleDriver.getInstance())
                .longPress(PointOption.point(width/2, 100))
                .moveTo(PointOption.point(width/2, height-100)).release().perform();
    }

    public void swipeDownDay() {
        // Selected Day: [720,1443][1080,1548]   Previous: [720,1341][1080,1446]
        new TouchAction(SingleDriver.getInstance())
                .longPress(PointOption.point(900, 1448))
                .moveTo(PointOption.point(900, 1546)).release().perform();
    }

    public void swipeLeft() {
        int height = this.getWindowHeight ();
        int width = this.getWindowWidth ();
        new TouchAction(SingleDriver.getInstance())
                .longPress(PointOption.point(width - 100, height / 2))
                .moveTo(PointOption.point(100, height / 2)).release().perform();
    }

    public void swipeRight() {
        int height = this.getWindowHeight ();
        int width = this.getWindowWidth ();
        new TouchAction(SingleDriver.getInstance())
                .longPress(PointOption.point(width - 100, height / 2))
                .moveTo(PointOption.point(100, height / 2)).release().perform();
    }

    public void goBackToPreviousPage() {
        this.doSleep ();
        By byBackBtn = By.id ("com.tencent.mm:id/p8");
        MobileElement waitReturnIcon = (MobileElement) new WebDriverWait (SingleDriver.getInstance(), 25)
                .until (ExpectedConditions.visibilityOfElementLocated (byBackBtn));
        find (byBackBtn).click ();
    }

    public WebElement getClickableView(int viewIndex) {
        By byViewParent = By.xpath ("//android.webkit.WebView[@text='海南航空']");
        List<WebElement> viewList = find (byViewParent).findElements (By.xpath ("//android.view.View"));
        //System.out.println ("Views List Size: " + viewList.size ());
        return viewList.get (viewIndex);
    }

    public WebElement getQueryBtn() {
        By byQueryBtn = By.xpath ("//android.widget.Button[@text='获取行程']");
        return find (byQueryBtn);
    }

    // 获取运行当天的年、月、日
    public Calendar getCurrentCalendar() {
        return Calendar.getInstance ();
    }

    public int getCurrentYear() {
        int strYear = this.getCurrentCalendar ().get(Calendar.YEAR);
        return strYear;
    }

    public int getCurrentMonth() {
        int strMonth = this.getCurrentCalendar ().get(Calendar.MONTH);
        return (strMonth+1);
    }

    public int getCurrentDay() {
        int strDay = this.getCurrentCalendar ().get(Calendar.DAY_OF_MONTH);
        return strDay;
    }

    public String getCurrentWeekDay() {
        String[] weekDays = {"星期日","星期一","星期二","星期三","星期四","星期五","星期六"};
        int weekDayIndex = this.getCurrentCalendar ().get(Calendar.DAY_OF_WEEK) -1;
        if (weekDayIndex < 0) { weekDayIndex = 0; }
        return weekDays[weekDayIndex];
    }

    public String getTheNextWeekDay() {
        String[] weekDays = {"星期日","星期一","星期二","星期三","星期四","星期五","星期六"};
        int weekDayIndex = this.getCurrentCalendar ().get(Calendar.DAY_OF_WEEK) -1;
        if (weekDayIndex < 0) { weekDayIndex = 0; }
        return weekDays[weekDayIndex+1];
    }

    public String getFltDate() {
        int currentYear = this.getCurrentYear ();
        int currentMonth = this.getCurrentMonth ();
        int currentDay = this.getCurrentDay ();
        String strXpath = currentMonth + "月 " + currentDay + "日 " + currentYear + "年";
        return this.getWebviewText (strXpath);
    }
}
