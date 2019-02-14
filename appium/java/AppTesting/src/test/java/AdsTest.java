import junit.framework.TestCase;
import org.junit.Test;
import pages.PageGdpr;
import pages.Page广告页;
import pages.Page授权;
import pages.Page首页;
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
        Page广告页 page广告页 = new Page广告页();
        Page首页 mainPage1 = page广告页.gotoMainPage();
    }
}
