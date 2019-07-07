package servlets;

import model.Message;
import model.UserAccount;
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
import java.util.Date;

@WebServlet("/message.do")
public class MessageServlet extends HttpServlet {

    ServiceImpl<Message, Message> manager;
    ServiceImpl<UserAccount, UserAccount> managerUser;
    @Override
    public void init() throws ServletException {
        manager = ServiceFactory.getInstance().o().get(Message.class);
        managerUser = ServiceFactory.getInstance().o().get(UserAccount.class);
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userAccountId = req.getParameter(Consts.USERACCOUNTID);
        String userName = req.getParameter(Consts.USERNAME);
        if (req.getParameter(Consts.METHOD) != null && req.getParameter(Consts.METHOD).equals(String.valueOf(Message.SENT))) {
            Message message = new Message();
            message.setBody(req.getParameter("body"));
            message.setType(Message.SENT);
            message.setUserAccountId(Long.valueOf(userAccountId));
            message.setRegisterDate(new Date());
            manager.save(message);
            UserAccount user = managerUser.findById(Long.valueOf(userAccountId));
            user.setLastMsgId(message.getId());
            managerUser.save(user);
            resp.sendRedirect("message.do?" +
                    Consts.USERACCOUNTID + "=" + userAccountId +
                    "&" + Consts.USERNAME + "=" + userName);
            return;
        }
        if (userAccountId != null && !userAccountId.isEmpty())
            req.setAttribute(Consts.USERACCOUNTID, userAccountId);
        if (userName != null && !userName.isEmpty())
            req.setAttribute(Consts.USERNAME, userName);
        ArrayList<Message> list;
        if (userAccountId == null || userAccountId.isEmpty())
            list = manager.loadAll();
        else
            list = manager.findByAccountId(Long.parseLong(userAccountId));
        req.setAttribute("list", list);
        req.getRequestDispatcher("/message.jsp").forward(req, resp);
    }

}

