package pages;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.SingleDriver;

import java.util.concurrent.TimeUnit;

public class MinePage extends BasePage {
    public static MinePage minePage() { return new MinePage(); }

    private By settingsIcon = By.id ("com.rytong.hnair.nightly:id/iv_setting_login");
    private By myOrder = By.xpath ("//android.widget.TextView[@text='订单管理']");
    private By myCoupon = By.xpath ("//android.widget.TextView[@text='我的优惠券']");
    private By myFavorite = By.xpath ("//android.widget.TextView[@text='我的收藏']");

    private By loginBtn = By.id("com.rytong.hnair.nightly:id/bt_user_index_login");
    private By normalAddress = By.xpath("//android.widget.TextView[@text='常用邮寄地址' and @instance='17']");

    public AddressPage gotoAddressPage() {
        MobileElement searchToAddr = (MobileElement) new WebDriverWait(SingleDriver.getInstance(), 6)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@instance='17' and @text='常用邮寄地址']")));
        find(normalAddress).click();
        SingleDriver.getInstance().manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);

        return new AddressPage();
    }

    public LoginPage gotoLoginPage() {
        MobileElement loginButton = (MobileElement) new WebDriverWait(SingleDriver.getInstance(), 8)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.Button[@resource-id='com.rytong.hnair.nightly:id/bt_user_index_login']")));
        find(loginBtn).click();

        return new LoginPage();
    }

    public SettingsPage gotoSettingsPage() {
        MobileElement settingIcon = (MobileElement) new WebDriverWait (SingleDriver.getInstance (),6)
                .until (ExpectedConditions.visibilityOfElementLocated(settingsIcon));
        find (settingsIcon).click ();

        return new SettingsPage();
    }

    public String getUsername() {
        return find(By.id("com.rytong.hnair.nightly:id/tv_user_userName")).getText();
    }

    public String getFfpid() {
        return find(By.id("com.rytong.hnair.nightly:id/tv_flightCard")).getText();
    }

    public String getScore() {
        return find(By.id("com.rytong.hnair.nightly:id/tv_avPoint")).getText();
    }

    public String getCertificationStatus() {
        return find(By.id("com.rytong.hnair.nightly:id/ll_already_realConfirm")).getText();
    }

    public void backFromOrder() {
        find(myOrder).click();
        By orderManager = By.xpath("//android.widget.TextView[@text='订单管理']");
        final MobileElement waitOrders = (MobileElement) new WebDriverWait(SingleDriver.getInstance(),25)
                .until(ExpectedConditions.visibilityOfElementLocated(orderManager));
        (new TouchAction(SingleDriver.getInstance ())).tap(PointOption.point (70, 160)).perform ();
    }

    public void backFromCoupon() {
        find(myCoupon).click();
        By couponManager = By.xpath("//android.widget.TextView[@text='我的优惠券']");
        final MobileElement waitCoupons = (MobileElement) new WebDriverWait(SingleDriver.getInstance(),25)
                .until(ExpectedConditions.visibilityOfElementLocated(couponManager));
        (new TouchAction(SingleDriver.getInstance ())).tap(PointOption.point (70, 160)).perform ();
    }

    public void backFromFavor() {
        find(myFavorite).click();
        By favorManager = By.xpath("//android.widget.TextView[@text='我的收藏']");
        final MobileElement waitFavors = (MobileElement) new WebDriverWait(SingleDriver.getInstance(),25)
                .until(ExpectedConditions.visibilityOfElementLocated(favorManager));
        (new TouchAction(SingleDriver.getInstance ())).tap(PointOption.point (70, 160)).perform ();
    }
}
