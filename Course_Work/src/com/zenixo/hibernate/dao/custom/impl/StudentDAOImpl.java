package com.zenixo.hibernate.dao.custom.impl;

import com.zenixo.hibernate.dao.custom.StudentDAO;
import com.zenixo.hibernate.dto.CustomDTO;
import com.zenixo.hibernate.entity.Student;
import com.zenixo.hibernate.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Gathsara Umesh on 2/12/2021
 * @project Hibernate-Course-Work
 */
public class StudentDAOImpl implements StudentDAO {
    @Override
    public boolean add(Student student) throws Exception {
        Session session= FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        session.save(student);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Student student) throws Exception {
        Session session=FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        session.delete(session.load(Student.class, student.getStudentID()));
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Student entity) throws Exception {
        return false;
    }

    @Override
    public Student find(String s) throws Exception {
        return null;
    }

    @Override
    public List<Student> findAll() throws Exception {
        return null;
    }

    @Override
    public void setSession(Session session) throws Exception {

    }

    @Override
    public ArrayList<Student> getAllStudentForCombo() throws Exception {
        Session session=FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        Query query=session.createQuery("FROM Student ");
        ArrayList<Student> list= (ArrayList<Student>) query.list();
        return list;
    }

    @Override
    public String getStudentID() throws Exception {
        Session session=FactoryConfiguration.getInstance().getSession();
        Transaction transaction=session.beginTransaction();
        NativeQuery sqlQuery = session.createSQLQuery("SELECT studentID FROM Student ORDER BY studentID DESC LIMIT 1");
        String id=sqlQuery.uniqueResult().toString();
        transaction.commit();
        session.close();
        return id;
    }

    @Override
    public boolean deleteStudent(CustomDTO customDTO) throws Exception {
        return false;
    }


}


