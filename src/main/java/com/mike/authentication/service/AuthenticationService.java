package com.mike.authentication.service;

import com.mike.authentication.entity.User;
import com.mike.authentication.model.LoginInfo;

import java.util.Optional;

/**
 * @Description:
 * @Author: Mike Dong
 * @Date: 2019/11/30 9:43.
 */
public interface AuthenticationService {

    Optional<User> findByUserNameAndPassWord(LoginInfo loginInfo);
}
