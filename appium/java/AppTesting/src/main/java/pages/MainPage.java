package pages;

import org.openqa.selenium.By;
import utils.SingleDriver;

import java.util.concurrent.TimeUnit;

public class MainPage {
    public static MainPage mainPage() { return new MainPage(); }
    private By login = By.id("com.rytong.hnair.nightly:id/btn_login");
    private By tabMine = By.id("com.rytong.hnair.nightly:id/rb_tab5");

    public LoginPage gotoLoginPage() {
        SingleDriver.getInstance().findElement(login).click();
        SingleDriver.getInstance().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

        return new LoginPage();
    }

    public MinePage gotoMinePage() {
        SingleDriver.getInstance().findElement(tabMine).click();
        SingleDriver.getInstance().manage().timeouts().implicitlyWait(6,TimeUnit.SECONDS);

        return new MinePage();
    }
}