package listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


/**
 * Created with IntelliJ IDEA.
 * User: Abiz
 * Date: 8/16/18
 * Time: 6:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class ServCntxListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent event) {
        ServletContext servletContext = event.getServletContext();
        servletContext.setAttribute("listenerParam", "<this was set in ServletContextListener>");
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
    }
}
