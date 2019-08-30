package com.company.models;



public class User {
    private Integer id;
    private String userName;
    private String email;
    private String password;
    private Integer group_id;

    public User(String userName, String email, String password, Integer group_id) {
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.group_id = group_id;
    }

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Integer getGroup_id() {
        return group_id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setGroup_id(Integer group_id) {
        this.group_id = group_id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", group_id=" + group_id +
                '}';
    }
}
