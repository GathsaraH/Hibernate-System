package com.zenixo.hibernate.bussiness.custom;

import com.zenixo.hibernate.bussiness.SuperBO;
import com.zenixo.hibernate.dto.UserDTO;

/**
 * @author Gathsara Umesh on 2/16/2021
 * @project Hibernate-Course-Work
 */
public interface UserBO extends SuperBO {
    UserDTO getUser(String userName, String password) throws Exception;
}
