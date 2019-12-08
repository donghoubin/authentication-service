package com.mike.authentication.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.mike.authentication.model.LoginInfo;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.Cookie;

import static org.junit.Assert.*;

/**
 * @Description:
 * @Author: Mike Dong
 * @Date: 2019/12/7 17:58.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AuthenticationControllerTest {

    @Autowired
    private WebApplicationContext wac;

    public MockMvc mvc;
    public MockHttpSession session;
    public Cookie[] cookies = new Cookie[1];

    @Before
    public void before() throws Exception {
        mvc = MockMvcBuilders.webAppContextSetup(wac).build();
        session = new MockHttpSession();
        cookies[0] = new Cookie("mykey", "myvalue");
    }

    @Test
    public void login() throws Exception{
        LoginInfo loginInfo = new LoginInfo("admin","admin");
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson = ow.writeValueAsString(loginInfo);
        mvc.perform(MockMvcRequestBuilders.post( "/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestJson)
        ).andExpect(MockMvcResultMatchers.status().isOk());
    }
}