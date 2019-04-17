package ws;


import model.GeneralModel;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import service.GeneralService;
import util.Convert2Json;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

@Path("/gm")
public class GetGeneralModel {

    @GET
    @Path("/getTestGeneralList")
    @Produces(MediaType.APPLICATION_JSON)
    public JSONObject getAllMon() {
        System.err.println("/rest/gm/getTestGeneralList   called");
        JSONObject jsonObject = new JSONObject();
        JSONArray array = new JSONArray();
        ArrayList<GeneralModel> list = GeneralService.getInstance().getTestGeneralList();
        for (GeneralModel gm : list) {
            array.put(Convert2Json.parseGM(gm));
        }
        try {
            jsonObject.put("dataList", array);
        } catch (JSONException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return jsonObject;
    }


    @POST
    @Path("/postJson")
    @Consumes(MediaType.APPLICATION_JSON)
    public void setFileJ(JSONObject object) {
        System.out.println("@@@>" + object);
    }

    @POST
    @Path("/CompleXPost/{ix}/X/{iy}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public JSONObject getFileJ_Res(JSONObject object, @PathParam("ix") String ix, @PathParam("iy") String iy) {
        System.out.println("str:" + ix + " and " + iy + ",Object:" + object);
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("s", new String("s in param is:" + ix + " and " + iy + " , in body is:" + object.get("s")));
            jsonObject.put("i*66_from_Json", (Integer) object.get("i") * 66);
            jsonObject.put("l", 39865447L);
        } catch (JSONException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return jsonObject;
    }
}