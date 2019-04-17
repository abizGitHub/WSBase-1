package ws;




import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/json")
public class GetJsonOb {

    @GET
    @Path("/getText/{ix}")
    @Produces("text/plain")
    public Response getFileT(@PathParam("ix") String s) {
        System.out.println("***");
        Response.ResponseBuilder response = Response.ok(new String("ix>"+s));
        response.header("Content-Disposition","attachment; filename=\"javatpoint_pdf.txt\"");
        return response.build();
    }

    @GET
    @Path("/getJson/{ix}")
    @Produces(MediaType.APPLICATION_JSON)
    public JSONObject getFileJ(@PathParam("ix") String s) {
        System.out.println("***>"+s);
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("s",new String("is_string>>"+s));
            jsonObject.put("i",37);
            jsonObject.put("l",39865447L);
        } catch (JSONException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return jsonObject;
    }


    @POST
    @Path("/postJson")
    @Consumes(MediaType.APPLICATION_JSON)
    public void setFileJ(JSONObject object) {
        System.out.println("@@@>"+object);
    }

    @POST
    @Path("/CompleXPost/{ix}/X/{iy}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public JSONObject getFileJ_Res(JSONObject object, @PathParam("ix") String ix, @PathParam("iy") String iy) {
        System.out.println("str:"+ix+" and "+iy+",Object:"+object);
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("s",new String("s in param is:"+ix+" and "+iy+" , in body is:"+object.get("s")));
            jsonObject.put("i*66_from_Json",(Integer)object.get("i")*66);
            jsonObject.put("l",39865447L);
        } catch (JSONException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return jsonObject;
    }

}