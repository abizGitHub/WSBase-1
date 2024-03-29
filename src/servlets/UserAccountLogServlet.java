package servlets;

import model.UserAccountLogView;
import service.ServiceFactory;
import service.ServiceImpl;
import util.Consts;
import model.UserAccountLog;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

@WebServlet("/userAccountLog.do")
public class UserAccountLogServlet extends HttpServlet {

        ServiceImpl<UserAccountLog, UserAccountLogView> manager;

    @Override
    public void init() throws ServletException {
        manager = ServiceFactory.getInstance().o().get(UserAccountLog.class);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HashMap filter = new HashMap<String, Long>();
        filter.put(Consts.USERACCOUNTID, req.getParameter(Consts.USERACCOUNTID));
        ArrayList<UserAccountLogView> list = manager.findViewByFilter(filter);
        req.setAttribute("list", list);
        req.getRequestDispatcher("/userAccountLog.jsp").forward(req, resp);
    }


}
