package com.zenixo.hibernate.dao.custom.impl;

import com.zenixo.hibernate.dao.SuperDAO;
import com.zenixo.hibernate.dao.custom.CourseDAO;
import com.zenixo.hibernate.entity.Course;
import com.zenixo.hibernate.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.util.List;

/**
 * @author Gathsara Umesh on 2/10/2021
 * @project Hibernate-Course-Work
 */
public class CourseDAOImpl implements CourseDAO {
    @Override
    public boolean add(Course course) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        session.save(course);
        transaction.commit();
        session.close();

        return true;
    }

    @Override
    public boolean delete(Course course) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(course);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Course course) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        session.update(course);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public Course find(String s) throws Exception {
        return null;
    }

    @Override
    public List<Course> findAll() throws Exception {

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query query=session.createQuery("FROM Course");
        List<Course> list=query.list();
        transaction.commit();
        session.close();
        System.out.println("Test 1"+list);
        return list;
    }

    @Override
    public void setSession(Session session) throws Exception {

    }

    @Override
    public String getLastID() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        NativeQuery sqlQuery = session.createSQLQuery("SELECT courseID FROM Course ORDER BY courseID DESC LIMIT 1");
        String id=sqlQuery.uniqueResult().toString();
        transaction.commit();
        session.close();
        return id;
    }
}
