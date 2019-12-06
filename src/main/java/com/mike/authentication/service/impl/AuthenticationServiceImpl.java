package com.mike.authentication.service.impl;

import com.mike.authentication.dao.AuthenticationRepository;
import com.mike.authentication.entity.User;
import com.mike.authentication.model.LoginInfo;
import com.mike.authentication.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @Description:
 * @Author: Mike Dong
 * @Date: 2019/11/30 9:47.
 */
@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private AuthenticationRepository authenticationRepository;

    @Override
    public Optional<User> findByUserNameAndPassWord(LoginInfo loginInfo) {

        return authenticationRepository.findByUserNameAndPassWord(loginInfo.getUsername(), loginInfo.getPassword());
    }
}
