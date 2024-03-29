package util;

import model.*;
import oracle.jdbc.driver.Const;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by abiz on 4/19/2019.
 */

public class JsonUtil {


    public static JSONObject parseGM(GeneralModel gm) {
        JSONObject json = new JSONObject();
        try {
            json.put(Consts.ID, gm.getId());
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

    public static GeneralModel extractGM(JSONObject json) throws JSONException {
        GeneralModel generalModel = new GeneralModel();
        try {
            generalModel.setId(Long.valueOf(json.get(Consts.ID).toString()));
        } catch (JSONException e) {
        }
        try {
            generalModel.setTitle(json.get(GeneralModel.TITLE$).toString());
        } catch (JSONException e) {
        }
        try {
            generalModel.setHeaderL(json.get(GeneralModel.HEADERL$).toString());
        } catch (JSONException e) {
        }
        try {
            generalModel.setHeaderR(json.get(GeneralModel.HEADERR$).toString());
        } catch (JSONException e) {
        }
        try {
            generalModel.setBody(json.get(GeneralModel.BODY$).toString());
        } catch (JSONException e) {
        }
        try {
            generalModel.setFooterL(json.get(GeneralModel.FOOTERL$).toString());
        } catch (JSONException e) {
        }
        try {
            generalModel.setFooterR(json.get(GeneralModel.FOOTERR$).toString());
        } catch (JSONException e) {
        }
        return generalModel;
    }

    public static ArrayList<GeneralModel> extractGMs(JSONArray array) throws JSONException {
        ArrayList<GeneralModel> generalModels = new ArrayList<>();
        for (int i = 0; i < array.length(); i++) {
            generalModels.add(extractGM((JSONObject) array.get(i)));
        }
        return generalModels;
    }

    public static Confiq extractConfiq(JSONObject json) {
        Confiq confiq = new Confiq();
        try {
            confiq.setClearDB(json.getBoolean(Confiq.CLEARDB));
        } catch (Exception e) {
        }
        try {
            confiq.setUserId(json.getLong(Confiq.USERID));
        } catch (Exception e) {
        }
        try {
            confiq.setWait4Server(json.getInt(Confiq.WAIT4SERVER));
        } catch (Exception e) {
        }
        try {
            confiq.setConnectPeriod(json.getInt(Confiq.CONNECTPERIOD));
        } catch (Exception e) {
        }
        try {
            confiq.setLastMsgIsd(json.getLong(Confiq.LASTMSGID));
        } catch (Exception e) {
        }
        try {
            confiq.setUserName(json.getString(Confiq.USERNAME));
        } catch (Exception e) {
        }
        try {
            confiq.setHaveNewChange(json.getBoolean(Confiq.HAVENEWCHANGE));
        } catch (Exception e) {
        }
        try {
            confiq.setSendDetail(json.getBoolean(Consts.SENDDETAICONFIG));
        } catch (Exception e) {
        }
        try {
            confiq.setLastModelMapId(json.getLong(Confiq.LASTMODELMAPID));
        } catch (Exception e) {
        }
        try {
            JSONArray jsonArray = json.getJSONArray(Confiq.LASTMODELMAP);
            ArrayList<ModelMap> modelMaps = new ArrayList<>();
            for (int i = 0; i < jsonArray.length(); i++) {
                modelMaps.add(extractModelMap((JSONObject) jsonArray.get(i)));
            }
            confiq.setLastModelMap(modelMaps);
        } catch (Exception e) {
        }
        try {
            JSONArray jsonArray = json.getJSONArray(Confiq.TAGVISIBLITY);
            ArrayList<TagVisiblity> visiblities = new ArrayList<>();
            for (int i = 0; i < jsonArray.length(); i++) {
                visiblities.add(extractTagVisiblity((JSONObject) jsonArray.get(i)));
            }
            confiq.setTagVisiblity(visiblities);
        } catch (Exception e) {
        }
        try {
            JSONArray jsonArray = json.getJSONArray(Confiq.LASTTABLESNAME);
            ArrayList<String> list = new ArrayList<>();
            for (int i = 0; i < jsonArray.length(); i++) {
                list.add(jsonArray.getString(i));
            }
            confiq.setLastTablesName(list);
        } catch (Exception e) {
        }
        try {
            JSONArray jsonArray = json.getJSONArray(Confiq.LASTIDS);
            ArrayList<Long> list = new ArrayList<>();
            for (int i = 0; i < jsonArray.length(); i++) {
                list.add(jsonArray.getLong(i));
            }
            confiq.setLastIds(list);
        } catch (Exception e) {
        }
        try {
            JSONArray jsonArray = json.getJSONArray(Confiq.LASTGROUPIDS);
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < jsonArray.length(); i++) {
                list.add(jsonArray.getInt(i));
            }
            confiq.setLastGroupIds(list);
        } catch (Exception e) {
        }
        return confiq;
    }

    private static TagVisiblity extractTagVisiblity(JSONObject jsonObject) {
        TagVisiblity visiblity = null;
        try {
            visiblity = new TagVisiblity(jsonObject.getInt("TableId"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            visiblity.setBodyVisible(jsonObject.getBoolean(GeneralModel.BODY$));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            visiblity.setTitleVisible(jsonObject.getBoolean(GeneralModel.TITLE$));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            visiblity.setHeaderLVisible(jsonObject.getBoolean(GeneralModel.HEADERL$));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            visiblity.setHeaderRVisible(jsonObject.getBoolean(GeneralModel.HEADERR$));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            visiblity.setFooterLVisible(jsonObject.getBoolean(GeneralModel.FOOTERL$));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            visiblity.setFooterRVisible(jsonObject.getBoolean(GeneralModel.FOOTERR$));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            visiblity.setStarVisible(jsonObject.getBoolean(GeneralModel.STAR$));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            visiblity.setBodyString(jsonObject.getInt("S" + GeneralModel.BODY$));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            visiblity.setTitleString(jsonObject.getInt("S" + GeneralModel.TITLE$));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            visiblity.setHeaderLString(jsonObject.getInt("S" + GeneralModel.HEADERL$));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            visiblity.setHeaderRString(jsonObject.getInt("S" + GeneralModel.HEADERR$));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            visiblity.setFooterLString(jsonObject.getInt("S" + GeneralModel.FOOTERL$));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            visiblity.setFooterRString(jsonObject.getInt("S" + GeneralModel.FOOTERR$));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return visiblity;
    }

    public static ModelMap extractModelMap(JSONObject json) throws JSONException {
        ModelMap modelMap = new ModelMap();
        modelMap.setColumnIx(json.getInt(ModelMap.COLUMNIX));
        modelMap.setId(json.getInt(Consts.ID));
        modelMap.setIntValue(json.getInt(ModelMap.INTVALUE));
        modelMap.setStringValue(json.getString(ModelMap.STRINGVALUE));
        modelMap.setTableId(json.getInt(ModelMap.TABLEID));
        return modelMap;
    }

    private static JSONObject parseModelMap(ModelMap mm) {
        JSONObject json = new JSONObject();
        try {
            json.put(ModelMap.INTVALUE, mm.getIntValue());
            json.put(ModelMap.STRINGVALUE, mm.getStringValue());
            json.put(ModelMap.COLUMNIX, mm.getColumnIx());
            json.put(Consts.ID, mm.getId());
            json.put(ModelMap.TABLEID, mm.getTableId());
        } catch (JSONException e) {
        }
        return json;
    }

    public static JSONObject parseTagVisiblity(TagVisiblity visiblity) {
        JSONObject json = new JSONObject();
        try {
            json.put("TableId", visiblity.getTableId());
        } catch (JSONException e) {
        }
        try {
            json.put(GeneralModel.BODY$, visiblity.isBodyVisible());
        } catch (JSONException e) {
        }
        try {
            json.put(GeneralModel.TITLE$, visiblity.isTitleVisible());
        } catch (JSONException e) {
        }
        try {
            json.put(GeneralModel.HEADERL$, visiblity.isHeaderLVisible());
        } catch (JSONException e) {
        }
        try {
            json.put(GeneralModel.HEADERR$, visiblity.isHeaderRVisible());
        } catch (JSONException e) {
        }
        try {
            json.put(GeneralModel.FOOTERL$, visiblity.isFooterLVisible());
        } catch (JSONException e) {
        }
        try {
            json.put(GeneralModel.FOOTERR$, visiblity.isFooterRVisible());
        } catch (JSONException e) {
        }
        try {
            json.put(GeneralModel.STAR$, visiblity.isStarVisible());
        } catch (JSONException e) {
        }
        try {
            json.put("S" + GeneralModel.BODY$, visiblity.getBodyString());
        } catch (JSONException e) {
        }
        try {
            json.put("S" + GeneralModel.TITLE$, visiblity.getTitleString());
        } catch (JSONException e) {
        }
        try {
            json.put("S" + GeneralModel.HEADERL$, visiblity.getHeaderLString());
        } catch (JSONException e) {
        }
        try {
            json.put("S" + GeneralModel.HEADERR$, visiblity.getHeaderRString());
        } catch (JSONException e) {
        }
        try {
            json.put("S" + GeneralModel.FOOTERL$, visiblity.getFooterLString());
        } catch (JSONException e) {
        }
        try {
            json.put("S" + GeneralModel.FOOTERR$, visiblity.getFooterRString());
        } catch (JSONException e) {
        }
        return json;
    }

    public static JSONObject parseConfiq(Confiq confiq) {
        JSONObject json = new JSONObject();
        try {
            json.put(Confiq.HASUSERPERMISSION, confiq.getHasUserPermision());
        } catch (JSONException e) {
        }
        try {
            json.put(Confiq.HAVENEWCHANGE, confiq.getHaveNewChange());
        } catch (JSONException e) {
        }
        try {
            json.put(Consts.SENDDETAICONFIG, confiq.getSendDetail());
        } catch (JSONException e) {
        }
        try {
            json.put(Confiq.UPDATEGROUP, confiq.getUpdateGroup());
        } catch (JSONException e) {
        }
        try {
            json.put(Confiq.LASTIDS, new JSONArray(confiq.getLastIds()));
        } catch (JSONException e) {
        }
        try {
            json.put(Confiq.LASTGROUPIDS, new JSONArray(confiq.getLastGroupIds()));
        } catch (JSONException e) {
        }
        try {
            json.put(Confiq.MODELMAP2DELETE, new JSONArray(confiq.getModelMap2Delete()));
        } catch (JSONException e) {
        }
        if (confiq.getLastModelMap() != null)
            try {
                JSONArray array = new JSONArray();
                for (ModelMap mm : confiq.getLastModelMap()) {
                    array.put(parseModelMap(mm));
                }
                json.put(Confiq.LASTMODELMAP, array);
            } catch (JSONException e) {
            }
        try {
            json.put(Confiq.LASTTABLESNAME, new JSONArray(confiq.getLastTablesName()));
        } catch (JSONException e) {
        }
        try {
            json.put(Confiq.USERID, confiq.getUserId());
        } catch (JSONException e) {
        }
        try {
            json.put(Confiq.WAIT4SERVER, confiq.getWait4Server());
        } catch (JSONException e) {
        }
        try {
            json.put(Confiq.CONNECTPERIOD, confiq.getConnectPeriod());
        } catch (JSONException e) {
        }
        try {
            json.put(Confiq.LASTMSGID, confiq.getLastMsgIsd());
        } catch (JSONException e) {
        }
        try {
            json.put(Confiq.USERNAME, confiq.getUserName());
        } catch (JSONException e) {
        }
        try {
            json.put(Confiq.LASTMODELMAPID, confiq.getLastModelMapId());
        } catch (JSONException e) {
        }
        if (confiq.getTagVisiblity() != null && confiq.getTagVisiblity().size() > 0)
            try {
                JSONArray array = new JSONArray();
                for (TagVisiblity tv : confiq.getTagVisiblity()) {
                    array.put(parseTagVisiblity(tv));
                }
                json.put(Confiq.TAGVISIBLITY, array);
            } catch (JSONException e) {
            }
        return json;
    }


    public static UserAccount extractUserAccount(JSONObject reqJson) {
        UserAccount user = new UserAccount();
        try {
            user.setUserName(reqJson.get(Consts.USERNAME).toString());
        } catch (JSONException e) {
        }
        try {
            user.setId(Long.parseLong(reqJson.get(Consts.ID).toString()));
        } catch (JSONException e) {
        }
        try {
            user.setPassword(reqJson.get(Consts.PASSWORD).toString());
        } catch (JSONException e) {
        }
        try {
            user.setEmail(reqJson.get(Consts.EMAIL).toString());
        } catch (JSONException e) {
        }
        try {
            user.setPhone(reqJson.get(Consts.PHONE).toString());
        } catch (JSONException e) {
        }
        return user;
    }

    public static JSONObject parseUserAccount(UserAccount userAccount) {
        JSONObject json = new JSONObject();
        try {
            json.put(Consts.ID, userAccount.getId());
            json.put(Consts.USERNAME, userAccount.getUserName());
            json.put(Consts.PASSWORD, userAccount.getPassword());
            json.put(Consts.PHONE, userAccount.getPhone());
            json.put(Consts.EMAIL, userAccount.getEmail());
        } catch (JSONException e) {
        }
        return json;
    }


    public static ArrayList<Integer> extractGroupIds(JSONObject json, String status) throws JSONException {
        ArrayList<Integer> list = new ArrayList<>();
        JSONArray array = json.getJSONArray(status);
        for (int i = 0; i < array.length(); i++) {
            list.add(array.getInt(i));
        }
        return list;
    }

    public static ArrayList<Group> extractGroups(JSONArray array) throws JSONException {
        ArrayList<Group> groups = new ArrayList<>();
        for (int i = 0; i < array.length(); i++) {
            groups.add(extractGr((JSONObject) array.get(i)));
        }
        return groups;
    }


    private static Group extractGr(JSONObject json) {
        Group group = null;
        try {
            group = new Group(Integer.valueOf(json.get(Consts.TABLEID).toString()));
            group.setId(Integer.valueOf(json.get(Consts.ID).toString()));
        } catch (JSONException e) {
        }
        try {
            group.setName(json.get(Consts.NAME).toString());
        } catch (JSONException e) {
        }
        try {
            group.setStatus((Integer.valueOf(json.get(Consts.STATUS).toString())));
        } catch (JSONException e) {
        }
        return group;
    }

    public static JSONObject parseGr(Group gr) {
        JSONObject json = new JSONObject();
        try {
            json.put(Consts.ID, gr.getId());
            json.put(Consts.NAME, gr.getName());
            if (gr.getStatus() > 0)
                json.put(Consts.STATUS, gr.getStatus());
            json.put(Consts.TABLEID, gr.getTableId());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return json;
    }

    public static JSONArray parseMsgs(ArrayList<Message> messages) {
        JSONArray array = new JSONArray();
        for (Message message : messages) {
            array.put(parseMsg(message));
        }
        return array;
    }

    private static JSONObject parseMsg(Message message) {
        JSONObject json = new JSONObject();
        try {
            json.put(Consts.ID, message.getId());
            json.put("MSGID",message.getMsgId());
            json.put("BODY", message.getBody());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return json;
    }

    public static ArrayList<Message> extractReceiptMsg(JSONObject json) {
        ArrayList<Message> list = new ArrayList<>();
        try {
            JSONArray array = json.getJSONArray(Consts.MESSAGELIST);
            for (int i = 0; i < array.length(); i++) {
                JSONObject object = (JSONObject) array.get(i);
                Message msg = new Message();
                msg.setMsgId(object.getLong(Consts.ID));
                msg.setBody(object.get("BODY").toString());
                list.add(msg);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static ArrayList<Integer> extractReceiptMsgIds(JSONObject json) {
        ArrayList<Integer> list = new ArrayList<>();
        try {
            JSONArray array = json.getJSONArray(Message.MSGIDS);
            for (int i = 0; i < array.length(); i++) {
                list.add(array.getInt(i));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }

}
