package com.zenixo.hibernate.util;

import com.zenixo.hibernate.entity.Course;
import com.zenixo.hibernate.entity.Registration;
import com.zenixo.hibernate.entity.Student;
import com.zenixo.hibernate.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author Gathsara Umesh on 2/9/2021
 * @project Hibernate-Course-Work
 */
public class FactoryConfiguration {
    private  static FactoryConfiguration factoryConfiguration;
    private SessionFactory sessionFactory;

    private FactoryConfiguration(){
        Configuration configure = new Configuration()
                .addAnnotatedClass(Course.class).addAnnotatedClass(Student.class)
                .addAnnotatedClass(Registration.class)
                .addAnnotatedClass(User.class);

        sessionFactory=configure.buildSessionFactory();
    }
    public static FactoryConfiguration getInstance(){
         return (factoryConfiguration==null) ? factoryConfiguration=new FactoryConfiguration():factoryConfiguration;

    }
    public Session getSession(){
        return sessionFactory.openSession();
    }
}

