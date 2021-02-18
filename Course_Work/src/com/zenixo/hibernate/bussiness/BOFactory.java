package com.zenixo.hibernate.bussiness;

import com.zenixo.hibernate.bussiness.custom.CourseBO;
import com.zenixo.hibernate.bussiness.custom.impl.*;

/**
 * @author Gathsara Umesh on 2/10/2021
 * @project Hibernate-Course-Work
 */
public class BOFactory {
    private static BOFactory boFactory;
    private BOFactory(){

    }
    public static BOFactory getInstance(){
        return (boFactory==null)?boFactory=new BOFactory():boFactory;
    }
    public <T extends SuperBO>T getBO(BOType boType){
        switch (boType){
            case COURSE:
                return (T) new CourseBOImpl();
            case STUDENT:
                return (T) new StudentBOImpl();
            case REGISTRATION:
                return (T) new RegistrationBOImpl();
            case STUDENTDATAILL:
                return (T) new StudentDatailsBOImpl();
            case USER:
                return (T) new UserBOImpl();
            default:
                return null;
        }
    }
}
