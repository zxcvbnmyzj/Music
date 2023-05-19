package com.yohane.test.controller;

import com.yohane.test.dao.Data.DTO.LoginUser;
import com.yohane.test.dao.Data.DTO.QueryDTO;
import com.yohane.test.dao.Data.ResponseCode.ResponseCode;
import com.yohane.test.dao.Data.ResponseCode.Result;
import com.yohane.test.dao.Data.pojo.User;
import com.yohane.test.service.MainService.MainServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created on 2023/4/13
 *
 * @Time 9:53
 * @Program test
 * @Author YoHaNe/XiaoShuai
 */
@Controller
public class mainServiceController {

    @Autowired
    private MainServiceImpl mainService;

    //@CrossOrigin 后端跨域
    @PostMapping("/api/login")
    @CrossOrigin
    public @ResponseBody Result login(@RequestBody LoginUser loginUser){
        return mainService.login(loginUser);
    }

    @PostMapping("/api/user/list")
    @CrossOrigin
    public @ResponseBody Result userList(@RequestBody QueryDTO queryDTO){
        return new Result(ResponseCode.OK,"",mainService.selectUserPage(queryDTO));
    }

    @PostMapping("/api/user/add")
    @CrossOrigin
    public @ResponseBody Result addUser(@RequestBody User user){
        return new Result(ResponseCode.OK,"",mainService.addUser(user));
    }

    @PostMapping("/api/user/update")
    @CrossOrigin
    public @ResponseBody Result updateUser(@RequestBody User user){
        return new Result(ResponseCode.OK,"",mainService.updateUser(user));
    }

    @PostMapping("/api/user/delete")
    @CrossOrigin
    public @ResponseBody Result deleteUser(Integer id){
        return new Result(ResponseCode.OK,"",mainService.deleteUser(id));
    }

    @PostMapping("/api/user/delete/batch")
    @CrossOrigin
    public @ResponseBody Result batchDeleteUser(@RequestBody List<Integer> ids){
        mainService.batchDelete(ids);
        return new Result(ResponseCode.OK,"","");
    }
}
