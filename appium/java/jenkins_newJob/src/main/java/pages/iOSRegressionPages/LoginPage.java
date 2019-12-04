package pages.iOSRegressionPages;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.iOSRegressionPages.FfpPage;
import utils.BasePage;
import utils.SingleDriver;
import java.util.concurrent.TimeUnit;

public class LoginPage extends BasePage {
    private By byUsername = By.name("金鹏卡号/手机/邮箱/中国身份证/护照");
    private By byPassword = By.name("登录密码");
    private By byLoginBtn = By.name("登 录");
    private By byForgetPwd = By.name("忘记密码");
    private By byForgetCardNum = By.name("忘记卡号");
    private By byRegNewMember = By.name("注册金鹏会员");
    private By byMissUserName = By.name ("抱歉，请输入您的会员账号");
    private By byMissPwd = By.name ("抱歉，请输入您的会员密码");
    private By byOtherErrMsg = By.name ("抱歉，账号出现异常，请拨打客服热线95339协助处理");
    private By byFrozenAccount = By.name ("您的账户存在安全风险，不能正常登录。如有疑问，请致电会员热线950717咨询");
    private By byDeletedAccount = By.name ("抱歉，账号或密码错误，您可尝试忘记密码或重新输入等操作");
    private By byCombinedAccount = By.name ("您的金鹏账户卡号已被合并，原卡号5005781090已合并入卡号您的金鹏账户卡号已被合并，您可尝试如下操作");

    public void inputUsername(By byUsername, String strUsername) {
        MobileElement waitUsernameEditText = (MobileElement) new WebDriverWait (SingleDriver.getInstance(),15)
                .until(ExpectedConditions.visibilityOfElementLocated(byUsername));
        find (byUsername).clear ();
        find (byUsername).sendKeys (strUsername);
    }

    public void inputPassword(By byPassword, String strPassword) {
        MobileElement waitPwdEditText = (MobileElement) new WebDriverWait (SingleDriver.getInstance(),5)
                .until(ExpectedConditions.visibilityOfElementLocated(byPassword));
        find (byPassword).clear ();
        find (byPassword).sendKeys (strPassword);
    }

    public void clickLogin(By byLogin) {
        //SingleDriver.getInstance().manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        MobileElement waitPwdEditText = (MobileElement) new WebDriverWait (SingleDriver.getInstance(),5)
                .until(ExpectedConditions.visibilityOfElementLocated(byLogin));
        find(byLogin).click();
    }

    public String getWarningMsg(By byWarning) {
        SingleDriver.getInstance().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String strWarningMsg = find(byWarning).getText ();
        return strWarningMsg;
    }

    public String getToastMsg(By byToast) {
        SingleDriver.getInstance().manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        String strToastMsg = find(byToast).getText ();
        return strToastMsg;
    }

    public void closePopup(By byCloseIcon) {
        MobileElement waitPwdEditText = (MobileElement) new WebDriverWait (SingleDriver.getInstance(),3)
                .until(ExpectedConditions.visibilityOfElementLocated(byCloseIcon));
        find (byCloseIcon).click ();
    }

    public void doLogin(String username, String password){
        SingleDriver.getInstance ().getKeyboard ();
        find(this.byUsername).sendKeys(username);
        find(this.byPassword).sendKeys(password);
        find(byLoginBtn).click();
    }

    public FfpPage gotoFfpPage(String username, String password) {
        MobileElement waitUserName = (MobileElement) new WebDriverWait (SingleDriver.getInstance(),3)
                .until(ExpectedConditions.visibilityOfElementLocated(this.byUsername));
        find(this.byUsername).sendKeys(username);
        MobileElement waitPassword = (MobileElement) new WebDriverWait (SingleDriver.getInstance(),3)
                .until(ExpectedConditions.visibilityOfElementLocated(this.byPassword));
        find(this.byPassword).sendKeys(password);
        find(byLoginBtn).click();
        SingleDriver.getInstance().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return new FfpPage();
    }
}
