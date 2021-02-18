package com.zenixo.hibernate.entity;

import javax.persistence.*;

/**
 * @author Gathsara Umesh on 2/10/2021
 * @project Hibernate-Course-Work
 */
@Entity
public class Registration implements SuperEntity{
    @Id
    String regNumber;
    String regDate;
    double regFee;
    @ManyToOne
    @JoinColumn(name = "studentID", referencedColumnName = "studentID")
    private Student student;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "courseID", referencedColumnName = "courseID")
    private Course course;

    public Registration(String regNumber, String regDate, double regFee, Student student, Course course) {
        this.regNumber = regNumber;
        this.regDate = regDate;
        this.regFee = regFee;
        this.student = student;
        this.course = course;
    }

    public Registration() {
    }

    public Registration(String regNumber, String studentID, String courseID, double regFee) {
        this.regNumber=regNumber;

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

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Registration{" +
                "regNumber='" + regNumber + '\'' +
                ", regDate='" + regDate + '\'' +
                ", regFee=" + regFee +
                ", student=" + student +
                ", course=" + course +
                '}';
    }
}
