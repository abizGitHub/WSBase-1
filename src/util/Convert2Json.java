package util;

import model.GeneralModel;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

/**
 * Created with IntelliJ IDEA.
 * User: Abiz
 * Date: 4/14/18
 * Time: 4:53 PM
 * To change this template use File | Settings | File Templates.
 */

public class Convert2Json {

    public static JSONObject parseGM(GeneralModel gm){
        JSONObject json = new JSONObject();
        try {
            json.put("id", gm.getId());
            json.put("body", gm.getBody());
            json.put("title", gm.getTitle());
            json.put("headerL", gm.getHeaderL());
            json.put("headerR", gm.getHeaderR());
            json.put("footerL", gm.getFooterL());
            json.put("footerR", gm.getFooterR());
            //json.put("stared", gm.getStared());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return json;
    }
}
