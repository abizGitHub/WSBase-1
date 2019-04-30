package ws;


import model.Confiq;
import model.GeneralModel;
import model.ModelMap;
import model.TagVisiblity;
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
        JSONObject jsonConfiqReq;
        JSONObject jsonResponse = new JSONObject();
        try {
            jsonConfiqReq = new JSONObject(strReq);
            Confiq confiq = JsonUtil.extractConfiq(jsonConfiqReq);
            confiq.setUserName("newSeen");
            ArrayList<Long> list = GeneralServiceImpl.getInstance().getLastGeneralIds();
            confiq.setLastIds(list);
            confiq.setHaveNewChange(true);
            ArrayList<String> names = new ArrayList<>();
            names.add("ttqq1");
            names.add("ujhyew");
            confiq.setLastTablesName(names);
            ArrayList<TagVisiblity> tagV = new ArrayList<>();
            tagV.add(new TagVisiblity().fillMock());
            tagV.add(new TagVisiblity().fillMock().doStarVisible(true));
            confiq.setLastModelMap(GeneralServiceImpl.getInstance().getModelMapAfter(confiq.getLastModelMapId()));
            confiq.setModelMap2Delete(GeneralServiceImpl.getInstance().getModelMap2DeleteAfter(confiq.getLastModelMapId()));
            confiq.setTagVisiblity(tagV);
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