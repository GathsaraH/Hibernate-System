package com.zenixo.hibernate.bussiness.custom.impl;

import com.zenixo.hibernate.bussiness.custom.CourseBO;
import com.zenixo.hibernate.dao.DAOFactory;
import com.zenixo.hibernate.dao.DAOType;
import com.zenixo.hibernate.dao.SuperDAO;
import com.zenixo.hibernate.dao.custom.CourseDAO;
import com.zenixo.hibernate.dao.custom.impl.CourseDAOImpl;
import com.zenixo.hibernate.dto.CourseDTO;
import com.zenixo.hibernate.entity.Course;
import com.zenixo.hibernate.util.FactoryConfiguration;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Gathsara Umesh on 2/10/2021
 * @project Hibernate-Course-Work
 */
public class CourseBOImpl implements CourseBO {

    CourseDAOImpl courseDAO = DAOFactory.getInstance().getDAO(DAOType.COURSE);


    @Override
    public boolean addCourse(CourseDTO courseDTO) throws Exception {

       return courseDAO.add(new Course(courseDTO.getCourseID(),
                courseDTO.getCourseName(),
                courseDTO.getCourseType(),
                courseDTO.getCourseDuration()));


    }

    @Override
    public List<CourseDTO> getAllCourse() throws Exception {
        List<Course> all=courseDAO.findAll();
        List<CourseDTO> list=new ArrayList<>();
        for (Course course:all){
            list.add(new CourseDTO(
                    course.getCourseID(),
                    course.getCourseName(),
                    course.getCourseType(),
                    course.getCourseDuration()
            ));
        }
        System.out.println("Test 2"+list);
      return list;

    }

    @Override
    public boolean deleteItem(CourseDTO courseDTO) throws Exception {
        Course course=new Course();
        course.setCourseID(courseDTO.getCourseID());
        course.setCourseName(courseDTO.getCourseName());
        course.setCourseType(courseDTO.getCourseType());
        course.setCourseDuration(courseDTO.getCourseDuration());
        courseDAO.delete(course);
        return true;
    }

    @Override
    public boolean updateItem(CourseDTO courseDTO) throws Exception {
        Course course=new Course();
        course.setCourseID(courseDTO.getCourseID());
        course.setCourseName(courseDTO.getCourseName());
        course.setCourseType(courseDTO.getCourseType());
        course.setCourseDuration(courseDTO.getCourseDuration());
        courseDAO.update(course);
        return true;
    }

    @Override
    public String getCourseID() throws Exception {
        return courseDAO.getLastID();
    }

}
