package com.zenixo.hibernate.bussiness.custom;

import com.zenixo.hibernate.bussiness.SuperBO;
import com.zenixo.hibernate.dto.CustomDTO;

import java.util.List;

/**
 * @project Hibernate-Course-Work
 * @author Gathsara Umesh on 2/15/2021
 *
 */public interface StudentDatailsBO extends SuperBO {
     List<CustomDTO> getAllStudentDatails(String id) throws Exception;
}
