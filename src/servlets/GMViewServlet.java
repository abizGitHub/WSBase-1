package servlets;

import com.sun.org.apache.xml.internal.utils.ObjectStack;
import model.GeneralModel;
import model.ModelMap;
import model.TagVisiblity;
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
import java.util.HashMap;


@WebServlet("/gMView.do")
public class GMViewServlet extends HttpServlet {

    ServiceImpl<UserAccount, UserAccount> manager;
    ServiceImpl<TagVisiblity, TagVisiblity> managerTag;
    ServiceImpl<ModelMap, ModelMap> managerMdlMap;


    @Override
    public void init() throws ServletException {
        manager = ServiceFactory.getInstance().o().get(UserAccount.class);
        managerTag = ServiceFactory.getInstance().o().get(TagVisiblity.class);
        managerMdlMap = ServiceFactory.getInstance().o().get(ModelMap.class);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer tableIx = Integer.valueOf(req.getParameter("tableIx"));
        ArrayList<GeneralModel> list = manager.generalModelAfter(tableIx, 0L);
        HashMap<String, Object> filter = new HashMap<>();
        filter.put("tableId", tableIx);
        TagVisiblity tag = managerTag.findByFilter(filter).get(0);
        ArrayList<GeneralModel> listView = new ArrayList<>();
        for (GeneralModel gm : list) {
            GeneralModel generalModel = new GeneralModel();
            generalModel.setId(gm.getId());
            if (tag.isTitleString())
                generalModel.setTitle(gm.getTitle());
            else {
                filter.clear();
                filter.put("tableId", tableIx);
                filter.put("intValue", Integer.parseInt(gm.getTitle()));
                filter.put("columnIx", GeneralModel.TITLE);
                ModelMap mm = managerMdlMap.findByFilter(filter).get(0);
                generalModel.setTitle(mm.getStringValue());
            }
            if (tag.isBodyString())
                generalModel.setBody(gm.getBody());
            else {
                filter.clear();
                filter.put("tableId", tableIx);
                filter.put("intValue", Integer.parseInt(gm.getBody()));
                filter.put("columnIx", GeneralModel.BODY);
                ModelMap mm = managerMdlMap.findByFilter(filter).get(0);
                generalModel.setBody(mm.getStringValue());
            }
            if (tag.isHeaderRString())
                generalModel.setHeaderR(gm.getHeaderR());
            else {
                filter.clear();
                filter.put("tableId", tableIx);
                filter.put("intValue", Integer.parseInt(gm.getHeaderR()));
                filter.put("columnIx", GeneralModel.HEADER_R);
                ModelMap mm = managerMdlMap.findByFilter(filter).get(0);
                generalModel.setHeaderR(mm.getStringValue());
            }
            if (tag.isHeaderLString())
                generalModel.setHeaderL(gm.getHeaderL());
            else {
                filter.clear();
                filter.put("tableId", tableIx);
                filter.put("intValue", Integer.parseInt(gm.getHeaderL()));
                filter.put("columnIx", GeneralModel.HEADER_L);
                ModelMap mm = managerMdlMap.findByFilter(filter).get(0);
                generalModel.setHeaderL(mm.getStringValue());
            }
            if (tag.isFooterRString())
                generalModel.setFooterR(gm.getFooterR());
            else {
                filter.clear();
                filter.put("tableId", tableIx);
                filter.put("intValue", Integer.parseInt(gm.getFooterR()));
                filter.put("columnIx", GeneralModel.FOOTER_R);
                ModelMap mm = managerMdlMap.findByFilter(filter).get(0);
                generalModel.setFooterR(mm.getStringValue());
            }
            if (tag.isFooterLString())
                generalModel.setFooterL(gm.getFooterL());
            else {
                filter.clear();
                filter.put("tableId", tableIx);
                filter.put("intValue", Integer.parseInt(gm.getFooterL()));
                filter.put("columnIx", GeneralModel.FOOTER_L);
                ModelMap mm = managerMdlMap.findByFilter(filter).get(0);
                generalModel.setFooterL(mm.getStringValue());
            }
            listView.add(generalModel);
        }
        req.setAttribute("list", listView);
        req.setAttribute("tableIx", tableIx);
        req.getRequestDispatcher("/gMView.jsp").forward(req, resp);
    }

}
