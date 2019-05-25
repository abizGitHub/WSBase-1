package servlets;

import model.TableTag;
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
        ArrayList<TagVisiblity> list = manager.loadAll();
        req.setAttribute("list", list);
        ArrayList<TableTag> tableTags = manager.tableTags();
        req.setAttribute("tableTags", tableTags);
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
        vis.setTitleString(Integer.parseInt(req.getParameter("titleString")));
        vis.setBodyString(Integer.parseInt(req.getParameter("bodyString")));
        vis.setHeaderRString(Integer.parseInt(req.getParameter("headerRString")));
        vis.setHeaderLString(Integer.parseInt(req.getParameter("headerLString")));
        vis.setFooterRString(Integer.parseInt(req.getParameter("footerRString")));
        vis.setFooterLString(Integer.parseInt(req.getParameter("footerLString")));
        vis.setId(Long.parseLong(req.getParameter("id")));
        manager.save(vis);
    }

}
