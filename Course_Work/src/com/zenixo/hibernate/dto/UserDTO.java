package com.zenixo.hibernate.dto;

/**
 * @author Gathsara Umesh on 2/16/2021
 * @project Hibernate-Course-Work
 */
public class UserDTO {
    private String uid;
    private String name;
    private String userName;
    private String password;

    public UserDTO() {
    }

    public UserDTO(String uid, String name, String userName, String password) {
        this.uid = uid;
        this.name = name;
        this.userName = userName;
        this.password = password;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
