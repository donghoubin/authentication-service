package com.mike.authentication.controller;

import com.mike.authentication.entity.User;
import com.mike.authentication.model.LoginInfo;
import com.mike.authentication.model.LoginResponseInfo;
import com.mike.authentication.model.VerifyResponseInfo;
import com.mike.authentication.service.AuthenticationService;
import com.mike.authentication.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * @Description:
 * @Author: Mike Dong
 * @Date: 2019/11/29 23:22.
 */
@Controller
//@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseInfo> login(@RequestBody LoginInfo loginInfo) {
        Optional<User> user = authenticationService.findByUserNameAndPassWord(loginInfo);
        LoginResponseInfo loginResponseInfo = new LoginResponseInfo();
        if(user.isPresent() && user.get().getConfirmed() == '1') {
            String jwt = JWTUtil.generateToken(loginInfo.getUsername());
            loginResponseInfo.setToken(jwt);
            loginResponseInfo.setRole(user.get().getUserType());
            loginResponseInfo.setResponseState("success");
            loginResponseInfo.setId(user.get().getId());
        } else {
            loginResponseInfo.setResponseState("fail");
        }
        return new ResponseEntity<>(loginResponseInfo, HttpStatus.OK);
    }

    @GetMapping(value = "/verify")
    public ResponseEntity<VerifyResponseInfo> verify(@RequestParam("token") String token ){
        VerifyResponseInfo verifyResponseInfo = new VerifyResponseInfo();
        if (JWTUtil.verify(token)){
            verifyResponseInfo.setResponseState("success");
        } else {
            verifyResponseInfo.setResponseState("fail");
        }
        return new ResponseEntity<>(verifyResponseInfo, HttpStatus.OK);
    }
}
