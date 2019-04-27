package ws;


import model.Confiq;
import model.GeneralModel;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import service.GeneralService;
import util.Convert2Json;
import util.JsonUtil;

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
    @Path("/getConfiq")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public JSONObject getConfiq(String str) {
        System.out.println("@@@>" + str);
        JSONObject confiqJ;
        JSONObject jsonObject = new JSONObject();
        try {
            confiqJ = new JSONObject(str);
            Confiq confiq = JsonUtil.extractConfiq(confiqJ);
            confiq.setUserName("newSeen");
            ArrayList<Long> list = new ArrayList<>();
            list.add(1L);
            list.add(1L);
            confiq.setLastIds(list);
            JSONObject c = JsonUtil.parseConfiq(confiq);
            jsonObject.put("confiq", c);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    @POST
    @Path("/{tableIx}/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.TEXT_PLAIN)
    public JSONObject getGMTable(String str, @PathParam("tableIx") String tableIx, @PathParam("id") String id) {
        System.out.println("str:" + tableIx + " and " + id + ",Object:" + str);
        return getAllMon();
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