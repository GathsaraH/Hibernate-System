package com.zenixo.hibernate.dto;

import java.util.ArrayList;
import java.util.Date;

/**
 * @author Gathsara Umesh on 2/12/2021
 * @project Hibernate-Course-Work
 */
public class StudentDTO {
    String studentID;
    String studentName;
    String studentAddress;
    String studentContact;
    String studentDob;
    String studentGender;

    public StudentDTO(String studentID, String studentName, String studentAddress, String studentContact, String studentDob, String studentGender) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.studentAddress = studentAddress;
        this.studentContact = studentContact;
        this.studentDob = studentDob;
        this.studentGender = studentGender;
    }

    public StudentDTO() {
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }

    public String getStudentContact() {
        return studentContact;
    }

    public void setStudentContact(String studentContact) {
        this.studentContact = studentContact;
    }

    public String getStudentDob() {
        return studentDob;
    }

    public void setStudentDob(String studentDob) {
        this.studentDob = studentDob;
    }

    public String getStudentGender() {
        return studentGender;
    }

    public void setStudentGender(String studentGender) {
        this.studentGender = studentGender;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "studentID='" + studentID + '\'' +
                ", studentName='" + studentName + '\'' +
                ", studentAddress='" + studentAddress + '\'' +
                ", studentContact='" + studentContact + '\'' +
                ", studentDob='" + studentDob + '\'' +
                ", studentGender='" + studentGender + '\'' +
                '}';
    }
}
