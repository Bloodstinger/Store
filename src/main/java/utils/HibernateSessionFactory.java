package utils;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {


    private static final SessionFactory sessionFactory = buildSessionFactory();
    private static final Logger logger = Logger.getLogger(HibernateSessionFactory.class);

    private HibernateSessionFactory() {
    }

    private static SessionFactory buildSessionFactory() {
        try {
            Configuration configuration = new Configuration();
            return configuration.configure().buildSessionFactory();
        } catch (Exception e) {
            logger.error("error when try build session!", e);
        }
        return null;
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
