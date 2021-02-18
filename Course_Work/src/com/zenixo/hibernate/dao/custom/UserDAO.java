package com.zenixo.hibernate.dao.custom;

import com.zenixo.hibernate.dao.SuperDAO;
import com.zenixo.hibernate.entity.User;

/**
 * @author Gathsara Umesh on 2/16/2021
 * @project Hibernate-Course-Work
 */
public interface UserDAO extends SuperDAO<User, String> {
    User getUser(String userName, String password) throws Exception;
}
