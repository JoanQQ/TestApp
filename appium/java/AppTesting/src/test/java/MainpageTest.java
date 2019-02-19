import junit.framework.TestCase;
import org.junit.Test;
import pages.Main.MainPage;
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
        MainPage mainPage1 = new MainPage();
        mainPage1.gotoLoginPage();
    }
}
