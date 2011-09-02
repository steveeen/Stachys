package de.kuub.stachys;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class HibernateEMFCreatorUtil {

    private static EntityManagerFactory emFactory;// = buildEntityManagerFactory();
    private static Log log = LogFactory.getLog(HibernateEMFCreatorUtil.class);
    private static EntityManagerFactory buildEntityManagerFactory() {
        try {
           	log.info("createEntityManagerFactory");
            return Persistence.createEntityManagerFactory("StachysWeb");
        }
        catch (Throwable ex) {
        	log.error("Initial EMFactory creation failed." + ex.getMessage());
            System.err.println(ex.toString());
        	throw new ExceptionInInitializerError(ex);
        }
    }

    public static EntityManagerFactory getEMFactory() {
        log.debug("return standard EntityManagerFactory");
    	if(emFactory==null){
    		log.info("emFactory==null");
    		emFactory=buildEntityManagerFactory();
    	}
        return emFactory;
    }
    public static EntityManagerFactory getloginUserEMFatory(){
    	log.debug("return LoginUser EntityManagerFactory");
    	Map<String, Object> configOverrides = new HashMap<String, Object>();
    	configOverrides.put("javax.persistence.jdbc.user", "postgres");
    	configOverrides.put("javax.persistence.jdbc.password", "delfin");
    	EntityManagerFactory programmaticEmf =
    	    Persistence.createEntityManagerFactory("StachysWeb", configOverrides);
    	return programmaticEmf;
    }
}
