package ws;

import model.Confiq;
import model.Message;
import model.UserAccount;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import service.ServiceFactory;
import service.ServiceImpl;
import util.Consts;
import util.JsonUtil;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

@Path("/msg")
public class MessageController {

    ServiceImpl<UserAccount, UserAccount> managerUserAccount;
    ServiceImpl<Message, Message> managerMessage;

    public MessageController() {
        managerUserAccount = ServiceFactory.getInstance().o().get(UserAccount.class);
        managerMessage = ServiceFactory.getInstance().o().get(Message.class);
    }

    @POST
    @Path("/send")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public JSONObject sentByClient(String strReq) {
        System.out.println("Reg>" + strReq);
        JSONObject jsonResponse = new JSONObject();
        ArrayList<Long> delivered = new ArrayList<>();
        try {
            JSONObject object = new JSONObject(strReq);
            Confiq reqCnf = JsonUtil.extractConfiq(object);
            UserAccount loaded = managerUserAccount.findById(reqCnf.getUserId());
            if (loaded != null && loaded.getUserName().equals(reqCnf.getUserName())) {
                ArrayList<Message> messages = JsonUtil.extractReceiptMsg(object);
                for (Message message : messages) {
                    message.setType(Message.RECEIPT);
                    message.setRegisterDate(new Date());
                    message.setUserAccountId(loaded.getId());
                    managerMessage.save(message);
                    delivered.add(message.getMsgId());
                }
                jsonResponse.put(Message.MSGIDS, new JSONArray(delivered));
            } else return jsonResponse;

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonResponse;
    }

    @POST
    @Path("/receive")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public JSONObject sentToClient(String strReq) {
        System.out.println("Reg>" + strReq);
        JSONObject jsonResponse = new JSONObject();
        try {
            JSONObject object = new JSONObject(strReq);
            Confiq reqCnf = JsonUtil.extractConfiq(object);
            UserAccount loaded = managerUserAccount.findById(reqCnf.getUserId());
            if (loaded != null && loaded.getUserName().equals(reqCnf.getUserName())) {
                HashMap<String, Object> filter = new HashMap<>();
                filter.put(Consts.USERACCOUNTID, loaded.getId());
                filter.put("type", Message.SENT);
                ArrayList<Message> messages = managerMessage.findByFilterAndQuery(filter, " and id > " + reqCnf.getLastMsgIsd());
                for (Message message : messages) {
                    message.setMsgId(message.getId());
                }
                jsonResponse.put(Consts.MESSAGELIST, JsonUtil.parseMsgs(messages));
                for (Message message : messages) {
                    message.setDelivered(true);
                    managerMessage.save(message);
                }
            } else return jsonResponse;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonResponse;
    }

}
