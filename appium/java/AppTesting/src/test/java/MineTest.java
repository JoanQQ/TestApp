import junit.framework.TestCase;
import org.junit.Test;
import pages.MainPage;
import pages.MinePage;
import utils.SingleDriver;

import java.util.concurrent.TimeUnit;

/**
 * @author Phyllis
 * @Title ${file_name}
 * @Package ${package_name}
 * @Description ${todo}
 * @date 2019-02-14 14:03
 */
public class MineTest extends TestCase {
    @Test
    public void testMine() {
        SingleDriver.getInstance();
        MainPage mainPage = new MainPage();
        MinePage minePage = mainPage.gotoMinePage();
        SingleDriver.getInstance().manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        minePage.gotoAddressPage();
    }
}
