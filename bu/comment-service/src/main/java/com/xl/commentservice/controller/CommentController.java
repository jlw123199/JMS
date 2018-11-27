package com.xl.commentservice.controller;

import com.xl.commentservice.dao.UserDao;
import com.xl.commentservice.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comment")

public class CommentController {

    @Autowired
    UserDao userDao;//= new UserDaoImpl();


    @RequestMapping(value = "/addUser")
    public UserEntity saveUser(@RequestBody UserEntity user) throws Exception {
        try {
            userDao.saveUser(user);
            UserEntity savedUser = userDao.findUserByUserName(user.getUserName());
            return savedUser;
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

    @RequestMapping(value = "/findUserByUserName")
    public UserEntity findUserByUserName(String userName) throws Exception {
        try {
            UserEntity user = userDao.findUserByUserName(userName);
            return user;
        } catch (Exception ex) {
            throw new Exception(ex.getMessage());
        }
    }

}
