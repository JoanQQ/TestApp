import junit.framework.TestCase;
import org.junit.AfterClass;
import org.junit.Test;
import pages.*;
import utils.SingleDriver;

public class AddressTest extends TestCase {
    @Test
    public void testAddress() {
        SingleDriver.getInstance();
        AddressPage addressPage = new AddressPage();
        addressPage.createAddress();
        addressPage.verifyRequiredFileds();
    }

    /**
    @AfterClass
    public void tearDown() {
        SingleDriver.getInstance().quit();
    }
    */
}
