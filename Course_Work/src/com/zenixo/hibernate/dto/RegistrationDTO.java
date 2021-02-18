package com.zenixo.hibernate.dto;

import java.time.LocalDate;

/**
 * @author Gathsara Umesh on 2/12/2021
 * @project Hibernate-Course-Work
 */
public class RegistrationDTO {
    String regNumber;
    String regDate;
    double regFee;
    String studentID;
    String CourseID;

    public RegistrationDTO(String regNumber, String regDate, double regFee, String studentID, String courseID) {
        this.regNumber = regNumber;
        this.regDate = regDate;
        this.regFee = regFee;
        this.studentID = studentID;
        CourseID = courseID;
    }

    public RegistrationDTO() {
    }




    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public double getRegFee() {
        return regFee;
    }

    public void setRegFee(double regFee) {
        this.regFee = regFee;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getCourseID() {
        return CourseID;
    }

    public void setCourseID(String courseID) {
        CourseID = courseID;
    }

    @Override
    public String toString() {
        return "RegistrationDTO{" +
                "regNumber='" + regNumber + '\'' +
                ", regDate='" + regDate + '\'' +
                ", regFee=" + regFee +
                ", studentID='" + studentID + '\'' +
                ", CourseID='" + CourseID + '\'' +
                '}';
    }
}
