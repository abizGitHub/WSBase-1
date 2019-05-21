package servlets;

import model.GeneralModel;
import model.UserAccount;
import service.ServiceFactory;
import service.ServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


@WebServlet("/generalModel.do")
public class GeneralModelServlet extends HttpServlet {

    ServiceImpl<UserAccount, UserAccount> manager;

    @Override
    public void init() throws ServletException {
        manager = ServiceFactory.getInstance().o().get(UserAccount.class);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer tableIx = Integer.valueOf(req.getParameter("tableIx"));
        ArrayList<GeneralModel> list = manager.generalModelAfter(tableIx, 0L);
        req.setAttribute("list", list);
        req.setAttribute("tableIx", tableIx);
        req.getRequestDispatcher("/generalModel.jsp").forward(req, resp);
    }

}
