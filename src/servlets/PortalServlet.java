package servlets;

import model.*;
import moz.model.Auction;
import service.ServiceFactory;
import service.ServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/portal.do" ,loadOnStartup = 1)
public class PortalServlet extends HttpServlet {

    public static PortalConfiq portalConfiq;

    private ServiceImpl<UserAccountLog, UserAccountLog> managerUserAccountLog;
    private ServiceImpl<UserAccount, UserAccount> managerUserAccount;
    private ServiceImpl<TagVisiblity, TagVisiblity> managerTagVisiblity;
    private ServiceImpl<ModelMap, ModelMap> managerModelMap;
    private ServiceImpl<Group, Group> managerGroup;
    private ServiceImpl<UserToGroup, UserToGroupView> managerUserToGroup;
    private ServiceImpl<GMStruct, GMStruct> managerGMStruct;
    private ServiceImpl<PortalConfiq, PortalConfiq> managerPortalConfiq;
    private ServiceImpl<Auction, Auction> managerAuction;

    @Override
    public void init() throws ServletException {
        managerUserAccountLog = ServiceFactory.getInstance().o().get(UserAccountLog.class);
        managerUserAccount = ServiceFactory.getInstance().o().get(UserAccount.class);
        managerTagVisiblity = ServiceFactory.getInstance().o().get(TagVisiblity.class);
        managerModelMap = ServiceFactory.getInstance().o().get(ModelMap.class);
        managerGroup = ServiceFactory.getInstance().o().get(Group.class);
        managerUserToGroup = ServiceFactory.getInstance().o().get(UserToGroup.class);
        managerGMStruct = ServiceFactory.getInstance().o().get(GMStruct.class);
        managerPortalConfiq = ServiceFactory.getInstance().o().get(PortalConfiq.class);
        managerAuction = ServiceFactory.getInstance().o().get(Auction.class);
        portalConfiq = managerPortalConfiq.loadAll().get(0);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("update") != null) {
            update(req);
            resp.sendRedirect("/portal.do");
            return;
        }
        portalConfiq = managerPortalConfiq.loadAll().get(0);
        portalConfiq.setLastModelMapId(managerModelMap.getLastId());
        portalConfiq.setLastGMId1(managerAuction.getLastId());
        int[] grIds = new int[]{0, 0, 0, 0, 0, 0};
        ArrayList<Group> groups = managerGroup.loadAll();
        for (Group gr : groups) {
            if (grIds[gr.getTableId() - 1] < gr.getId())
                grIds[gr.getTableId() - 1] = (int) gr.getId();
        }
        portalConfiq.setLastGroupId1(grIds[0]);
        portalConfiq.setLastGroupId2(grIds[1]);
        portalConfiq.setLastGroupId3(grIds[2]);
        portalConfiq.setLastGroupId4(grIds[3]);
        portalConfiq.setLastGroupId5(grIds[4]);
        portalConfiq.setLastGroupId6(grIds[5]);
        req.setAttribute("portalConfiq", portalConfiq);
        req.getRequestDispatcher("/portal.jsp").forward(req, resp);
    }

    private void update(HttpServletRequest req) {
        portalConfiq.setConnectPeriod(Integer.valueOf(req.getParameter("connectPeriod")));
        portalConfiq.setWait4Server(Integer.valueOf(req.getParameter("wait4Server")));
        portalConfiq.setHaveNewChange(req.getParameter("haveNewChange").equals("true"));
        portalConfiq.setUpdateGroup(req.getParameter("updateGroup").equals("true"));
        portalConfiq.setClearDB(req.getParameter("clearDB").equals("true"));
        portalConfiq.setSendDetail(req.getParameter("sendDetail").equals("true"));
        portalConfiq.setTableName1(req.getParameter("tableName1").trim());
        portalConfiq.setTableName2(req.getParameter("tableName2").trim());
        portalConfiq.setTableName3(req.getParameter("tableName3").trim());
        portalConfiq.setTableName4(req.getParameter("tableName4").trim());
        portalConfiq.setTableName5(req.getParameter("tableName5").trim());
        portalConfiq.setTableName6(req.getParameter("tableName6").trim());
        managerPortalConfiq.save(portalConfiq);
    }

}
