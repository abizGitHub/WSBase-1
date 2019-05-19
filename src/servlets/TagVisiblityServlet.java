package servlets;

import model.TagVisiblity;
import model.UserAccountLog;
import service.ServiceFactory;
import service.ServiceImpl;
import util.Consts;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

@WebServlet("/tagVisiblity.do")
public class TagVisiblityServlet extends HttpServlet {

    ServiceImpl<TagVisiblity, TagVisiblity> manager;

    @Override
    public void init() throws ServletException {
        manager = ServiceFactory.getInstance().o().get(TagVisiblity.class);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter(Consts.METHOD) != null && req.getParameter(Consts.METHOD).equalsIgnoreCase("update")) {
            update(req);
            resp.sendRedirect("/tagVisiblity.do");
            return;
        }
        /*System.out.println(">>"+req.getParameter("t"));
        req.setAttribute("t", req.getParameter("t"));
        req.getRequestDispatcher("/tagVisiblity.jsp").forward(req, resp);*/
        ArrayList<TagVisiblity> list = manager.loadAll();
        req.setAttribute("list", list);
        req.getRequestDispatcher("/tagVisiblity.jsp").forward(req, resp);
    }

    private void update(HttpServletRequest req) {

        TagVisiblity vis = new TagVisiblity(Integer.parseInt(req.getParameter("tableId")));
        vis.setStarVisible(req.getParameter("starVisible").equals("true"));
        vis.setTitleVisible(req.getParameter("titleVisible").equals("true"));
        vis.setBodyVisible(req.getParameter("bodyVisible").equals("true"));
        vis.setHeaderRVisible(req.getParameter("headerRVisible").equals("true"));
        vis.setHeaderLVisible(req.getParameter("headerLVisible").equals("true"));
        vis.setFooterRVisible(req.getParameter("footerRVisible").equals("true"));
        vis.setFooterLVisible(req.getParameter("footerLVisible").equals("true"));
        vis.setTitleString(req.getParameter("titleString").equals("true"));
        vis.setBodyString(req.getParameter("bodyString").equals("true"));
        vis.setHeaderRString(req.getParameter("headerRString").equals("true"));
        vis.setHeaderLString(req.getParameter("headerLString").equals("true"));
        vis.setFooterRString(req.getParameter("footerRString").equals("true"));
        vis.setFooterLString(req.getParameter("footerLString").equals("true"));
        vis.setId(Long.parseLong(req.getParameter("id")));
        manager.save(vis);
    }

}
