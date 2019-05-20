package ws;


import model.*;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import service.ServiceFactory;
import service.ServiceImpl;
import util.Consts;
import util.JsonUtil;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.HashMap;

@Path("/userAccount")
public class UserAccountController {

    ServiceImpl<UserAccountLog, UserAccountLog> managerUserAccountLog;
    ServiceImpl<UserAccount, UserAccount> managerUserAccount;
    ServiceImpl<TagVisiblity, TagVisiblity> managerTagVisiblity;
    ServiceImpl<ModelMap, ModelMap> managerModelMap;
    ServiceImpl<Group, Group> managerGroup;
    ServiceImpl<UserToGroup, UserToGroupView> managerUserToGroup;

    public UserAccountController() {
        managerUserAccountLog = ServiceFactory.getInstance().o().get(UserAccountLog.class);
        managerUserAccount = ServiceFactory.getInstance().o().get(UserAccount.class);
        managerTagVisiblity = ServiceFactory.getInstance().o().get(TagVisiblity.class);
        managerModelMap = ServiceFactory.getInstance().o().get(ModelMap.class);
        managerGroup = ServiceFactory.getInstance().o().get(Group.class);
        managerUserToGroup = ServiceFactory.getInstance().o().get(UserToGroup.class);
    }

    @POST
    @Path("/registerUser")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public JSONObject registerUser(String strReq) {
        System.out.println("Reg>" + strReq);
        try {
            UserAccount user = JsonUtil.extractUserAccount(new JSONObject(strReq));
            UserAccount loaded = loadUserByName(user.getUserName());
            if (loaded != null) {
                if (user.getPassword() != null && loaded.getPassword() != null) {
                    if (user.getPassword().equals(loaded.getPassword())) {
                        managerUserAccountLog.save(new UserAccountLog(loaded, UserAccountLog.REVIVED));
                        return putResponse(Consts.USERNAMEREVIVED, 0);
                    } else {
                        return putResponse(Consts.USERNAMERESERVED, 0);
                    }
                }
            } else {
                System.out.println("register:" + user.getUserName() + "," + user.getPassword() + "," + user.getPhone() + "," + user.getEmail());
                try {
                    long userId = managerUserAccount.save(user);
                    managerUserAccountLog.save(new UserAccountLog(user, UserAccountLog.REGISTERED));
                    return putResponse(Consts.USERREGISTERED, userId);
                } catch (Exception e) {
                    e.printStackTrace();
                    return putResponse(Consts.CANTREGISTERE, 0);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return putResponse(Consts.CANTREGISTERE, 0);
    }

    private UserAccount loadUserByName(String userName) {
        HashMap<String, Object> filter = new HashMap<>();
        filter.put("userName", userName);
        ArrayList<UserAccount> loaded = managerUserAccount.findByFilter(filter);
        if (loaded != null && loaded.size() > 0)
            return loaded.get(0);
        return null;
    }

    private JSONObject putResponse(int userregistered, long userId) {
        JSONObject jsonResponse = new JSONObject();
        try {
            jsonResponse.put("response", userregistered);
            jsonResponse.put("id", userId);
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
        try {
            UserAccount user = JsonUtil.extractUserAccount(new JSONObject(strReq));
            boolean valid = (user.getUserName() != null && user.getUserName().trim().length() > 1);
            valid &= (user.getId() > 0 && user.getPassword() != null && user.getPassword().trim().length() > 1);
            if (valid) {
                UserAccount loaded = managerUserAccount.findById(user.getId());
                if (loaded.getUserName().equals(user.getUserName())) {
                    managerUserAccount.save(user);
                    managerUserAccountLog.save(new UserAccountLog(user, UserAccountLog.USERUPDATED));
                    System.out.println("updatedUser:" + user.getUserName() + "," + user.getPassword() + "," + user.getPhone() + "," + user.getEmail());
                    return putResponse(Consts.USERREGISTERED, user.getId());
                } else {
                    return putResponse(Consts.CANTREGISTERE, 0);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return putResponse(Consts.CANTREGISTERE, 0);
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
            Confiq reqCnf = JsonUtil.extractConfiq(reqJson);
            UserAccount loadedUser = null;
            if (reqCnf.getUserId() != null) loadedUser = managerUserAccount.findById(reqCnf.getUserId());
            if (loadedUser != null && loadedUser.getUserName().equals(reqCnf.getUserName())) {
                JSONArray array = new JSONArray();
                HashMap<String, Object> filter = new HashMap<>();
                filter.put("tableId", tableIx);
                ArrayList<Group> groups = managerGroup.findByFilter(filter);
                for (Group group : groups) {
                    array.put(JsonUtil.parseGr(group));
                }
                ArrayList<Integer> orderList = loadGroupForUserByStatus(loadedUser.getId(), Group.ORDERED, tableIx);
                ArrayList<Integer> registerList = loadGroupForUserByStatus(loadedUser.getId(), Group.REGISTERED, tableIx);
                jsonObject.put(Group.ORDERED$, orderList);
                jsonObject.put(Group.REGISTERED$, registerList);
                jsonObject.put("groupList", array);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    private ArrayList<Integer> loadGroupForUserByStatus(long id, int status, Integer tableIx) {
        HashMap<String, Object> filter = new HashMap<>();
        filter.put("userAccountId", id);
        filter.put("status", status);
        filter.put("tableId", tableIx);
        ArrayList<UserToGroupView> list = managerUserToGroup.findViewByFilter(filter);
        ArrayList<Integer> ints = new ArrayList<>();
        for (UserToGroupView userToGroup : list) {
            ints.add(Math.toIntExact(userToGroup.getGroupId()));
        }
        return ints;
    }

    @POST
    @Path("/orderGroup")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public JSONObject orderGroup(String strReq) {
        JSONObject jsonObject = new JSONObject();
        System.out.println( "groups>" + strReq);
        try {
            JSONObject reqJson = new JSONObject(strReq);
            Confiq reqCnf = JsonUtil.extractConfiq(reqJson);
            UserAccount loadedUser = managerUserAccount.findById(reqCnf.getUserId());
            if (loadedUser != null && loadedUser.getUserName().equals(reqCnf.getUserName())) {
                ArrayList<Integer> reqOrderGroup = JsonUtil.extractGroupIds(reqJson, Group.ORDERED$);
                if (reqOrderGroup != null && reqOrderGroup.size() > 0)
                    try {
                        orderGroupsForUser(reqOrderGroup, loadedUser.getId());
                    } catch (Exception e) {
                        e.printStackTrace();
                        jsonObject.put("response", 0);
                        return jsonObject;
                    }
                jsonObject.put("response", Group.ORDERED$);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    private void orderGroupsForUser(ArrayList<Integer> reqOrderGroup, long userId) {
        HashMap<String, Object> filter = new HashMap<>();
        for (Integer ord : reqOrderGroup) {
            filter.put("userAccountId", userId);
            filter.put("groupId", ord);
            ArrayList<UserToGroup> list = managerUserToGroup.findByFilter(filter);
            if (list != null && list.size() > 0) {
                //  alreadyExist
            } else {
                UserToGroup userToGroup = new UserToGroup();
                userToGroup.setGroupId(Long.valueOf(ord));
                userToGroup.setUserAccountId(userId);
                userToGroup.setStatus(Group.ORDERED);
                managerUserToGroup.save(userToGroup);
            }
        }
    }

}
