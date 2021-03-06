package com.zenixo.hibernate.dto;

/**
 * @author Gathsara Umesh on 2/10/2021
 * @project Hibernate-Course-Work
 */
public class CourseDTO {
    String courseID;
    String courseName;
    String courseType;
    String courseDuration;

    public CourseDTO(String courseID, String courseName, String courseType, String courseDuration) {
        this.courseID = courseID;
        this.courseName = courseName;
        this.courseType = courseType;
        this.courseDuration = courseDuration;
    }

    public CourseDTO() {
    }

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public String getCourseDuration() {
        return courseDuration;
    }

    public void setCourseDuration(String courseDuration) {
        this.courseDuration = courseDuration;
    }

    @Override
    public String toString() {
        return "CourseDTO{" +
                "courseID='" + courseID + '\'' +
                ", courseName='" + courseName + '\'' +
                ", courseType='" + courseType + '\'' +
                ", courseDuration='" + courseDuration + '\'' +
                '}';
    }
}
