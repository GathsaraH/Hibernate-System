package com.zenixo.hibernate.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @author Gathsara Umesh on 2/10/2021
 * @project Hibernate-Course-Work
 */
@Entity
@Table(name = "Student" )
public class Student implements SuperEntity{

    @Id
    String studentID;
    String studentName;
    String studentAddress;
    String studentContact;
    String studentDob;
    String studentGender;
    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL)
                
    List<Registration> registrations;

    public Student(String studentID, String studentName, String studentAddress, String studentContact, String studentDob, String studentGender) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.studentAddress = studentAddress;
        this.studentContact = studentContact;
        this.studentDob = studentDob;
        this.studentGender = studentGender;
    }

    public Student(String studentID) {
        this.studentID = studentID;
    }

    public Student(String studentID, String studentName, String studentAddress, String studentContact, String studentDob, String studentGender, List<Registration> registrations) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.studentAddress = studentAddress;
        this.studentContact = studentContact;
        this.studentDob = studentDob;
        this.studentGender = studentGender;
        this.registrations = registrations;
    }

    public Student() {
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

    public List<Registration> getRegistrations() {
        return registrations;
    }

    public void setRegistrations(List<Registration> registrations) {
        this.registrations = registrations;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentID='" + studentID + '\'' +
                ", studentName='" + studentName + '\'' +
                ", studentAddress='" + studentAddress + '\'' +
                ", studentContact='" + studentContact + '\'' +
                ", studentDob='" + studentDob + '\'' +
                ", studentGender='" + studentGender + '\'' +
                ", registrations=" + registrations +
                '}';
    }
}
