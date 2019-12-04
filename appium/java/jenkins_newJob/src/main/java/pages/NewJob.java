package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BasePage;
import utils.SingleDriver;
import java.util.List;

/**
 * @author Phyllis
 * @date 2019-10-15 11:13
 */
public class NewJob extends BasePage {
    public static NewJob newJob() {return new NewJob(); }

    public void remindToOpenWechatSuccessfully() {
        System.out.println ("User has arrived HNA app successfully");
    }

    public WebElement getWeChatTab(int tabIndex) {
        this.doSleep ();
        List<WebElement> tabsList = SingleDriver.getInstance().findElements(By.id ("com.tencent.mm:id/dkb"));    // Old value: com.tencent.mm:id/ddk
        return tabsList.get (tabIndex);
    }

    public void gotoDiscoverPage() {
        this.getWeChatTab (2).click ();
    }

    public void gotoWechatAppPage() {
        this.doSleep ();
        List<WebElement> rowsList = SingleDriver.getInstance().findElements(By.id("com.tencent.mm:id/ma"));    // Old value: com.tencent.mm:id/ded
        rowsList.get (8).click ();
    }

    public void gotoHnaAppPage() {
        this.doSleep ();
        List<WebElement> recentAppsList = SingleDriver.getInstance().findElements(By.id("com.tencent.mm:id/s6"));    // Old value: com.tencent.mm:id/rc
        recentAppsList.get (1).click ();
    }

    public void gotoFunctionalPage(int functionIndex) {
        this.waitForMoreTime ();
        String strPath = "//android.webkit.WebView/android.view.View/android.view.View[" + functionIndex + "]";
        By byFunctionBlockEntrance = By.xpath (strPath);
        this.clickWebElement (byFunctionBlockEntrance);
    }
}
