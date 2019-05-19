package servlets;

import model.ModelMap;
import model.UserAccountLog;
import service.ServiceFactory;
import service.ServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/modelMap.do")
public class ModelMapServlet extends HttpServlet {

    ServiceImpl<ModelMap, ModelMap> manager;

    @Override
    public void init() throws ServletException {
        manager = ServiceFactory.getInstance().o().get(ModelMap.class);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<ModelMap> list = manager.loadAll();
        req.setAttribute("list", list);
        req.getRequestDispatcher("/modelMap.jsp").forward(req, resp);
    }

}
