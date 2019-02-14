import junit.framework.TestCase;
import org.junit.Test;
import pages.Page首页;
import utils.SingleDriver;

/**
 * @author Phyllis
 * @Title ${file_name}
 * @Package ${package_name}
 * @Description ${todo}
 * @date 2019-02-14 14:03
 */
public class MineTest extends TestCase {
    @Test
    public void testMine() {
        SingleDriver.getInstance();
        Page首页 page首页 = new Page首页();
        page首页.gotoMinePage();
    }
}
