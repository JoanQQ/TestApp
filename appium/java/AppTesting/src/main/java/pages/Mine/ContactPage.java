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
 * @date 2019-02-19 15:40
 */
public class ContactPage extends BasePage {
    public static ContactPage contactPage() { return new ContactPage (); }
    private By normalContact = By.xpath("//android.view.View[@text='常用联系人']");
    private By addContact = By.xpath("//android.view.View[@text='新增联系人']");
    private By saveContact = By.xpath("//android.view.View[@text='保存']");
    private By editName = By.xpath("//android.widget.EditText[@text='请输入姓名']");
    private By noneName = By.xpath("//android.view.View[@text='请输入姓名']");
    private By noneMobile = By.xpath("//android.widget.EditText[@text='请输入手机号']");
    private By wrongMobile = By.xpath("//android.view.View[@text='抱歉，手机号码需输入11位数字']");
    private By editMobile = By.xpath("//android.widget.EditText[@text='请输入手机号']");
    private By wrongEmail = By.xpath("//android.view.View[@text='Email格式错误']");
    private By editEmail = By.xpath("//android.widget.EditText[@text='请输入Email']");
    private By goCommitt = By.xpath("//android.view.View[@text='正在提交数据...']");
    private By successfulNewAddress = By.xpath("//android.view.View[@text='新增成功']");
    private By delIcon = By.xpath ("//android.widget.Image[@resource-id='图层_1']");
    private By delBtn = By.xpath ("//android.view.View[@text='删除']");
    private By delText = By.xpath ("//android.view.View[@text='确定要删除所选常用联系人吗？']");
    private By cancelDelBtn = By.xpath ("//android.view.View[@text='取消']");
    private By confirmDelBtn = By.xpath ("//android.view.View[@text='确定']");
    private By successfulDeletion = By.xpath ("//android.view.View[@text='删除成功！']");

    public void addContact() {
        SingleDriver.getInstance().manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        find(normalContact).click();
        (new TouchAction(SingleDriver.getInstance()))
                .press(PointOption.point(506, 1700)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(506, 1092)).release().perform();
        find(addContact).click();
        SingleDriver.getInstance().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        System.out.println("新建联系人开始");
    }

    public void verifyRequiredFileds () {
        MobileElement waitNewContact = (MobileElement) new WebDriverWait(SingleDriver.getInstance(),15)
                .until(ExpectedConditions.visibilityOfElementLocated(saveContact));
        find(saveContact).click();
        MobileElement waitNameToast = (MobileElement) new WebDriverWait(SingleDriver.getInstance(),2)
                .until(ExpectedConditions.visibilityOfElementLocated(noneName));
        String toastName = find(noneName).getAttribute("text");
        if (toastName.equals("请输入姓名"))
            System.out.println("姓名不能为空验证通过");

        find(editName).sendKeys("Contact/Nametest");
        /**
        find(saveContact).click();
        MobileElement waitMobileToast1 = (MobileElement) new WebDriverWait(SingleDriver.getInstance(),3)
                .until(ExpectedConditions.visibilityOfElementLocated(noneMobile));
        String toastMobile1 = find(noneMobile).getAttribute("text");
        if (toastMobile1.equals("手机号格式不正确"))
            System.out.println("手机号不能为空验证通过");
        find(editMobile).sendKeys("166");
        find(saveContact).click();
        MobileElement waitMobileToast2 = (MobileElement) new WebDriverWait(SingleDriver.getInstance(),3)
                .until(ExpectedConditions.visibilityOfElementLocated(wrongMobile));
        String toastMobile2 = find(wrongMobile).getAttribute("text");
        if (toastMobile2.equals("抱歉，手机号码需输入11位数字"))
            System.out.println("手机号格式不正确验证通过");

        editMobile = By.xpath("//android.widget.EditText[@text='166']");
        find(editMobile).clear();
        editMobile = By.xpath("//android.widget.EditText[@text='请输入手机号']");
        MobileElement waitCommitToast = (MobileElement) new WebDriverWait(SingleDriver.getInstance(),3)
                .until(ExpectedConditions.visibilityOfElementLocated(editMobile));
        */
        find(editMobile).sendKeys("18618491223");
        /**
        find(editEmail).sendKeys ("87524112@qq");
        find(saveContact).click();
        MobileElement waitAddressToast1 = (MobileElement) new WebDriverWait(SingleDriver.getInstance(),3)
                .until(ExpectedConditions.visibilityOfElementLocated(wrongEmail));
        String toastEmail = find(wrongEmail).getAttribute("text");
        if (toastEmail.equals ("Email格式错误"))
            System.out.println ("Email格式不正确验证通过");

        editEmail = By.xpath("//android.widget.EditText[@text='87524112@qq']");
        find(editEmail).clear();
        editEmail = By.xpath("//android.widget.EditText[@text='请输入Email']");
        MobileElement waitCommitToast2 = (MobileElement) new WebDriverWait(SingleDriver.getInstance(),3)
                .until(ExpectedConditions.visibilityOfElementLocated(editEmail));
        */
        find(editEmail).sendKeys("87524112@qq.com");
        find(saveContact).click();
        MobileElement waitCommitToast3 = (MobileElement) new WebDriverWait(SingleDriver.getInstance(),1)
                .until(ExpectedConditions.visibilityOfElementLocated(goCommitt));
        String toastCommit = find(goCommitt).getAttribute("text");
        if (toastCommit.equals("正在提交数据..."))
            System.out.println("提交新增联系人中...");
        MobileElement waitAddedToast4 = (MobileElement) new WebDriverWait(SingleDriver.getInstance(),5)
                .until(ExpectedConditions.visibilityOfElementLocated(successfulNewAddress));
        String toastAdded = find(successfulNewAddress).getAttribute("text");
        if (toastAdded.equals("新增成功"))
            System.out.println("新增联系人验证通过");
    }

    public void delContact() {
        MobileElement waitDelContact = (MobileElement) new WebDriverWait(SingleDriver.getInstance(),15)
                .until(ExpectedConditions.visibilityOfElementLocated(delIcon));
        find(delIcon).click();
        SingleDriver.getInstance().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        MobileElement waitDelBtn = (MobileElement) new WebDriverWait(SingleDriver.getInstance(),5)
                .until(ExpectedConditions.visibilityOfElementLocated(delBtn));
        (new TouchAction (SingleDriver.getInstance ())).tap(PointOption.point (105, 305)).perform ();
        find(delBtn).click();
        MobileElement waitDelText = (MobileElement) new WebDriverWait(SingleDriver.getInstance(),3)
                .until(ExpectedConditions.visibilityOfElementLocated(delText));
        find(cancelDelBtn).click ();
        find(delBtn).click();
        MobileElement waitCommitToast2 = (MobileElement) new WebDriverWait(SingleDriver.getInstance(),3)
                .until(ExpectedConditions.visibilityOfElementLocated(delText));
        find(confirmDelBtn).click ();
        MobileElement waitAddedToast = (MobileElement) new WebDriverWait(SingleDriver.getInstance(),5)
                .until(ExpectedConditions.visibilityOfElementLocated(successfulDeletion));
        String taostDeleted = find(successfulDeletion).getAttribute ("text");
        if (taostDeleted.equals ("删除成功！"))
            System.out.println ("删除联系人验证通过");
    }

    public MinePage backtoMinePage() {
        MobileElement waitNewContact = (MobileElement) new WebDriverWait(SingleDriver.getInstance(),12)
                .until(ExpectedConditions.visibilityOfElementLocated(normalContact));
        (new TouchAction (SingleDriver.getInstance ())).tap(PointOption.point (70, 160)).perform ();
        return new MinePage ();
    }
}
