package com.zenixo.hibernate.dao.custom.impl;

import com.zenixo.hibernate.dao.custom.RegistrationDAO;
import com.zenixo.hibernate.dto.CustomDTO;
import com.zenixo.hibernate.entity.Registration;
import com.zenixo.hibernate.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import java.util.List;

/**
 * @author Gathsara Umesh on 2/13/2021
 * @project Hibernate-Course-Work
 */
public class RegistrationDAOImpl implements RegistrationDAO {
    @Override
    public boolean add(Registration registration) throws Exception {
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        session.save(registration);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Registration entity) throws Exception {
//      Session session=FactoryConfiguration.getInstance().getSession();
//      Transaction transaction=session.beginTransaction();
//      session.delete(entity);
//      transaction.commit();
//      session.close();
      return true;
    }

    @Override
    public boolean update(Registration registration) throws Exception {
        Session session=FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        session.update(registration);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public Registration find(String s) throws Exception {
        return null;
    }

    @Override
    public List<Registration> findAll() throws Exception {
        return null;
    }

    @Override
    public void setSession(Session session) throws Exception {

    }

    @Override
    public String getlastID() throws Exception {
        Session session=FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        NativeQuery sqlQuery = session.createSQLQuery("SELECT regNumber FROM Registration ORDER BY regNumber DESC LIMIT 1");
        String id=sqlQuery.uniqueResult().toString();
        transaction.commit();
        session.close();
        return id;
    }

    @Override
    public boolean addReRegStudent(Registration registration) throws Exception {
        Session session=FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        session.save(registration);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean deleteStudent(CustomDTO customDTO) throws Exception {
        return false;
    }
}
