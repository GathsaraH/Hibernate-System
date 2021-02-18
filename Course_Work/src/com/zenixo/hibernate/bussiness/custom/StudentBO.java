package com.zenixo.hibernate.bussiness.custom;

import com.zenixo.hibernate.bussiness.SuperBO;
import com.zenixo.hibernate.dto.CourseDTO;
import com.zenixo.hibernate.dto.CustomDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Gathsara Umesh on 2/12/2021
 * @project Hibernate-Course-Work
 */
public interface StudentBO extends SuperBO {
   public boolean addStudent(CustomDTO customDTO)throws  Exception;
   public ArrayList<String> getAllStudentForCombo()throws Exception;

}
