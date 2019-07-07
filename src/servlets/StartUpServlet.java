package servlets;


import cash.Cash;
import model.Group;
import model.ModelMap;
import model.TagVisiblity;
import service.GeneralServiceImpl;
import service.ServiceFactory;
import service.ServiceImpl;
import util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

public class StartUpServlet extends HttpServlet {
    ServiceImpl<TagVisiblity, TagVisiblity> managerTagVisiblity;
    ServiceImpl<ModelMap, ModelMap> managerModelMap;
    ServiceImpl<Group, Group> managerGroup;

    @Override
    public void init() throws ServletException {
        System.out.println("----- start up -----");
        Cash.o();
        HibernateUtil.getSessionFactory();
        managerTagVisiblity = ServiceFactory.getInstance().o().get(TagVisiblity.class);
        managerModelMap = ServiceFactory.getInstance().o().get(ModelMap.class);
        managerGroup = ServiceFactory.getInstance().o().get(Group.class);
        Cash.o().setMmToDel(GeneralServiceImpl.getInstance().getModelMap2DeleteAfter(0l));
        Cash.o().setModelMaps(managerModelMap.loadAll());
        Cash.o().setTagVisiblities(managerTagVisiblity.loadAll());
        Cash.o().setLastModelMapId(managerModelMap.getLastId());
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

