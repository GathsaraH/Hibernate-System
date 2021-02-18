package com.zenixo.hibernate.bussiness.custom;

import com.zenixo.hibernate.bussiness.SuperBO;
import com.zenixo.hibernate.dto.CustomDTO;
import com.zenixo.hibernate.dto.RegistrationDTO;

import java.util.List;

/**
 * @author Gathsara Umesh on 2/14/2021
 * @project Hibernate-Course-Work
 */
public interface RegistrationBO  extends SuperBO {
    public CustomDTO  searchStudent(String studentID) throws Exception;
    List<CustomDTO> getSearchByStudent(String sid) throws Exception;
    public  List<CustomDTO>getAllReg()throws Exception;
    public boolean updateReg(RegistrationDTO registrationDTO) throws Exception;
    String loadRegistrationID() throws Exception;
    String loadStudentID() throws  Exception;
    public boolean addReRegStudent(RegistrationDTO registrationDTO)throws  Exception;
    public boolean deleteStudent(CustomDTO customDTO)throws  Exception;

}
