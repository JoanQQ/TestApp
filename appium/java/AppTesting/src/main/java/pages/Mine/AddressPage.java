package pages.Mine;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import pages.Common.BasePage;
import utils.SingleDriver;

/**
 * @author Phyllis
 * @date 2019-01-15 15:40
 */
public class AddressPage extends BasePage {
    public static AddressPage addressPage() { return new AddressPage(); }
    private By normalAddress = By.xpath("//android.view.View[@text='常用邮寄地址：']");
    private By newAddress = By.xpath("//android.view.View[@text='新增邮寄地址']");
    private By saveAddress = By.xpath("//android.view.View[@text='保存']");
    private By editName = By.xpath("//android.widget.EditText[@text='请输入姓名']");
    private By noneName = By.xpath("//android.view.View[@text='请输入姓名']");
    private By noneMobile = By.xpath("//android.view.View[@text='请输入手机号']");
    private By wrongMobile = By.xpath("//android.view.View[@text='请输入11位数字手机号码']");
    private By editMobile = By.xpath("//android.widget.EditText[@text='请输入手机号']");
    private By noneAddress = By.xpath("//android.view.View[@text='请输入收件地址']");
    private By wrongAddress = By.xpath("//android.view.View[@text='收件地址长度不能小于10个字符，最多可输入100个字符。']");
    private By editAddress = By.xpath("//android.widget.EditText[@text='请输入地址']");
    private By nonePostcode = By.xpath("//android.view.View[@text='请输入邮政编码']");
    private By wrongPostcode = By.xpath("//android.view.View[@text='邮政编码必须是6位数']");
    private By editPostcode = By.xpath("//android.widget.EditText[@text='请输入邮政编码']");
    private By goCommitt = By.xpath("//android.view.View[@text='正在提交数据...']");
    private By successfulNewAddress = By.xpath("//android.view.View[@text='新增成功']");
    private By toastView = By.id("com.rytong.hnair.nightly:id/iv_user_center_menu");
    //private By delIcon = By.xpath ("//android.widget.Image[@='']");
    private By delBtn = By.xpath ("//android.view.View[@text='确定']");
    private By cancelDelBtn = By.xpath ("//android.view.View[@text='取消']");
    private By successfulDeletion = By.xpath ("//android.view.View[@text='删除成功！']");

    public void createAddress() {
        SingleDriver.getInstance().manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        find(normalAddress).click();
        (new TouchAction(SingleDriver.getInstance()))
                .press(PointOption.point(506, 1700)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(506, 1092)).release().perform();
        find(newAddress).click();
        SingleDriver.getInstance().manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        System.out.println("新建邮寄地址测试开始");

        find(editName).sendKeys("Appium/AndroidTest");
        find(editMobile).sendKeys("18618491223");
        find(editAddress).sendKeys("测试邮寄地址大于十个汉字测试");
        find(editPostcode).sendKeys("123456");
        find(saveAddress).click();

        MobileElement waitAddedToast = (MobileElement) new WebDriverWait(SingleDriver.getInstance(),5)
                .until(ExpectedConditions.visibilityOfElementLocated(successfulNewAddress));
        String toastAdded = find(successfulNewAddress).getAttribute("text");
        if (toastAdded.equals("新增成功"))
            System.out.println("新增邮寄地址验证通过");
    }

    public void verifyRequiredFileds () {
        MobileElement waitNewAddress = (MobileElement) new WebDriverWait(SingleDriver.getInstance(),12)
                .until(ExpectedConditions.visibilityOfElementLocated(saveAddress));
        find(saveAddress).click();
        MobileElement waitNameToast = (MobileElement) new WebDriverWait(SingleDriver.getInstance(),2)
                .until(ExpectedConditions.visibilityOfElementLocated(noneName));
        String toastName = find(noneName).getAttribute("text");
        if (toastName.equals("请输入姓名"))
            System.out.println("姓名不能为空验证通过");

        find(editName).sendKeys("Appium/AndroidTest");
        find(saveAddress).click();
        MobileElement waitMobileToast1 = (MobileElement) new WebDriverWait(SingleDriver.getInstance(),3)
                .until(ExpectedConditions.visibilityOfElementLocated(noneMobile));
        String toastMobile1 = find(noneMobile).getAttribute("text");
        if (toastMobile1.equals("请输入手机号"))
            System.out.println("手机号不能为空验证通过");

        find(editMobile).sendKeys("166");
        find(saveAddress).click();
        MobileElement waitMobileToast2 = (MobileElement) new WebDriverWait(SingleDriver.getInstance(),3)
                .until(ExpectedConditions.visibilityOfElementLocated(wrongMobile));
        String toastMobile2 = find(wrongMobile).getAttribute("text");
        if (toastMobile2.equals("请输入11位数字手机号码"))
            System.out.println("手机号少于11位验证通过");

        editMobile = By.xpath("//android.widget.EditText[@text='166']");

        find(editMobile).sendKeys("18618491223");
        find(saveAddress).click();
        MobileElement waitAddressToast1 = (MobileElement) new WebDriverWait(SingleDriver.getInstance(),3)
                .until(ExpectedConditions.visibilityOfElementLocated(noneAddress));
        String toastAddress1 = find(noneAddress).getAttribute("text");
        if (toastAddress1.equals("请输入收件地址"))
            System.out.println("邮寄地址不能为空验证通过");
        find(editAddress).sendKeys("测试地址");
        find(saveAddress).click();
        MobileElement waitAddressToast2 = (MobileElement) new WebDriverWait(SingleDriver.getInstance(),5)
                .until(ExpectedConditions.visibilityOfElementLocated(wrongAddress));
        String toastAddress2 = find(wrongAddress).getAttribute("text");
        if (toastAddress2.equals("收件地址长度不能小于10个字符，最多可输入100个字符。"))
            System.out.println("邮寄地址少于十个字符验证通过");

        editAddress = By.xpath("//android.widget.EditText[@text='测试地址']");
        find(editAddress).clear();
        find(editAddress).sendKeys("测试邮寄地址大于十个汉字测试");
        find(saveAddress).click();
        MobileElement waitPostcodeToast1 = (MobileElement) new WebDriverWait(SingleDriver.getInstance(),5)
                .until(ExpectedConditions.visibilityOfElementLocated(nonePostcode));
        String toastPostcode1 = find(nonePostcode).getAttribute("text");
        if (toastPostcode1.equals("请输入邮政编码"))
            System.out.println("邮政编码不能为空验证通过");
        find(editPostcode).sendKeys("123");
        find(saveAddress).click();
        MobileElement waitPostcodeToast2 = (MobileElement) new WebDriverWait(SingleDriver.getInstance(),5)
                .until(ExpectedConditions.visibilityOfElementLocated(wrongPostcode));
        String toastPostcode2 = find(wrongPostcode).getAttribute("text");
        if (toastPostcode2.equals("邮政编码必须是6位数"))
            System.out.println("邮政编码必须是6位数验证通过");

        editPostcode = By.xpath("//android.widget.EditText[@text='123']");
        find(editPostcode).sendKeys("123456");
        MobileElement waitSaveAddress2 = (MobileElement) new WebDriverWait(SingleDriver.getInstance(),2)
                .until(ExpectedConditions.visibilityOfElementLocated(saveAddress));
        find(saveAddress).click();
        MobileElement waitCommitToast = (MobileElement) new WebDriverWait(SingleDriver.getInstance(),1)
                .until(ExpectedConditions.visibilityOfElementLocated(goCommitt));
        String toastCommit = find(goCommitt).getAttribute("text");
        if (toastCommit.equals("正在提交数据..."))
            System.out.println("提交新增邮寄地址中...");
        MobileElement waitAddedToast = (MobileElement) new WebDriverWait(SingleDriver.getInstance(),6)
                .until(ExpectedConditions.visibilityOfElementLocated(successfulNewAddress));
        String toastAdded = find(successfulNewAddress).getAttribute("text");
        if (toastAdded.equals("新增成功"))
            System.out.println("新增邮寄地址验证通过");
    }

    public void delNewAddress() {
        MobileElement waitDelAdd1 = (MobileElement) new WebDriverWait(SingleDriver.getInstance(),15)
                .until(ExpectedConditions.visibilityOfElementLocated(newAddress));
        (new TouchAction(SingleDriver.getInstance ())).tap(PointOption.point (960,963)).perform();
        SingleDriver.getInstance().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        MobileElement waitDelText = (MobileElement) new WebDriverWait(SingleDriver.getInstance(),3)
                .until(ExpectedConditions.visibilityOfElementLocated(cancelDelBtn));
        find(cancelDelBtn).click ();
        MobileElement waitDelAdd2 = (MobileElement) new WebDriverWait(SingleDriver.getInstance(),5)
                .until(ExpectedConditions.visibilityOfElementLocated(newAddress));
        (new TouchAction(SingleDriver.getInstance ())).tap(PointOption.point (960,963)).perform();
        MobileElement waitDelBtn = (MobileElement) new WebDriverWait(SingleDriver.getInstance(),5)
                .until(ExpectedConditions.visibilityOfElementLocated(delBtn));
        (new TouchAction (SingleDriver.getInstance ())).tap(PointOption.point (105, 305)).perform ();
        find(delBtn).click();
        MobileElement waitDelToast = (MobileElement) new WebDriverWait(SingleDriver.getInstance(),5)
                .until(ExpectedConditions.visibilityOfElementLocated(successfulDeletion));
        String taostDeleted = find(successfulDeletion).getAttribute ("text");
        if (taostDeleted.equals ("删除成功！"))
            System.out.println ("删除联系人验证通过");
    }

    public MinePage backtoMinePage() {
        MobileElement waitNewAddress = (MobileElement) new WebDriverWait(SingleDriver.getInstance(),12)
                .until(ExpectedConditions.visibilityOfElementLocated(normalAddress));
        (new TouchAction (SingleDriver.getInstance ())).tap(PointOption.point (70, 160)).perform ();
        return new MinePage ();
    }
}
