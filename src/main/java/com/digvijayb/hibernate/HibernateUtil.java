package com.digvijayb.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

/**
 * Created by digvijayb on 29/3/15.
 */

public class HibernateUtil {

    private static SessionFactory sessionFactory = createSessionFactory();

    private static final SessionFactory createSessionFactory(){
        //return new Configuration().configure().buildSessionFactory();
        return new AnnotationConfiguration().configure().buildSessionFactory();
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    /*
     * Close caches and connection pools
     */
    public static void shutdown() {

        getSessionFactory().close();
    }

}
