package com.mike.authentication.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * @Description:
 * @Author: Mike Dong
 * @Date: 2019/11/30 9:48.
 */
@Entity
@Table(name="user")
@Data
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @Column(name = "username")
    private String userName;

    @Column(name = "password")
    private String passWord;

    @Column(name = "usertype")
    private String userType;

    @Column(name="email")
    private String email;

    @Column(name = "mobilenumber")
    private String mobileNumber;

    @Column(name = "confirmed")
    private char confirmed;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public char getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(char confirmed) {
        this.confirmed = confirmed;
    }
}
