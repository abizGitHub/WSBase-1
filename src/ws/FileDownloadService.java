package ws;


import model.UserAccount;
import model.UserAccountLog;
import moz.model.Auction;
import moz.model.AuctionView;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import service.ServiceFactory;
import service.ServiceImpl;
import util.AppConfig;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import java.io.File;

@Path("/files")
public class FileDownloadService {

    private static final String FILE_PATH = "C:\\Users\\abiz\\Desktop\\sun";
    ServiceImpl<UserAccountLog, UserAccountLog> managerUserAccountLog;
    ServiceImpl<UserAccount, UserAccount> managerUserAccount;
    ServiceImpl<Auction, AuctionView> managerAuction;

    public FileDownloadService() {
        managerUserAccountLog = ServiceFactory.getInstance().o().get(UserAccountLog.class);
        managerUserAccount = ServiceFactory.getInstance().o().get(UserAccount.class);
        managerAuction = ServiceFactory.getInstance().o().get(Auction.class);
    }

    @POST
    @Path("/pdf")
    @Produces("application/pdf")
    public Response getPFile(JSONObject address) {
        File file = null;
        System.out.println(address);
        try {
            file = new File((String) address.get("address")); //  FILE_PATH
        } catch (JSONException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        ResponseBuilder response = Response.ok(file);
        response.header("Content-Disposition", "attachment; filename=\"p.pdf\"");
        return response.build();
    }

    @POST
    @Path("/jpg")
    @Produces("image/jpg")
    public Response getIFile(JSONObject address) {
        File file = null;
        try {
            file = new File((String) address.get("address")); //  FILE_PATH
        } catch (JSONException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        ResponseBuilder response = Response.ok(file);
        response.header("Content-Disposition", "attachment; filename=\"j.jpg\"");
        return response.build();
    }

    @GET
    @Path("/img/{ix}")
    @Produces("image/jpg")
    public Response getTestImFile(@PathParam("ix") String s) {
        File file = null;
        file = new File((String) FILE_PATH + "/" + s); //  FILE_PATH
        ResponseBuilder response = Response.ok(file);
        response.header("Content-Disposition", "attachment; filename=\"j.jpg\"");
        return response.build();
    }


    @GET
    @Path("/1105-4377-6091-8714/{tableIx}/{userId}/{rnd}/{id}/{userName}")
    @Produces("image/jpg")
    public Response getImFile(@PathParam("tableIx") String tableIx,
                              @PathParam("userId") String userId,
                              @PathParam("rnd") String rnd,
                              @PathParam("userName") String userName,
                              @PathParam("id") String id) {

        Long idL = Long.parseLong(id);
        Auction auction = managerAuction.findById(idL);
        Long grId = auction.getBuTitle();
        File file = new File(AppConfig.filePath() + "/gr_" + grId + "/img_" + id + ".jpg");
        ResponseBuilder response = Response.ok(file);
        response.header("Content-Disposition", "attachment; filename=\"j.jpg\"");
        return response.build();
    }

}