package com.zenixo.hibernate.dao.custom;

import com.zenixo.hibernate.dao.SuperDAO;
import com.zenixo.hibernate.entity.Course;

/**
 * @author Gathsara Umesh on 2/10/2021
 * @project Hibernate-Course-Work
 */
public interface CourseDAO extends SuperDAO<Course,String> {

    String getLastID();
}
