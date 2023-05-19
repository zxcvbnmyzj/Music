package com.yohane.test.controller;

import com.yohane.test.dao.Data.pojo.User;
import com.yohane.test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created on 2023/4/10
 *
 * @Time 10:41
 * @Program test
 * @Author YoHaNe/XiaoShuai
 */
@RestController
@RequestMapping("/user")
public class userController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String loginCheck(String name,String pass){
        return userService.newLogin(name,pass);
    }

    @GetMapping("/getUser/{id}")
    public User getUserInfo(@PathVariable("id") Integer userId){
        return userService.selectUser(userId);
    }

    @GetMapping("/getAllUser")
    public List<User> getAllUser(){
        return userService.selectAllUser();
    }


    @PutMapping("/{id}")
    public void updateUserInfo(@PathVariable("id") Integer userId,@RequestBody User newUser){
        userService.updateUser(newUser);
    }



}
