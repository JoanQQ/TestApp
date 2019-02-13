package pages;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sun.jvm.hotspot.utilities.Assert;
import utils.HnaDriver;
import org.openqa.selenium.By;
import java.util.concurrent.TimeUnit;

/**
 * @author Phyllis
 * @date 2019-01-15 15:40
 */
public class Page常用邮寄地址 extends BasePage {
    private By newAddress = By.xpath("//android.view.View[@text='新增邮寄地址']");
    private By saveAddress = By.xpath("//android.view.View[@text='保存']");
    private By editName = By.xpath("//android.widget.EditText[@text='请输入姓名']");

    private By toastView = By.id("com.rytong.hnair.nightly:id/iv_user_center_menu");

    private By noneName = By.xpath("//android.view.View[@text='请输入姓名']");
    private By noneMobile = By.xpath("//android.view.View[@text='请输入手机号']");
    private By wrongMobile = By.xpath("//android.view.View[@text='请输入11位数字手机号码']");
    private By noneAddress = By.xpath("//android.view.View[@text='请输入收件地址']");
    private By wrongAddress = By.xpath("//android.view.View[@text='收件地址长度不能小于10个字符，最多可输入100个字符。']");
    private By nonePostcode = By.xpath("//android.view.View[@text='请输入邮政编码']");
    private By wrongPostcode = By.xpath("//android.view.View[@text='邮政编码必须是6位数']");
    private By goCommitt = By.xpath("//android.view.View[@text='正在提交数据...']");
    private By successfulNewAddress = By.xpath("//android.view.View[@text='新增成功']");


    public void createAddress() {
        System.out.println("新建邮寄地址测试开始");
        MobileElement waitNormalAddress = (MobileElement) new WebDriverWait(HnaDriver.getCurrentDriver(),5)
                .until(ExpectedConditions.visibilityOfElementLocated(newAddress));
        find(newAddress).click();
    }

    public void verifyRequiredFileds () {
        MobileElement waitNewAddress = (MobileElement) new WebDriverWait(HnaDriver.getCurrentDriver(),3)
                .until(ExpectedConditions.visibilityOfElementLocated(saveAddress));
        find(saveAddress).click();
        MobileElement waitNameToast = (MobileElement) new WebDriverWait(HnaDriver.getCurrentDriver(),2)
                .until(ExpectedConditions.visibilityOfElementLocated(noneName));
        String toastName = find(noneName).getAttribute("text");
        if (toastName.equals("请输入姓名"))
            System.out.println("姓名不能为空验证通过");
        find(editName).sendKeys("Appium/AndroidTest");
        find(saveAddress).click();
        MobileElement waitMobileToast = (MobileElement) new WebDriverWait(HnaDriver.getCurrentDriver(),2)
                .until(ExpectedConditions.visibilityOfElementLocated(noneMobile));
        String toastMobile = find(noneMobile).getAttribute("text");
        if (toastMobile.equals("请输入手机号"))
            System.out.println("手机号不能为空验证通过");
    }
}
