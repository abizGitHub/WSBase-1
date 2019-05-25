package servlets;

import model.UserAccount;
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


@WebServlet("/userAccounts.do")
public class UserAccountServlet extends HttpServlet {

    ServiceImpl<UserAccount, UserAccount> manager;
    ServiceImpl<UserAccountLog, UserAccountLog> managerLog;

    @Override
    public void init() throws ServletException {
        manager = ServiceFactory.getInstance().o().get(UserAccount.class);
        managerLog = ServiceFactory.getInstance().o().get(UserAccountLog.class);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter(Consts.METHOD) != null && req.getParameter(Consts.METHOD).equals(String.valueOf(UserAccountLog.PERMISSIONUPDATED))) {
            long uid = Long.parseLong(req.getParameter(Consts.USERACCOUNTID));
            UserAccount byId = manager.findById(uid);
            byId.setPermissionDays(Integer.valueOf(req.getParameter("permissionDays")));
            byId.setHasPermission(true);
            manager.save(byId);
            UserAccountLog log = new UserAccountLog(UserAccountLog.PERMISSIONUPDATED, uid);
            log.setHasPermission(true);
            managerLog.save(log);
        }
        ArrayList<UserAccount> list = manager.loadAll();
        req.setAttribute("list", list);
        req.getRequestDispatcher("/userAccount.jsp").forward(req, resp);
    }

}
