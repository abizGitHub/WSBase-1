package ws;


import model.Group;
import model.UserAccount;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import util.Consts;
import util.JsonUtil;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.HashMap;

@Path("/userAccount")
public class UserAccountController {

    static HashMap<Integer, Group> groupsHash;

    static {
        groupsHash = new HashMap<>();
        groupsHash.put(69, new Group(2).fillMock(69));
        groupsHash.put(50, new Group(1).fillMock(50));
        groupsHash.put(47, new Group(1).fillMock(47));
        groupsHash.put(33, new Group(2).fillMock(33));
        groupsHash.put(17, new Group(2).fillMock(17));
        groupsHash.put(8, new Group(2).fillMock(8));
        groupsHash.put(3, new Group(2).fillMock(3));
        groupsHash.put(4, new Group(1).fillMock(4));
    }


    @POST
    @Path("/registerUser")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public JSONObject registerUser(String strReq) {
        System.out.println("Reg>" + strReq);
        JSONObject jsonResponse = new JSONObject();
        try {
            UserAccount user = JsonUtil.extractUserAccount(new JSONObject(strReq));
            System.out.println("register:" + user.getUserName() + "," + user.getPassword() + "," + user.getPhone() + "," + user.getEmail());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(999);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            jsonResponse.put("response", Consts.USERREGISTERED);
            jsonResponse.put("id", 17360439);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonResponse;
    }


    @POST
    @Path("/updateUser")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public JSONObject updateUser(String strReq) {
        System.out.println("update>" + strReq);
        JSONObject jsonObject = new JSONObject();
        try {
            UserAccount user = JsonUtil.extractUserAccount(new JSONObject(strReq));
            System.out.println("updatedUser:" + user.getUserName() + "," + user.getPassword() + "," + user.getPhone() + "," + user.getEmail());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            Thread.sleep(999);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            jsonObject.put("response", Consts.USERREGISTERED);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    @POST
    @Path("/groups/{ix}")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public JSONObject getGroups(String strReq, @PathParam("ix") Integer tableIx) {
        JSONObject jsonObject = new JSONObject();
        System.out.println("ix:" + tableIx + " groups>" + strReq);
        try {
            JSONObject reqJson = new JSONObject(strReq);
            ArrayList<Integer> reqRegisterGroup = JsonUtil.extractGroupIds(reqJson, Group.REGISTERED$);
            ArrayList<Integer> reqOrderGroup = JsonUtil.extractGroupIds(reqJson, Group.ORDERED$);
            applyOrderGroup(reqOrderGroup, reqRegisterGroup);
            JSONArray array = new JSONArray();
            for (Integer id : groupsHash.keySet()) {
                array.put(JsonUtil.parseGr(groupsHash.get(id)));
            }
            jsonObject.put("groupList", array);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }


    private static void applyOrderGroup(ArrayList<Integer> reqOrderGroup, ArrayList<Integer> reqRegisterGroup) {
        for (Integer id : reqOrderGroup) {
            groupsHash.get(id).setStatus(Group.REGISTERED);
        }
        for (Integer id : reqRegisterGroup) {
            groupsHash.get(id).setStatus(Group.REGISTERED);
        }
    }

}
