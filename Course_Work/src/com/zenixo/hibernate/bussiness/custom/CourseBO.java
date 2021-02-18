package com.zenixo.hibernate.bussiness.custom;

import com.zenixo.hibernate.bussiness.SuperBO;
import com.zenixo.hibernate.dto.CourseDTO;
import com.zenixo.hibernate.entity.Course;

import java.util.List;

/**
 * @author Gathsara Umesh on 2/10/2021
 * @project Hibernate-Course-Work
 */
public interface CourseBO extends SuperBO {
    public boolean addCourse(CourseDTO courseDTO)throws  Exception;
    public List<CourseDTO> getAllCourse()throws  Exception;
    public boolean deleteItem(CourseDTO courseDTO)throws  Exception;
    public boolean updateItem(CourseDTO courseDTO)throws  Exception;
    String getCourseID() throws  Exception;
}
