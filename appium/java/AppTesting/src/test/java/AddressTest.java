import junit.framework.TestCase;
import org.junit.AfterClass;
import org.junit.Test;
import pages.*;
import utils.SingleDriver;

public class AddressTest extends TestCase {
    @Test
    public void testAddress() {
        SingleDriver.getInstance();
        Page我的 page我的 = new Page我的();
        Page常用邮寄地址 page常用邮寄地址 = page我的.gotoAddressPage();
        page常用邮寄地址.createAddress();
        page常用邮寄地址.verifyRequiredFileds();
    }

    @AfterClass
    public void tearDown() {
        SingleDriver.getInstance().quit();
    }
}
