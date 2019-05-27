package ws;

import model.*;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import service.GeneralServiceImpl;
import service.ServiceFactory;
import service.ServiceImpl;
import servlets.PortalServlet;
import util.Consts;
import util.Convert2Json;
import util.JsonUtil;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;

@Path("/gm")
public class GetGeneralModel {

    ServiceImpl<UserAccountLog, UserAccountLog> managerUserAccountLog;
    ServiceImpl<UserAccount, UserAccount> managerUserAccount;
    ServiceImpl<TagVisiblity, TagVisiblity> managerTagVisiblity;
    ServiceImpl<ModelMap, ModelMap> managerModelMap;
    ServiceImpl<Group, Group> managerGroup;
    ServiceImpl<UserToGroup, UserToGroupView> managerUserToGroup;
    ServiceImpl<Message, Message> managerMessage;

    public GetGeneralModel() {
        managerUserAccountLog = ServiceFactory.getInstance().o().get(UserAccountLog.class);
        managerUserAccount = ServiceFactory.getInstance().o().get(UserAccount.class);
        managerTagVisiblity = ServiceFactory.getInstance().o().get(TagVisiblity.class);
        managerModelMap = ServiceFactory.getInstance().o().get(ModelMap.class);
        managerGroup = ServiceFactory.getInstance().o().get(Group.class);
        managerUserToGroup = ServiceFactory.getInstance().o().get(UserToGroup.class);
        managerMessage = ServiceFactory.getInstance().o().get(Message.class);
    }


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
            Confiq reqCnf = JsonUtil.extractConfiq(new JSONObject(strReq));
            UserAccount loaded = managerUserAccount.findById(reqCnf.getUserId());
            Confiq confiq = new Confiq();
            if (loaded != null) {
                confiq.setHasUserPermision(true);
                HashMap<String, Object> filter = new HashMap<>();
                filter.put("userAccountId", loaded.getId());
                Boolean hasPermission = managerUserAccountLog.findLastByFilter(filter).getHasPermission();
                confiq.setHasUserPermision(hasPermission);
                confiq.setConnectPeriod(PortalServlet.portalConfiq.getConnectPeriod());
                confiq.setWait4Server(PortalServlet.portalConfiq.getWait4Server());
                confiq.setHaveNewChange(PortalServlet.portalConfiq.getHaveNewChange());
                filter.put("type", Message.SENT);
                Message lastMsg = managerMessage.findLastByFilter(filter);
                if (lastMsg != null)
                    confiq.setLastMsgIsd(lastMsg.getId());
            } else if (reqCnf.getUserId() == Consts.NEWUSERID) {
                if (reqCnf.getUserName() == null || !reqCnf.getUserName().contains("-"))
                    return jsonResponse;
                AtomicLong x = new AtomicLong(Long.parseLong(reqCnf.getUserName().split("-")[1]));
                if (x.get() == 0 || x.get() % (7) != 0)
                    return jsonResponse;
                x.set(Long.parseLong(reqCnf.getUserName().split("-")[2]));
                if (x.get() == 0 || x.get() % (13) != 0)
                    return jsonResponse;
                HashMap<String, Object> filter = new HashMap<>();
                filter.put("userName", reqCnf.getUserName());
                ArrayList<UserAccount> loadByUserName = managerUserAccount.findByFilter(filter);
                confiq.setUserName(reqCnf.getUserName());
                if (loadByUserName == null || loadByUserName.isEmpty())
                    registerNewUser(confiq);
                else
                    System.err.println("repeated : " + reqCnf.getUserName());
                confiq.setHaveNewChange(true);
            } else return jsonResponse;
            confiq.setTagVisiblity(managerTagVisiblity.loadAll());
            confiq.setSendDetail(PortalServlet.portalConfiq.getSendDetail());
            confiq.setLastTablesName(PortalServlet.portalConfiq.getLastTableNames());
            confiq.setUpdateGroup(PortalServlet.portalConfiq.getUpdateGroup());
            confiq.setLastIds(PortalServlet.portalConfiq.getLastIds());
            confiq.setLastModelMap(GeneralServiceImpl.getInstance().getModelMapAfter(reqCnf.getLastModelMapId()));
            confiq.setModelMap2Delete(GeneralServiceImpl.getInstance().getModelMap2DeleteAfter(reqCnf.getLastModelMapId()));
            confiq.setLastGroupIds(PortalServlet.portalConfiq.getLastGrIds());
            JSONObject c = JsonUtil.parseConfiq(confiq);
            System.err.println(c.toString());
            jsonResponse.put("confiq", c);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonResponse;
    }

    private void registerNewUser(Confiq confiq) {
        UserAccount user = new UserAccount();
        user.setUserName(confiq.getUserName());
        long userId = managerUserAccount.save(user);
        managerUserAccountLog.save(new UserAccountLog(user, UserAccountLog.FIRSTRUN));
        confiq.setUserId(userId);
    }

    @POST
    @Path("/{tableIx}/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.TEXT_PLAIN)
    public JSONObject getGMTable(String str, @PathParam("tableIx") Integer tableIx, @PathParam("id") Long id) {
        System.out.println("str:" + tableIx + " and " + id + ",Object:" + str);
        JSONObject jsonObject = new JSONObject();
        JSONArray array = new JSONArray();
        ArrayList<GeneralModel> list = managerUserAccount.generalModelAfter(tableIx, id);
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