package ws;


import cash.Cash;
import model.Confiq;
import model.GeneralModel;
import model.ModelMap;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import service.GeneralServiceImpl;
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
        ArrayList<GeneralModel> list = GeneralServiceImpl.getInstance().getTestGeneralList();
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
    public JSONObject getConfiq(String strReq) {
        System.out.println("@@@>" + strReq);
        JSONObject jsonResponse = new JSONObject();
        try {
            Confiq confiq = Cash.o().getConfiq();
            Confiq reqCnf = JsonUtil.extractConfiq(new JSONObject(strReq));
            ArrayList<Long> list = GeneralServiceImpl.getInstance().getLastGeneralIds();
            confiq.setLastIds(list);
            confiq.setLastModelMap(GeneralServiceImpl.getInstance().getModelMapAfter(reqCnf.getLastModelMapId()));
            confiq.setModelMap2Delete(GeneralServiceImpl.getInstance().getModelMap2DeleteAfter(reqCnf.getLastModelMapId()));
            ArrayList<Integer> gIds = new ArrayList<>();
            gIds.add(1);
            gIds.add(1);
            confiq.setLastGroupIds(gIds);
            confiq.setUpdateGroup(true);
            confiq.setConnectPeriod(2444);// ms
            confiq.setSendDetail(false);
            JSONObject c = JsonUtil.parseConfiq(confiq);
            jsonResponse.put("confiq", c);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonResponse;
    }

    @POST
    @Path("/{tableIx}/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.TEXT_PLAIN)
    public JSONObject getGMTable(String str, @PathParam("tableIx") Integer tableIx, @PathParam("id") Long id) {
        System.out.println("str:" + tableIx + " and " + id + ",Object:" + str);
        JSONObject jsonObject = new JSONObject();
        JSONArray array = new JSONArray();
        ArrayList<GeneralModel> list = GeneralServiceImpl.getInstance().getGeneralListAfter(tableIx, id);
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


    public static void main(String[] args) {
        ArrayList<ModelMap> modelMapAfter = GeneralServiceImpl.getInstance().getModelMapAfter(0L);
        System.out.println("ColumnIx  -  IntValue  -  StringValue  -  IdDelete");
        for (ModelMap modelMap : modelMapAfter) {
            System.out.println(modelMap);
        }
        System.err.println("==================================");
        ArrayList<GeneralModel> generalListAfter = GeneralServiceImpl.getInstance().getGeneralListAfter(1, 0L);
        for (GeneralModel generalModel : generalListAfter) {
            System.out.println(generalModel);
        }

    }


}