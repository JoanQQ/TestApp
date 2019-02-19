import junit.framework.TestCase;
import org.junit.Test;
import pages.Mine.AddressPage;
import pages.Mine.MinePage;
import utils.SingleDriver;

public class AddressTest extends TestCase {
    @Test
    public void testAddress() {
        SingleDriver.getInstance();
        MinePage minePage = new MinePage ();
        AddressPage addressPage = minePage.gotoAddressPage ();
        addressPage.createAddress();
        addressPage.verifyRequiredFileds();
        addressPage.backtoMinePage ();
    }

    /**
    @AfterClass
    public void tearDown() {
        SingleDriver.getInstance().quit();
    }
    */
}
