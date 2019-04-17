package listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * Created with IntelliJ IDEA.
 * User: Abiz
 * Date: 8/16/18
 * Time: 6:55 PM
 * To change this template use File | Settings | File Templates.
 */

public class ServReqListener implements ServletRequestListener {

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        System.out.println("<ServletRequestListener>------ requestInitialized : " + servletRequestEvent.getServletRequest().hashCode());
    }

    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        System.out.println("<ServletRequestListener>------ requestDestroyed : " + servletRequestEvent.getServletRequest().hashCode());
    }

}
