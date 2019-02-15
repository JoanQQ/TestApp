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
        System.out.println("Successful opening, using SingleDriver with the same session");
    }
}
