package listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

/**
 * Created with IntelliJ IDEA.
 * User: Abiz
 * Date: 8/16/18
 * Time: 6:52 PM
 * To change this template use File | Settings | File Templates.
 */

public class ServCntxAttrListener implements ServletContextAttributeListener{

    @Override
    public void attributeAdded(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println("<ServletContextAttributeListener>------- attributeAdded ---------");
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println("<ServletContextAttributeListener>------- attributeRemoved ---------");
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println("<ServletContextAttributeListener>------- attributeReplaced ---------");
    }

}
