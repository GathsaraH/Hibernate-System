package com.zenixo.hibernate.dao.custom;

import com.sun.xml.bind.v2.model.core.ID;
import com.zenixo.hibernate.dao.SuperDAO;
import com.zenixo.hibernate.entity.CustomEntity;
import com.zenixo.hibernate.entity.Registration;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * @author Gathsara Umesh on 2/14/2021
 * @project Hibernate-Course-Work
 */
public interface QueryDAO extends SuperDAO {
    CustomEntity searchStudentID(String id) throws  Exception;
    public List<Registration> findAll() throws Exception;
    List<CustomEntity> getStudentDatails(String id) throws Exception;

}
