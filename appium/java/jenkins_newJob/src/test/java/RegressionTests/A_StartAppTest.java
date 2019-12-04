package RegressionTests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;
import utils.SingleDriver;

/**
 * @author Phyllis
 * @date 2019-05-13 17:00
 */
@Epic ("启动")
@Feature ("点击打开\"海南航空\"APP")
public class A_StartAppTest {
    @Test
    public void testStart() {
        SingleDriver.getInstance();
        this.printToWarnSuccessfulOpening ();
    }

    @Step("显示是否成功打开海南航空App")
    public void printToWarnSuccessfulOpening() { System.out.println("成功打开海南航空App"); }

    /**
    @Test
    @DisplayName("Allure描述")
    @Story("Allure注解描述")
    @Description("失败用例，此处为描述信息")
    @Severity(SeverityLevel.CRITICAL)
    void addDescription() { Assertions.assertTrue(false); }

    @Test
    @Story("Allure添加步骤")
    @Description("用例包含多个步骤")
    @Severity(SeverityLevel.NORMAL)
    void multiSteps() { step001(); step002(); step003(); }
    @Step("用例步骤一")
    void step001() {}
    @Step("用例步骤二")
    void step002() {}
    @Step("用例步骤三")
    void step003() {}
    */
}

/**
@Epic(value = "Allure测试报告演示Demo")
@Feature("演示Allure中的注解定制")
public class AllureTest {
    @Test
    @Story("Allure添加步骤")
    @Description("用例包含多个步骤")
    @Severity(SeverityLevel.NORMAL)
    void multiSteps() { step001(); step002(); step003(); }
    @Step("用例步骤一")
    void step001() {}
    @Step("用例步骤二")
    void step002() {}
    @Step("用例步骤三")
    void step003() {}

    // 附件区直接显示内容
    @Test
    @Story("JUnit携带附件")
    @Description("附件直接输出内容")
    public void simpleTestWithAttachments() throws Exception {
        assert(2, is (2));
        makeAttach();
    }
    @Attachment
    public String makeAttach() { return "yeah, 2 is 2"; }

    // 附件区显示csv文件
    @Description("携带文件作为附件")
    @Test
    @Story("JUnit携带附件")
    public void csvAttachmentTest() throws Exception { saveCsvAttachment(); }
    @Attachment(value = "Sample csv attachment", type = "text/csv")
    public byte[] saveCsvAttachment() throws URISyntaxException, IOException {
        URL resource = getClass().getClassLoader().getResource("sample.csv");
        if (resource == null) {
            fail("Couldn't find resource 'sample.csv'");
        }
        return Files.readAllBytes(Paths.get(resource.toURI()));
    }

    // 配置显示外部链接
    @Test
    @Story("Allure外部链接")
    @Description("失败用例关联issue")
    @Severity(SeverityLevel.BLOCKER)
    @Issue("1")
    void testIssues() { Assertions.assertEquals(2,3); }

    @Test
    @Story("Allure外部链接")
    @Description("关联用例管理系统用例链接")
    @Severity(SeverityLevel.MINOR)
    @TmsLink("Case001")
    void testTmsLink() { Assertions.assertEquals(2,2); }

    @Test
    @Story("Allure外部链接")
    @Description("关联外部资源链接")
    @Severity(SeverityLevel.MINOR)
    @Link(name = "5c83d2aa6d5f670edc43c606", type = "qiucao")
    void testLink() { Assertions.assertEquals(2,2); }
}
*/