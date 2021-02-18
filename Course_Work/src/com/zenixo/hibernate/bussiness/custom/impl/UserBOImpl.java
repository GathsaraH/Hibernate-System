package com.zenixo.hibernate.bussiness.custom.impl;

import com.zenixo.hibernate.bussiness.custom.UserBO;
import com.zenixo.hibernate.dao.DAOFactory;
import com.zenixo.hibernate.dao.DAOType;
import com.zenixo.hibernate.dao.custom.UserDAO;
import com.zenixo.hibernate.dto.UserDTO;
import com.zenixo.hibernate.entity.User;

/**
 * @author Gathsara Umesh on 2/16/2021
 * @project Hibernate-Course-Work
 */
public class UserBOImpl implements UserBO {
    UserDAO userDAO = DAOFactory.getInstance().getDAO(DAOType.USER);

    @Override
    public UserDTO getUser(String userName, String password) throws Exception {
        User user = userDAO.getUser(userName, password);
        return new UserDTO(user.getUid(), user.getName(), user.getUserName(), user.getPassword());
    }
}
