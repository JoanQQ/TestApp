import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.Page登录;
import utils.SingleDriver;

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
        Page登录 page登录 = new Page登录();
        page登录.gotoMainPage("7050812098","121321");
    }
}
