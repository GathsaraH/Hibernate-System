package com.zenixo.hibernate.bussiness.custom.impl;

import com.zenixo.hibernate.bussiness.custom.StudentDatailsBO;
import com.zenixo.hibernate.dao.DAOFactory;
import com.zenixo.hibernate.dao.DAOType;
import com.zenixo.hibernate.dao.custom.impl.QueryDAOImpl;
import com.zenixo.hibernate.dto.CustomDTO;
import com.zenixo.hibernate.entity.CustomEntity;
import com.zenixo.hibernate.util.FactoryConfiguration;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Gathsara Umesh on 2/15/2021
 * @project Hibernate-Course-Work
 */
public class StudentDatailsBOImpl implements StudentDatailsBO {
    QueryDAOImpl queryDAO= DAOFactory.getInstance().getDAO(DAOType.QUERY);
    @Override
    public List<CustomDTO> getAllStudentDatails(String id) throws Exception {
        Session session= FactoryConfiguration.getInstance().getSession();
        queryDAO.setSession(session);
        session.getTransaction().begin();

        List<CustomDTO> list=new ArrayList<>();
        try {
            List<CustomEntity> all = queryDAO.getStudentDatails(id);
            for (CustomEntity c : all) {
                list.add(new CustomDTO(c.getStudentName(), c.getStudentID(), c.getCourseID()));
            }
        session.getTransaction().commit();
        }catch (Throwable throwable){
            session.getTransaction().rollback();
            throw  throwable;
        }finally {
            session.close();
        }
        return list;
    }
}
