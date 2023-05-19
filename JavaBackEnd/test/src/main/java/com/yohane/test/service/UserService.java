package com.yohane.test.service;

import com.yohane.test.dao.mybatis.UserMapper;
import com.yohane.test.dao.Data.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created on 2023/4/10
 *
 * @Time 10:54
 * @Program test
 * @Author YoHaNe/XiaoShuai
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public String newLogin(String name, String pass) {
        Integer rs = null;
        String result = null;
        try {
            if((rs = userMapper.loginCheck(name,pass)) <= 0)
                return "fail";
            result = "success";
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    public User selectUser(Integer id){
        return userMapper.select(id);
    }

    public List<User> selectAllUser(){
        return userMapper.selectAll();
    }


    public void updateUser(User newUser){
        userMapper.update(newUser);
    }

}
