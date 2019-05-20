package servlets;

import model.Group;
import service.ServiceFactory;
import service.ServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/groups.do")
public class GroupServlet extends HttpServlet {
    ServiceImpl<Group, Group> manager;

    @Override
    public void init() throws ServletException {
        manager = ServiceFactory.getInstance().o().get(Group.class);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Group> list = manager.loadAll();
        req.setAttribute("list", list);
        req.getRequestDispatcher("/groups.jsp").forward(req, resp);
    }

}
