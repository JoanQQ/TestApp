import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * @author Phyllis
 * @date 2019-02-14 13:35
 */
public class TestallSuite {
    public static Test suite() {
        TestSuite suite = new TestSuite("Run All Tests");
        suite.addTestSuite(StartAppTest.class);
        suite.addTestSuite(GdprTest.class);
        suite.addTestSuite(AdsTest.class);
        suite.addTestSuite(MainpageTest.class);
        suite.addTestSuite(LoginTest.class);
        //suite.addTestSuite(MineTest.class);
        suite.addTestSuite(AddressTest.class);
        return suite;
    }
}
