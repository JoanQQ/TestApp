import junit.framework.TestCase;
import org.junit.Test;
import pages.AdsPage;
import pages.MainPage;
import utils.SingleDriver;

/**
 * @author Phyllis
 * @Description ${todo}
 * @date 2019-02-14 13:46
 */
public class AdsTest extends TestCase {
    @Test
    public void testAds() {
        SingleDriver.getInstance();
        AdsPage adsPage = new AdsPage();
        adsPage.gotoMainPage();
    }
}
