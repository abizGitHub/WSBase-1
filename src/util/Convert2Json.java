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
            json.put("ID", gm.getId());
            json.put(GeneralModel.BODY$, gm.getBody());
            json.put(GeneralModel.TITLE$, gm.getTitle());
            json.put(GeneralModel.HEADERL$, gm.getHeaderL());
            json.put(GeneralModel.HEADERR$, gm.getHeaderR());
            json.put(GeneralModel.FOOTERL$, gm.getFooterL());
            json.put(GeneralModel.FOOTERR$, gm.getFooterR());
            //json.put("stared", gm.getStared());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return json;
    }
}
