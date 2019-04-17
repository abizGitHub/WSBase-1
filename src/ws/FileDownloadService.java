package ws;




import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import java.io.File;

@Path("/files")
public class FileDownloadService {
 	private static final String FILE_PATH = "C:\\Users\\Abiz\\Desktop\\DB\\13_23Apr07.pdf";
 
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
		response.header("Content-Disposition","attachment; filename=\"p.pdf\"");
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
        response.header("Content-Disposition","attachment; filename=\"j.jpg\"");
        return response.build();
    }


}