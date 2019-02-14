import junit.framework.TestCase;
import org.junit.Test;
import pages.*;
import utils.SingleDriver;

public class GdprTest extends TestCase {
    @Test
    public void testGdpr() {
        SingleDriver.getInstance();
        PageGdpr pageGdpr = new PageGdpr();
        //Page授权 page授权 = pageGdpr.gotoAuthPage();
        pageGdpr.gotoAdsPage();
    }
}
