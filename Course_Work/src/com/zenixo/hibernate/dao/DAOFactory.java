package com.zenixo.hibernate.dao;

import com.zenixo.hibernate.dao.custom.CourseDAO;
import com.zenixo.hibernate.dao.custom.impl.*;
import com.zenixo.hibernate.entity.Course;
import com.zenixo.hibernate.entity.Registration;

/**
 * @author Gathsara Umesh on 2/10/2021
 * @project Hibernate-Course-Work
 */
public class DAOFactory {
    private   static  DAOFactory daoFactory;
    private  DAOFactory(){

    }
    public static  DAOFactory getInstance(){
        return (daoFactory==null)?daoFactory=new DAOFactory():daoFactory;
    }
    public <T extends SuperDAO>T getDAO(DAOType daoType){
        switch (daoType){
            case COURSE:
                return (T) new CourseDAOImpl();
            case STUDENT:
                return (T) new StudentDAOImpl();
            case REGISTRATION:
              return (T) new RegistrationDAOImpl();
            case QUERY:
                return (T) new QueryDAOImpl();
            case USER:
                return (T) new UserDAOImpl();
            default:
                return null;
        }
    }
}
