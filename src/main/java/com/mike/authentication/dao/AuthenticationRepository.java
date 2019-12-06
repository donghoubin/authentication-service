package com.mike.authentication.dao;

import com.mike.authentication.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * @Description:
 * @Author: Mike Dong
 * @Date: 2019/11/30 9:47.
 */
public interface AuthenticationRepository extends CrudRepository<User, Long> {

    Optional<User> findByUserNameAndPassWord(String userName, String passWord);

}
