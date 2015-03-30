package com.digvijayb.hibernate;

import com.digvijayb.aglorithms.sample.TestLambda;
import com.digvijayb.hibernate.entity.PersonEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Created by digvijayb on 29/3/15.
 */
public class HelloHibernate {


    public static void main(String... args){


        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        Session session = sessionFactory.openSession();

        session.beginTransaction();

        PersonEntity personEntity = new PersonEntity(0,"digvijay bhakuni",24);

        //session.save(personEntity);
        session.update(personEntity);
        session.getTransaction().commit();


    }


}
