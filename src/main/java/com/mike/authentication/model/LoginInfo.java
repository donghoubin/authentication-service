package com.mike.authentication.model;

/**
 * @Description:
 * @Author: Mike Dong
 * @Date: 2019/11/30 9:29.
 */
public class LoginInfo {

    private String username;

    private String password;

    public LoginInfo(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
