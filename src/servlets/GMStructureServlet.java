package servlets;

import model.GMStruct;
import service.ServiceFactory;
import service.ServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/gmStructure.do")
public class GMStructureServlet extends HttpServlet {

    ServiceImpl<GMStruct, GMStruct> manager;

    @Override
    public void init() throws ServletException {
        manager = ServiceFactory.getInstance().o().get(GMStruct.class);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("id") != null) {
            update(req);
            resp.sendRedirect("gmStructure.do");
            return;
        }
        ArrayList<GMStruct> list = manager.loadAll();
        req.setAttribute("list", list);
        req.getRequestDispatcher("/gmStructure.jsp").forward(req, resp);
    }

    private void update(HttpServletRequest req) {
        GMStruct struct = manager.findById(Long.parseLong(req.getParameter("id")));
        struct.setTableName(req.getParameter("tableName").trim());
        struct.setTitle(req.getParameter("title").trim());
        struct.setHeaderL(req.getParameter("headerL").trim());
        struct.setHeaderR(req.getParameter("headerR").trim());
        struct.setBody(req.getParameter("body").trim());
        struct.setFooterL(req.getParameter("footerL").trim());
        struct.setFooterR(req.getParameter("footerR").trim());
        manager.save(struct);
    }

}
