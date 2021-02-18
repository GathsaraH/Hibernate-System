package com.zenixo.hibernate.dao.custom;

import com.zenixo.hibernate.dao.SuperDAO;
import com.zenixo.hibernate.dto.CustomDTO;
import com.zenixo.hibernate.entity.Student;

import java.util.ArrayList;

/**
 * @author Gathsara Umesh on 2/12/2021
 * @project Hibernate-Course-Work
 */
public interface StudentDAO extends SuperDAO<Student,String> {
    public ArrayList<Student> getAllStudentForCombo()throws  Exception;
    public String getStudentID()throws Exception;
    public boolean deleteStudent(CustomDTO customDTO)throws  Exception;
}
