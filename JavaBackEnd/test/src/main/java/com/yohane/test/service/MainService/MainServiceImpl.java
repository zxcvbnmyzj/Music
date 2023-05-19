package com.yohane.test.service.MainService;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yohane.test.dao.Data.DTO.LoginUser;
import com.yohane.test.dao.Data.DTO.QueryDTO;
import com.yohane.test.dao.Data.ResponseCode.ResponseCode;
import com.yohane.test.dao.Data.ResponseCode.Result;
import com.yohane.test.dao.Data.VO.LoginVo;
import com.yohane.test.dao.Data.pojo.User;
import com.yohane.test.dao.mybatis.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.StringUtils;

import java.util.List;
import java.util.UUID;

/**
 * Created on 2023/4/13
 *
 * @Time 9:54
 * @Program test
 * @Author YoHaNe/XiaoShuai
 */
@Service
@Transactional
public class MainServiceImpl implements MainService {

    @Autowired
    private UserMapper userMapper;



    @Override
    public Result login(LoginUser loginUser) {
        if(StringUtils.isEmpty(loginUser.getLoginName()) || StringUtils.isEmpty(loginUser.getPassword()))
            return new Result(ResponseCode.BAD_REQUEST,"账号或密码不能空","");
        User user = userMapper.selectByOne(loginUser.getLoginName());
        if(user!=null && user.getPassword().equals(loginUser.getPassword())) {
            LoginVo loginVo = new LoginVo();
            loginVo.setId(user.getId());
            //这里token直接用一个uuid
            //使用jwt的情况下，会生成一个jwt token,jwt token里会包含用户的信息
            loginVo.setToken(UUID.randomUUID().toString());
            loginVo.setUser(user);
            return new Result(ResponseCode.OK, "登陆成功", loginVo);
        }
        return new Result(ResponseCode.UNAUTHORIZED,"登陆失败","");
    }


    /**
     * 分页查询
     * @param queryDTO
     * @return
     */
    @Cacheable(cacheNames = "userPage",
            key = "#queryDTO.pageNo.toString() + #queryDTO.pageSize.toString()" +
                    " + #queryDTO.keyword.toString()")
    @Override
    public IPage<User> selectUserPage(QueryDTO queryDTO){
        Page<User> page = new Page<>(queryDTO.getPageNo(),queryDTO.getPageSize());
        return userMapper.selectUserPage(page,queryDTO.getKeyword());
    }

    @Override
    public Integer addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public Integer updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public Integer deleteUser(Integer id) {
        return userMapper.deleteUser(id);
    }

    @Override
    public void batchDelete(List<Integer> ids) {
        userMapper.batchDelete(ids);
    }

}
