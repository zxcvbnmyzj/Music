package com.yohane.test.service.MainService;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.yohane.test.dao.Data.DTO.LoginUser;
import com.yohane.test.dao.Data.DTO.QueryDTO;
import com.yohane.test.dao.Data.ResponseCode.Result;
import com.yohane.test.dao.Data.pojo.User;

import java.util.List;

/**
 * Created on 2023/4/13
 *
 * @Time 9:54
 * @Program test
 * @Author YoHaNe/XiaoShuai
 */
public interface MainService {

    public Result login(LoginUser loginUser);

    public IPage<User> selectUserPage(QueryDTO queryDTO);

    public Integer addUser(User user);

    public Integer updateUser(User user);

    public Integer deleteUser(Integer id);

    public void batchDelete(List<Integer> ids);
}
