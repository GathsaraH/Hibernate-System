package com.zenixo.hibernate.dto;

/**
 * @author Gathsara Umesh on 2/13/2021
 * @project Hibernate-Course-Work
 */
public class CustomDTO {
    String studentID;
    String studentName;
    String studentAddress;
    String studentContact;
    String studentDob;
    String studentGender;
    String regNumber;
    String regDate;
    double regFee;
    String CourseID;

    public CustomDTO(String studentID, String regNumber, String studentName, String studentAddress, String studentDob, String studentGender, String regDate, String CourseID, String studentContact, double regFee) {
        this.studentID=studentID;
        this.regNumber=regNumber;
        this.studentName=studentName;
        this.studentAddress=studentAddress;
        this.studentDob=studentDob;
        this.studentGender=studentGender;
        this.regDate=regDate;
        this.CourseID=CourseID;
        this.studentContact=studentContact;
        this.regFee=regFee;
    }


    public CustomDTO(String studentID, String studentName, String studentAddress, String studentContact, String studentDob, String studentGender, String regNumber, String regDate, double regFee, String courseID) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.studentAddress = studentAddress;
        this.studentContact = studentContact;
        this.studentDob = studentDob;
        this.studentGender = studentGender;
        this.regNumber = regNumber;
        this.regDate = regDate;
        this.regFee = regFee;
        CourseID = courseID;
    }

    public CustomDTO() {
    }



    public CustomDTO(String studentID, String studentName, String studentAddress, String studentContact, String studentDob, String studentGender, double regFee, String regDate) {
        this.studentID=studentID;
        this.studentName=studentName;
        this.studentAddress=studentAddress;
        this.studentContact=studentContact;
        this.studentDob=studentDob;
        this.studentGender=studentGender;
        this.regFee=regFee;
        this.regDate=regDate;

    }



    public CustomDTO(String regNumber, String studentID, String CourseID, double regFee) {
        this.regNumber=regNumber;
        this.studentID=studentID;
        this.CourseID=CourseID;
        this.regFee=regFee;
    }

    public CustomDTO(String studentID, String studentName, String courseID) {
        this.studentID = studentID;
        this.studentName = studentName;
        CourseID = courseID;
    }



    //    public CustomDTO(String studentName, String studentID, String courseID) {
//        this.studentName=studentName;
//     this.studentID=studentID;
//     this.courseID=courseID;
//    }

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

    public String getCourseID() {
        return CourseID;
    }

    public void setCourseID(String courseID) {
        CourseID = courseID;
    }

    @Override
    public String toString() {
        return "CustomDTO{" +
                "studentID='" + studentID + '\'' +
                ", studentName='" + studentName + '\'' +
                ", studentAddress='" + studentAddress + '\'' +
                ", studentContact='" + studentContact + '\'' +
                ", studentDob='" + studentDob + '\'' +
                ", studentGender='" + studentGender + '\'' +
                ", regNumber='" + regNumber + '\'' +
                ", regDate='" + regDate + '\'' +
                ", regFee=" + regFee +
                ", CourseID='" + CourseID + '\'' +
                '}';
    }
}
