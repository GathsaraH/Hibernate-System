package com.zenixo.hibernate.dao.custom.impl;

import com.zenixo.hibernate.dao.custom.UserDAO;
import com.zenixo.hibernate.entity.User;
import com.zenixo.hibernate.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

/**
 * @author Gathsara Umesh on 2/16/2021
 * @project Hibernate-Course-Work
 */
public class UserDAOImpl implements UserDAO {
    @Override
    public User getUser(String userName, String password) throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Query query = session.createQuery("FROM User WHERE (userName = ?1 AND password = ?2)");
        query.setParameter(1,userName);
        query.setParameter(2,password);
        return (User) query.uniqueResult();
    }

    @Override
    public boolean add(User entity) throws Exception {
        return false;
    }

    @Override
    public boolean delete(User entity) throws Exception {
        return false;
    }

    @Override
    public boolean update(User entity) throws Exception {
        return false;
    }

    @Override
    public User find(String s) throws Exception {
        return null;
    }

    @Override
    public List<User> findAll() throws Exception {
        return null;
    }

    @Override
    public void setSession(Session session) throws Exception {

    }
}
