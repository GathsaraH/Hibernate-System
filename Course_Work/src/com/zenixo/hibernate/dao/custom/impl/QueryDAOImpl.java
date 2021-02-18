package com.zenixo.hibernate.dao.custom.impl;

import com.sun.xml.bind.v2.model.core.ID;
import com.zenixo.hibernate.dao.custom.QueryDAO;
import com.zenixo.hibernate.entity.CustomEntity;
import com.zenixo.hibernate.entity.Registration;
import com.zenixo.hibernate.entity.SuperEntity;
import com.zenixo.hibernate.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Gathsara Umesh on 2/14/2021
 * @project Hibernate-Course-Work
 */
public class QueryDAOImpl implements QueryDAO {
    Session session;
    @Override
    public boolean add(SuperEntity entity) throws Exception {
        return false;
    }

    @Override
    public boolean delete(SuperEntity entity) throws Exception {
        return false;
    }

    @Override
    public boolean update(SuperEntity entity) throws Exception {
        return false;
    }

    @Override
    public SuperEntity find(Serializable serializable) throws Exception {
        return null;
    }



    @Override
    public void setSession(Session session) throws Exception {
        this.session = session;
    }






    //GODAAAK LOAD KARANKOTAAA....



    @Override
    public CustomEntity searchStudentID(String id) throws Exception {
        Query query = session.createQuery("SELECT s.studentID, s.studentName, s.studentAddress, s.studentContact, s.studentDob, s.studentGender, r.regDate, r.regFee FROM Student s " +
                "INNER JOIN s.registrations r WHERE s.studentID = ?1");
        query.setParameter(1, id);
        List<Object[]> list = query.list();
        List<CustomEntity> all = new ArrayList<>();
        for (Object[] objects : list) {
            all.add(new CustomEntity(objects[0].toString(), objects[1].toString(), objects[2].toString(), objects[3].toString(),
                    objects[4].toString(), objects[5].toString(), objects[6].toString(),Double.parseDouble(objects[7].toString())));
            System.out.println("RegFee +"+objects[7].toString());
        }
        return all.get(0);
    }

    @Override
    public List<CustomEntity> getStudentDatails(String id) throws Exception {
//        Query query = session.createQuery("SELECT s.studentName,r.studentID,r.courseID FROM Registration " +
//                "r INNER JOIN r.student s WHERE r.id= ?1");
        NativeQuery nativeQuery = session.createNativeQuery("SELECT r.courseID,r.studentID,s.studentName FROM registration r,student s WHERE r.studentID=s.studentID and r.studentID= ?1");
        nativeQuery.setParameter(1,id);
        List<Object[]>list=nativeQuery.list();
        List<CustomEntity> all=new ArrayList<>();
        for (Object [] objects : list){
            all.add(new CustomEntity(objects[0].toString(),objects[1].toString(),objects[2].toString()));
        }
        return all;
    }





    @Override
    public List<Registration> findAll() throws Exception {
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        Query query = session.createQuery("From Registration ");
        List<Registration> list=query.list();
        transaction.commit();
        session.close();
        return list;
    }



}




//SINGLE LOAD.....


//public CustomEntity searchStudentID(String id) throws Exception {
//    Query query = session.createQuery("SELECT s.studentID, s.studentName, s.studentAddress, s.studentContact, s.studentDob, s.studentGender, r.regDate, r.regFee FROM Student s " +
//            "INNER JOIN s.registrations r WHERE s.studentID = ?1");
//    query.setParameter(1, id);
//    Object[] objects = (Object[]) query.uniqueResult();
//    CustomEntity all = null;
//    all = new CustomEntity(objects[0].toString(), objects[1].toString(), objects[2].toString(), objects[3].toString(),
//            objects[4].toString(), objects[5].toString(), objects[6].toString(), Double.parseDouble(objects[7].toString()));
//    return all;
//}
//}
