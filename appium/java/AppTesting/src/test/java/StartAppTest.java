import junit.framework.TestCase;
import org.junit.Test;
import utils.SingleDriver;

/**
 * @author Phyllis
 * @date 2019-02-13 17:00
 */
public class StartAppTest extends TestCase {
    @Test
    public void testStart() {
        SingleDriver.getInstance();
        System.out.println("成功打开海南航空App, using AppDriver");
    }
}
