package Jinpenghuiyuan;

import Configuaration.CustomVariable;
import Configuaration.RequestConfig;
import io.restassured.RestAssured;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class LoginRequest {

    public Map<String, Object> dataMap = new HashMap<String, Object> ();
    public JSONObject jsonData;
    public String number,pwd;

    public JSONObject getRequestData(String number, String pwd) {
        dataMap.put ("number", number);
        dataMap.put ("pin", pwd);
        dataMap.put ("toSave", true);

        return new JSONObject (dataMap);
    }
    public String requestData = RequestConfig.getJsonRequest (this.getRequestData (number, pwd)).toString ();

    public String isSuccessful(){

        return RestAssured.given ( ).log ().all ()
                .headers ("Accept","*/*","Content-Type","application/json;charset=UTF-8")
                .contentType ("application/json")
                .queryParam ("hnairSign", CustomVariable.hnairSign)
                .queryParam ("desc", CustomVariable.desc)
                .body (requestData)
                .when().post(CustomVariable.nightlyServer+"/webservice/v2/common/auth/login")
                .then().log ().all ()
                .extract().response ().path("success").toString ();
    }

    public String getErrorCode(){
        return RestAssured.given()
                .headers ("Accept","*/*","Content-Type","application/json;charset=UTF-8")
                .contentType ("application/json")
                .queryParam ("hnairSign", CustomVariable.hnairSign)
                .queryParam ("desc", CustomVariable.desc)
                .body (requestData)
                .when().post(CustomVariable.nightlyServer+"/webservice/v2/common/auth/login")
                .then()
                .extract().response ().path("errorCode").toString ();
    }

    public String getErrorMessage(){
        return RestAssured.given()
                .headers ("Accept","*/*","Content-Type","application/json;charset=UTF-8")
                .contentType ("application/json")
                .queryParam ("hnairSign", CustomVariable.hnairSign)
                .queryParam ("desc", CustomVariable.desc)
                .body (requestData)
                .when().post(CustomVariable.nightlyServer+"/webservice/v2/common/auth/login")
                .then()
                .extract().response ().path("errorMessage").toString ();
    }
}
