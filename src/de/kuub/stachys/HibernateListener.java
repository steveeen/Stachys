package de.kuub.stachys;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class HibernateListener implements ServletContextListener {
	 
    public void contextInitialized(ServletContextEvent event) {
        HibernateEMFCreatorUtil.getEMFactory(); // Just call the static initializer of that class    
    }
 
    public void contextDestroyed(ServletContextEvent event) {
        HibernateEMFCreatorUtil.getEMFactory().close(); // Free all resources
    }
}
