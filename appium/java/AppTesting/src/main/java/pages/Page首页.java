package pages;

import utils.HnaDriver;
import org.openqa.selenium.By;
import java.util.concurrent.TimeUnit;

public class Page首页 {
    By login = By.id("com.rytong.hnair.nightly:id/btn_login");

    public Page登录 gotoLoginPage() {
        HnaDriver.getCurrentDriver().findElement(login).click();
        HnaDriver.getCurrentDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        return new Page登录();
    }

    By mineTab = By.xpath("//android.widget.RadioButton[@resource-id='com.rytong.hnair.nightly:id/rb_tab5']");
    public Page我的 gotoMinePage() {
        HnaDriver.getCurrentDriver().findElement(mineTab).click();
        return new Page我的();
    }
}
