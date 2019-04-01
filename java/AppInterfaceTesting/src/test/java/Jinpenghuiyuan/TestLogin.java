package Jinpenghuiyuan;

import Configuaration.RequestConfig;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author Phyllis
 * @date 2019-04-01 15:49
 */
public class TestLogin {
    LoginRequest loginRequest = new LoginRequest ();
    String number,pwd;

    @Test
    public void wrongNumberTest() {
        number = "7777777777";
        pwd = "111111";
        //String requestData = RequestConfig.getJsonRequest (loginRequest.getRequestData (number,pwd)).toString ();
        String returnSuccess = loginRequest.isSuccessful ();
        String returnErrCode = loginRequest.getErrorCode ();
        String returnErrMsg = loginRequest.getErrorMessage ();
        assertThat(returnSuccess, equalTo("false"));
        assertThat(returnErrCode, equalTo("E00016"));
        assertThat(returnErrMsg, equalTo("抱歉，账号或密码错误，您可尝试忘记密码或重新输入等操作"));
    }

    @Test
    public void wrongPwdTest() {
        number = "7050812098";
        pwd = "111111";
        //String requestData = RequestConfig.getJsonRequest (loginRequest.getRequestData (number,pwd)).toString ();
        String returnSuccess = loginRequest.isSuccessful ();
        String returnErrCode = loginRequest.getErrorCode ();
        String returnErrMsg = loginRequest.getErrorMessage ();
        assertThat(returnSuccess, equalTo("false"));
        assertThat(returnErrCode, equalTo("E00011"));
        assertThat(returnErrMsg, equalTo("密码连续错误1次，还有4次尝试机会"));
    }

    @Test
    public void correctAccountTest() {
        number = "7050812098";
        pwd = "121321";
        //String requestData = RequestConfig.getJsonRequest (loginRequest.getRequestData (number,pwd)).toString ();
        String returnSuccess = loginRequest.isSuccessful ();
        String returnErrCode = loginRequest.getErrorCode ();
        String returnErrMsg = loginRequest.getErrorMessage ();
        assertThat(returnSuccess, equalTo("true"));
        assertThat(returnErrCode, equalTo(""));
        assertThat(returnErrMsg, equalTo(""));
    }
}
