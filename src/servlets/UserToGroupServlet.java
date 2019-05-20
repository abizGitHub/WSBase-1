package servlets;

import model.Group;
import model.UserToGroup;
import model.UserToGroupView;
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


@WebServlet("/userToGroup.do")
public class UserToGroupServlet extends HttpServlet {

    ServiceImpl<UserToGroup, UserToGroupView> manager;

    @Override
    public void init() throws ServletException {
        manager = ServiceFactory.getInstance().o().get(UserToGroup.class);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String register = req.getParameter("register");
        if (register != null && register.length() > 0) {
            UserToGroup loaded = manager.findById(Long.parseLong(register));
            loaded.setStatus(Group.REGISTERED);
            manager.save(loaded);
            resp.sendRedirect("/userToGroup.do?" + Consts.USERACCOUNTID + "=" + req.getParameter(Consts.USERACCOUNTID));
            return;
        }

        HashMap filter = new HashMap<String, Long>();
        filter.put(Consts.USERACCOUNTID, req.getParameter(Consts.USERACCOUNTID));
        ArrayList<UserToGroupView> list = manager.findViewByFilter(filter);
        req.setAttribute("list", list);
        req.getRequestDispatcher("/userToGroup.jsp").forward(req, resp);
    }


}
