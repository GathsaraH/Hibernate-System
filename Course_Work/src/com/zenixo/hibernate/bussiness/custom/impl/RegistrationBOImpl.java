package com.zenixo.hibernate.bussiness.custom.impl;

import com.sun.xml.bind.v2.model.core.ID;
import com.zenixo.hibernate.bussiness.custom.RegistrationBO;
import com.zenixo.hibernate.dao.DAOFactory;
import com.zenixo.hibernate.dao.DAOType;
import com.zenixo.hibernate.dao.custom.RegistrationDAO;
import com.zenixo.hibernate.dao.custom.impl.QueryDAOImpl;
import com.zenixo.hibernate.dao.custom.impl.RegistrationDAOImpl;
import com.zenixo.hibernate.dao.custom.impl.StudentDAOImpl;
import com.zenixo.hibernate.dto.CustomDTO;
import com.zenixo.hibernate.dto.RegistrationDTO;
import com.zenixo.hibernate.entity.Course;
import com.zenixo.hibernate.entity.CustomEntity;
import com.zenixo.hibernate.entity.Registration;
import com.zenixo.hibernate.entity.Student;
import com.zenixo.hibernate.util.FactoryConfiguration;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Gathsara Umesh on 2/14/2021
 * @project Hibernate-Course-Work
 */
public class RegistrationBOImpl implements RegistrationBO {

    QueryDAOImpl queryDAO= DAOFactory.getInstance().getDAO(DAOType.QUERY);
    RegistrationDAOImpl registrationDAO=DAOFactory.getInstance().getDAO(DAOType.REGISTRATION);
    StudentDAOImpl studentDAO=DAOFactory.getInstance().getDAO(DAOType.STUDENT);

    @Override
    public CustomDTO searchStudent(String studentID) throws Exception {
        Session session= FactoryConfiguration.getInstance().getSession();
        queryDAO.setSession(session);
        session.getTransaction().begin();

        CustomDTO customDTO= null;

        try {


            CustomEntity c = queryDAO.searchStudentID(studentID);
            customDTO = new CustomDTO(c.getStudentID(), c.getStudentName(), c.getStudentAddress(), c.getStudentContact(), c.getStudentDob(), c.getStudentGender(), c.getRegFee(), c.getRegDate());
            session.getTransaction().commit();
        }catch (Throwable t){
            session.getTransaction().rollback();
            throw t;
        }finally {
            session.close();
        }
        return customDTO;
    }

    @Override
    public List<CustomDTO> getSearchByStudent(String sid) throws Exception {
        return null;
    }

    @Override
    public List<CustomDTO> getAllReg() throws Exception {
        List<Registration> list=queryDAO.findAll();
        List<CustomDTO> customDTOS=new ArrayList<>();
        for (Registration c:list){
            customDTOS.add(new CustomDTO(
                    c.getRegNumber(),
                    c.getStudent().getStudentID(),
                    c.getCourse().getCourseID(),
                    c.getRegFee()
            ));
        }
        return customDTOS;
    }

    @Override
    public boolean updateReg(RegistrationDTO reg) throws Exception {
//        Registration r=new Registration();
//        r.setRegNumber(registrationDTO.getRegNumber());
//        r.setCourse(registrationDTO.getCourseID());
//        r.setStudent(registrationDTO.getStudentID());


        return registrationDAO.update(
          new Registration(
                  reg.getRegNumber(),reg.getStudentID(),reg.getCourseID(),reg.getRegFee()
          )
        );
    }

    @Override
    public String loadRegistrationID() throws Exception {
        return registrationDAO.getlastID();
    }

    @Override
    public String loadStudentID() throws Exception {
        return studentDAO.getStudentID();
    }

    @Override
    public boolean addReRegStudent(RegistrationDTO reg) throws Exception {
        Registration r=new Registration();
        r.setRegNumber(reg.getRegNumber());
        r.setRegDate(reg.getRegDate());
        r.setRegFee(reg.getRegFee());
        r.setStudent(new Student(reg.getStudentID()));
        r.setCourse(new Course(reg.getCourseID()));

        registrationDAO.addReRegStudent(r);

        System.out.println("Malindu Error"+r);
        return true;
    }

    @Override
    public boolean deleteStudent(CustomDTO customDTO) throws Exception {
//        Registration registration=new Registration();
//        registration.setRegNumber(customDTO.getRegNumber());
//        registration.setRegDate(customDTO.getRegDate());
//        registration.setRegFee(customDTO.getRegFee());
//        registration.setStudent(new Student(customDTO.getStudentID()));
//        registration.setCourse(new Course(customDTO.getCourseID()));
//
//        registrationDAO.delete(registration);
//

        Student student=new Student();
        student.setStudentID(customDTO.getStudentID());
        student.setStudentName(customDTO.getStudentName());
        student.setStudentAddress(customDTO.getStudentAddress());
        student.setStudentContact(customDTO.getStudentContact());
        student.setStudentDob(customDTO.getStudentDob());
        student.setStudentGender(customDTO.getStudentGender());

        studentDAO.delete(student);
        //studentDAO.deleteStudent(customDTO)
        return true;
    }

}
