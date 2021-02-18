package com.zenixo.hibernate.bussiness.custom.impl;

import com.zenixo.hibernate.bussiness.custom.StudentBO;
import com.zenixo.hibernate.dao.DAOFactory;
import com.zenixo.hibernate.dao.DAOType;
import com.zenixo.hibernate.dao.custom.impl.RegistrationDAOImpl;
import com.zenixo.hibernate.dao.custom.impl.StudentDAOImpl;
import com.zenixo.hibernate.dto.CourseDTO;
import com.zenixo.hibernate.dto.CustomDTO;
import com.zenixo.hibernate.entity.Course;
import com.zenixo.hibernate.entity.Registration;
import com.zenixo.hibernate.entity.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Gathsara Umesh on 2/12/2021
 * @project Hibernate-Course-Work
 */
public class StudentBOImpl implements StudentBO {

    StudentDAOImpl studentDAO= DAOFactory.getInstance().getDAO(DAOType.STUDENT);
    RegistrationDAOImpl registrationDAO=DAOFactory.getInstance().getDAO(DAOType.REGISTRATION);

    @Override
    public boolean addStudent(CustomDTO c) throws Exception {
//       final Student student =new Student(
//          customDTO.getStudentID(),
//          customDTO.getStudentName(),
//          customDTO.getStudentAddress(),
//          customDTO.getStudentContact(),
//          customDTO.getStudentDob(),
//          customDTO.getStudentGender()
//        );
//       final Registration registration=new Registration(
//               customDTO.getRegNumber(),
//               customDTO.getRegDate(),
//               customDTO.getRegFee(),
//               customDTO.getStudentID(),
//               customDTO.getCourseID()
//       );
//
//       if (studentDAO.add(student)){
//           if (registrationDAO.add(registration))
//               return true;
//       }

        Student student=new Student();
        student.setStudentID(c.getStudentID());
        student.setStudentName(c.getStudentName());
        student.setStudentAddress(c.getStudentAddress());
        student.setStudentContact(c.getStudentContact());
        student.setStudentDob(c.getStudentDob());
        student.setStudentGender(c.getStudentGender());

        studentDAO.add(student);

        Registration registration=new Registration();
        registration.setRegNumber(c.getRegNumber());
        registration.setRegDate(c.getRegDate());
        registration.setRegFee(c.getRegFee());
       registration.setStudent(new Student(c.getStudentID()));
       registration.setCourse(new Course(c.getCourseID()));

       registrationDAO.add(registration);

       return true;
    }

    @Override
    public ArrayList<String> getAllStudentForCombo() throws Exception {
        ArrayList<Student> list=studentDAO.getAllStudentForCombo();
        ArrayList<String> st=new ArrayList<>();
        for (Student student:list){
            st.add(student.getStudentID());
        }
        return st;
    }



}
