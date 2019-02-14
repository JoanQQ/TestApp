import junit.framework.TestCase;
import org.junit.Test;
import pages.Page首页;
import pages.Page登录;
import utils.SingleDriver;

/**
 * @author Phyllis
 * @Description ${todo}
 * @date 2019-02-14 13:54
 */
public class MainpageTest extends TestCase {
    @Test
    public void testAds() {
        SingleDriver.getInstance();
        Page首页 mainPage1 = new Page首页();
        Page登录 loginPage = mainPage1.gotoLoginPage();
    }
}
