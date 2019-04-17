package ws;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Abiz
 * Date: 2/22/18
 * Time: 8:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class Moservlet extends HttpServlet{

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("---------- http://localhost:8085/x/* >> Moservlet Called-------------");
        resp.getWriter().println(" this is Moservlet : this note written in \"response.writer\" !");
    }
}
