package pages.Mine;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Common.BasePage;
import utils.SingleDriver;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

/**
 * @author Phyllis
 * @date 2019-02-19 09:38
 */
public class PassengerPage extends BasePage {
    public static PassengerPage addressPage() { return new PassengerPage (); }
    private By normalPassenger = By.xpath("//android.view.View[@text='常用乘机人']");
    private By addPassenger = By.xpath("//android.view.View[@text='新增乘机人']");
    private By savePassenger = By.xpath("//android.view.View[@text='保存']");
    private By editId = By.xpath("//android.widget.EditText[@text='请输入证件号码']");
    private By editLastnamecn = By.xpath("//android.widget.EditText[@bounds='[490,784][1029,834]']");
    private By editFirstnamecn = By.xpath("//android.widget.EditText[@bounds='[490,916][1029,966]']");
    private By editFfpnumber = By.xpath("//android.widget.EditText[@text='方便乘机积分及时入账']");
    private By edit1 = By.xpath("//android.widget.EditText[@text='请输入']");
    private By delIcon = By.xpath ("//android.widget.Image[@resource-id='图层_1']");
    private By delBtn = By.xpath ("//android.view.View[@text='删除']");
    private By delText = By.xpath ("//android.view.View[@text='确定要删除所选常用乘机人吗？']");
    private By cancelDelBtn = By.xpath ("//android.view.View[@text='取消']");
    private By confirmDelBtn = By.xpath ("//android.view.View[@text='确定']");
    private By successfulNewAddress = By.xpath("//android.view.View[@text='新增成功']");
    private By successfulDeletion = By.xpath ("//android.view.View[@text='删除成功！']");
    private By noneId = By.xpath("//android.view.View[@text='请输入身份证号']");
    private By noneLast = By.xpath("//android.view.View[@text='请输入中文姓']");
    private By noneFirst = By.xpath("//android.view.View[@text='请输入中文名']");

    public void addPassenger() {
        SingleDriver.getInstance().manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        find(normalPassenger).click();
        (new TouchAction(SingleDriver.getInstance()))
                .press(PointOption.point(506, 1700)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(506, 1092)).release().perform();
        find(addPassenger).click();
        SingleDriver.getInstance().manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        System.out.println("新建邮寄地址测试开始");
        find(editId).sendKeys("110114198209149662");
        find(editLastnamecn).sendKeys("新增");
        find(editFirstnamecn).sendKeys("乘机人测试");
        MobileElement waitDelContact = (MobileElement) new WebDriverWait(SingleDriver.getInstance(),3)
                .until(ExpectedConditions.visibilityOfElementLocated(savePassenger));
        find(savePassenger).click();
        MobileElement waitAddedToast4 = (MobileElement) new WebDriverWait(SingleDriver.getInstance(),8)
                .until(ExpectedConditions.visibilityOfElementLocated(successfulNewAddress));
        String toastAdded = find(successfulNewAddress).getAttribute("text");
        if (toastAdded.equals("新增成功"))
            System.out.println("新增乘机人验证通过");
    }

    public void delPassenger() {
        MobileElement waitDelContact = (MobileElement) new WebDriverWait(SingleDriver.getInstance(),15)
                .until(ExpectedConditions.visibilityOfElementLocated(delIcon));
        find(delIcon).click();
        SingleDriver.getInstance().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        MobileElement waitDelBtn = (MobileElement) new WebDriverWait(SingleDriver.getInstance(),5)
                .until(ExpectedConditions.visibilityOfElementLocated(delBtn));
        (new TouchAction (SingleDriver.getInstance ())).tap(PointOption.point (105, 305)).perform ();
        find(delBtn).click();
        MobileElement waitDelText1 = (MobileElement) new WebDriverWait(SingleDriver.getInstance(),3)
                .until(ExpectedConditions.visibilityOfElementLocated(delText));
        find(cancelDelBtn).click ();
        find(delBtn).click();
        MobileElement waitDelText2 = (MobileElement) new WebDriverWait(SingleDriver.getInstance(),3)
                .until(ExpectedConditions.visibilityOfElementLocated(delText));
        find(confirmDelBtn).click ();
        MobileElement waitDelToast = (MobileElement) new WebDriverWait(SingleDriver.getInstance(),5)
                .until(ExpectedConditions.visibilityOfElementLocated(successfulDeletion));
        String taostDeleted = find(successfulDeletion).getAttribute ("text");
        if (taostDeleted.equals ("删除成功！"))
            System.out.println ("删除联系人验证通过");
    }

    public void verifyRequiredFileds () {
        //SingleDriver.getInstance().manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        MobileElement waitNewAddress = (MobileElement) new WebDriverWait(SingleDriver.getInstance(),12)
                .until(ExpectedConditions.visibilityOfElementLocated(savePassenger));
        find(savePassenger).click();
        MobileElement waitNameToast = (MobileElement) new WebDriverWait(SingleDriver.getInstance(),2)
                .until(ExpectedConditions.visibilityOfElementLocated(noneId));
        String toastName = find(noneId).getAttribute("text");
        if (toastName.equals("请输入身份证号"))
            System.out.println("身份证号不能为空验证通过");

        find(editId).sendKeys("110114198209149662");
        find(savePassenger).click();
        MobileElement waitMobileToast1 = (MobileElement) new WebDriverWait(SingleDriver.getInstance(),3)
                .until(ExpectedConditions.visibilityOfElementLocated(noneLast));
        String toastMobile1 = find(noneLast).getAttribute("text");
        if (toastMobile1.equals("请输入中文姓"))
            System.out.println("中文姓不能为空验证通过");
        find(editLastnamecn).sendKeys("新增");
        find(savePassenger).click();
        MobileElement waitMobileToast2 = (MobileElement) new WebDriverWait(SingleDriver.getInstance(),3)
                .until(ExpectedConditions.visibilityOfElementLocated(noneFirst));
        String toastMobile2 = find(noneFirst).getAttribute("text");
        if (toastMobile2.equals("请输入中文名"))
            System.out.println("中文名不能为空验证通过");

        find(editFirstnamecn).sendKeys("乘机人测试");
        find(savePassenger).click();
        MobileElement waitAddedToast = (MobileElement) new WebDriverWait(SingleDriver.getInstance(),5)
                .until(ExpectedConditions.visibilityOfElementLocated(successfulNewAddress));
        String toastAdded = find(successfulNewAddress).getAttribute("text");
        if (toastAdded.equals("新增成功"))
            System.out.println("编辑乘机人验证通过");
    }

    public MinePage backtoSettingPage() {
        MobileElement waitAddedToast = (MobileElement) new WebDriverWait(SingleDriver.getInstance(),5)
                .until(ExpectedConditions.visibilityOfElementLocated(normalPassenger));
        (new TouchAction (SingleDriver.getInstance ())).tap(PointOption.point (70, 160)).perform ();
        return new MinePage ();
    }
}
