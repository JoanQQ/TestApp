import junit.framework.TestCase;
import org.junit.Test;
import pages.*;
import utils.SingleDriver;

public class GdprTest extends TestCase {
    @Test
    public void testGdpr() {
        SingleDriver.getInstance();
        GdprPage gdprPage = new GdprPage();
        gdprPage.gotoAdsPage();
        //pageGdpr.gotoAuthPage();
    }
}
