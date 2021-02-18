package com.zenixo.hibernate.dao.custom;

import com.zenixo.hibernate.dao.SuperDAO;
import com.zenixo.hibernate.dto.CustomDTO;
import com.zenixo.hibernate.entity.Registration;

/**
 * @author Gathsara Umesh on 2/13/2021
 * @project Hibernate-Course-Work
 */
public interface RegistrationDAO extends SuperDAO<Registration,String> {
    String getlastID() throws  Exception;
    public boolean addReRegStudent(Registration registration)throws  Exception;
    public boolean deleteStudent(CustomDTO customDTO )throws  Exception;
}
