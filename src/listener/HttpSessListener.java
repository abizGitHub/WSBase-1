package listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created with IntelliJ IDEA.
 * User: Abiz
 * Date: 8/16/18
 * Time: 6:54 PM
 * To change this template use File | Settings | File Templates.
 */

public class HttpSessListener implements HttpSessionListener {
    static int SESSION_COUNT ;

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        SESSION_COUNT ++;
        /*String id = httpSessionEvent.getSession().getId();
        System.out.println("<HttpSessionListener> max inactive interval : "+httpSessionEvent.getSession().getMaxInactiveInterval());
        httpSessionEvent.getSession().setAttribute("sessId", "sessId : " + id);
        System.out.println("<HttpSessionListener> session Created : " + id);*/
        // httpSessionEvent.getSession().invalidate();
        //System.out.println("all session >"+SESSION_COUNT);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {/*
        String id = httpSessionEvent.getSession().getId();
        System.out.println("<HttpSessionListener> session destroyed : " + id);*/
        SESSION_COUNT --;
        //System.err.println("all session >"+SESSION_COUNT);
    }

}
