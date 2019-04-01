package tmp;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.Map;

/**
 * @author Phyllis
 * @date 2019-04-01 10:44
 */
public class RequestConfig {
    //设置请求的地址和端口号
    public void setHttpURIandPortValue(String URI, int port){
        RestAssured.baseURI =URI;
        RestAssured.port = port;
    }

    //发送get请求
    public Response setGet(Map setParams, String URI){
        return RestAssured.given().params(setParams).when().get(URI);
    }

    //发送post请求
    public Response setPost(Map setParams,String URI){
        return RestAssured.given().params(setParams).when().post(URI);
    }
}
