package pages;

import utils.HnaDriver;
import org.openqa.selenium.By;
import java.util.concurrent.TimeUnit;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Page我的 extends BasePage {
    private By normalAddress = By.xpath("//android.widget.TextView[@text='常用邮寄地址' and @instance='17']");

    public Page常用邮寄地址 gotoAddressPage() {
        MobileElement searchToAddr = (MobileElement) new WebDriverWait(HnaDriver.getCurrentDriver(), 2)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@instance='17' and @text='常用邮寄地址']")));
        find(normalAddress).click();
        //HnaDriver.getCurrentDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        return new Page常用邮寄地址();
    }
}
