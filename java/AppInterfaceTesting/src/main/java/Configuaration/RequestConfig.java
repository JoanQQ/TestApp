package Configuaration;

import org.json.JSONObject;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Phyllis
 * @Title ${file_name}
 * @Package ${package_name}
 * @Description ${todo}
 * @date 2019-04-01 15:11
 */
public class RequestConfig {
    public RequestConfig(){}
    public static JSONObject jsonRequest = new JSONObject ();
    public static Map<String, Object> commonMap = new HashMap<String, Object> ();
    public static JSONObject jsonCommon;

    public static JSONObject getJsonCommon() {
        if(commonMap==null){
            commonMap.put ("abuild","11931");
            commonMap.put ("akey","6571AF53581B48D98706A38F6A907DBB");
            commonMap.put ("aname","com.hnair.spa.web.nightly");
            commonMap.put ("atarget","nightly");
            commonMap.put ("aver","7.2.0");
            commonMap.put ("did","351670061673120");
            commonMap.put ("gtcid","defualt_web_gtcid");
            commonMap.put ("riskToken","5ca16d4cAIbhqSfoVGImqHgC9LgsOCijCIrbw4I1");
            commonMap.put ("schannel","HTML5");
            commonMap.put ("slang","zh-CN");
            commonMap.put ("slat","slat");
            commonMap.put ("slng","slng");
            commonMap.put ("sname","MacIntel");
            commonMap.put ("stime",new Date ().getTime ());
            commonMap.put ("sver","5.0 (iPhone; CPU iPhone OS 10_3_1 like Mac OS X) AppleWebKit/603.1.30 (KHTML, like Gecko) Version/10.0 Mobile/14E304 Safari/602.1");
            commonMap.put ("szone",-480);
        }

        return jsonCommon = new JSONObject (commonMap);
    }

    public static JSONObject getJsonRequest(JSONObject data) {
        jsonRequest.put ("common", RequestConfig.getJsonCommon ());
        jsonRequest.put ("data", data);

        return jsonRequest;
    }
}
