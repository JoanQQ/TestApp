package pages.Common;

import org.openqa.selenium.By;
import pages.Main.MainPage;
import pages.Mine.MinePage;
import pages.Mine.PassengerPage;

public class LoginPage extends BasePage {
    private By username = By.id("com.rytong.hnair.nightly:id/et_username");
    private By password = By.id("com.rytong.hnair.nightly:id/et_password");
    private By loginBtn = By.id("com.rytong.hnair.nightly:id/btn_login");
    //private By missUserName = text("抱歉，请输入您的会员帐号");

    public MainPage gotoMainPage(String username, String password) {
        find(this.username).sendKeys(username);
        find(this.password).sendKeys(password);
        find(loginBtn).click();

        return new MainPage();
    }

    public MinePage gotoMinePage(String username, String password) {
        find(this.username).sendKeys(username);
        find(this.password).sendKeys(password);
        find(loginBtn).click();

        return new MinePage();
    }

    public PassengerPage gotoPassengerPage(String username, String password) {
        find(this.username).sendKeys(username);
        find(this.password).sendKeys(password);
        find(loginBtn).click();

        return new PassengerPage ();
    }
}
