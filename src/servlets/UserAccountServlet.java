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

    @Override
    public void init() throws ServletException {
        manager = ServiceFactory.getInstance().o().get(UserAccount.class);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getParameter(Consts.METHOD);
        System.out.println("------ userAccounts  ------");
        ArrayList<UserAccount> list = manager.loadAll();
        req.setAttribute("list", list);
        System.out.println(list.get(0));
        req.getRequestDispatcher("/userAccount.jsp").forward(req, resp);
    }

}
