package pages;

import utils.HnaDriver;
import org.openqa.selenium.By;
import java.util.concurrent.TimeUnit;

public class Page我的 extends BasePage {
    private By normalAddress = By.xpath("//android.widget.TextView[@resource-id='com.rytong.hnair.nightly:id/tv_menu_text' and @text='常用邮寄地址']");
    private By newAddress = By.xpath("//android.view.View[@text='新增邮寄地址']");
    private By saveAddress = By.xpath("//android.view.View[@text='保存']");

    public Page常用邮寄地址 gotoAddressPage() {
        find(normalAddress).click();
        HnaDriver.getCurrentDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        find(newAddress).click();
        HnaDriver.getCurrentDriver().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        find(saveAddress);

        return new Page常用邮寄地址();
    }
}
