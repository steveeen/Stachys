package de.kuub.stachys;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.StaleObjectStateException;

public class HibernateSessionRequestFilter implements Filter {

	private static Log log = LogFactory
			.getLog(HibernateSessionRequestFilter.class);

	private EntityManagerFactory emf;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		try {
			log.debug("Starting a database transaction");
			EntityManager em = emf.createEntityManager();
			// EntityTransaction tx=em.getTransaction();
			// tx.begin();
			// sf.getCurrentSession().beginTransaction();

			// Call the next filter (continue request processing)
			chain.doFilter(request, response);

			// Commit and cleanup
			// log.debug("Committing the database transaction");
			// tx.commit();
			// sf.getCurrentSession().getTransaction().commit();

		} catch (StaleObjectStateException staleEx) {
			log.error("This interceptor does not implement optimistic concurrency control!");
			log.error("Your application will not work until you add compensation actions!");
			// Rollback, close everything, possibly compensate for any permanent
			// changes
			// during the conversation, and finally restart business
			// conversation. Maybe
			// give the user of the application a chance to merge some of his
			// work with
			// fresh data... what you do here depends on your applications
			// design.
			throw staleEx;
		} catch (Throwable ex) {
			// Rollback only
			ex.printStackTrace();
			// try {
			// if (sf.getCurrentSession().getTransaction().isActive()) {
			// log.debug("Trying to rollback database transaction after exception");
			// sf.getCurrentSession().getTransaction().rollback();
			// }
			// } catch (Throwable rbEx) {
			// log.error("Could not rollback transaction after exception!",
			// rbEx);
			// }

			// Let others handle it... maybe another interceptor for exceptions?
			throw new ServletException(ex);
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		log.debug("Initializing filter...");
		log.debug("Obtaining EMFSessionFactory from static HibernateUtil singleton");
		// sf = HibernateUtil.getSessionFactory();
		emf = HibernateEMFCreatorUtil.getEMFactory();
	}

	@Override
	public void destroy() {
		log.debug("Destroy called...");
		emf.close();

	}

}
