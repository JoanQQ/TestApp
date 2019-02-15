import junit.framework.TestCase;
import org.junit.Test;
import pages.LoginPage;
import utils.SingleDriver;

import java.util.concurrent.TimeUnit;

/**
 * @author Phyllis
 * @Description ${todo}
 * @date 2019-02-14 13:56
 */
/**@RunWith(Parameterized.class)*/
public class LoginTest extends TestCase {
    /**
    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][] {
                {"7050812098", "121321"}
        };
    }
    @Parameterized.Parameter
    public String username;
    @Parameterized.Parameter(1)
    public String password;
    */

    @Test
    public void testLogin() {
        SingleDriver.getInstance();
        LoginPage loginPage = new LoginPage();
        loginPage.gotoMainPage("7050812098","121321");
        SingleDriver.getInstance().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }
}
