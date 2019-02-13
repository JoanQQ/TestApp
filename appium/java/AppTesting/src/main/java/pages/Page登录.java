package pages;

import org.openqa.selenium.By;
import utils.HnaDriver;

import java.util.concurrent.TimeUnit;

public class Page登录 extends BasePage {
    private By username = By.id("com.rytong.hnair.nightly:id/et_username");
    private By password = By.id("com.rytong.hnair.nightly:id/et_password");
    private By loginBtn = By.id("com.rytong.hnair.nightly:id/btn_login");
    //private By missUserName = text("抱歉，请输入您的会员帐号");

    public Page首页 gotoMainPage(String username, String password) {
        find(this.username).sendKeys(username);
        find(this.password).sendKeys(password);
        find(loginBtn).click();
        HnaDriver.getCurrentDriver().manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);

        return new Page首页();
    }

    /**
     public Page登录 failedLogin(String usernmae, String password) {
     HnaDriver.getCurrentDriver().findElement(By.id(loginBtn)).click();
     HnaDriver.getCurrentDriver().findElement(By.id(username)).sendKeys("7050812098");
     HnaDriver.getCurrentDriver().findElement(By.id(password)).sendKeys("121321");

     }
     */
}
