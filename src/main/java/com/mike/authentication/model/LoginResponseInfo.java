package com.mike.authentication.model;

/**
 * @Description:
 * @Author: Mike Dong
 * @Date: 2019/12/1 15:28.
 */
public class LoginResponseInfo {

    private long id;

    private String token;

    private String role;

    private String responseState;

    public String getResponseState() {
        return responseState;
    }

    public void setResponseState(String responseState) {
        this.responseState = responseState;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
