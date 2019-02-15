package pages;

import org.openqa.selenium.By;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utils.SingleDriver;

import java.util.concurrent.TimeUnit;

public class MinePage extends BasePage {
    public static MinePage minePage() { return new MinePage(); }
    private By normalAddress = By.xpath("//android.widget.TextView[@text='常用邮寄地址' and @instance='17']");

    public AddressPage gotoAddressPage() {
        MobileElement searchToAddr = (MobileElement) new WebDriverWait(SingleDriver.getInstance(), 6)
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@instance='17' and @text='常用邮寄地址']")));
        find(normalAddress).click();
        SingleDriver.getInstance().manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);

        return new AddressPage();
    }
}
