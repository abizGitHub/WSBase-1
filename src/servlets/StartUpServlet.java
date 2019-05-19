package servlets;


import cash.Cash;
import service.ServiceFactory;
import util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class StartUpServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("----- start up -----");
        Cash.o();
        HibernateUtil.getSessionFactory();
    }

    public static void main(String[] args) {
        StartUpServlet startUpServlet = new StartUpServlet();
        try {
            startUpServlet.init();
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

}
