package com.yohane.test.dao.mybatis;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.yohane.test.dao.Data.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created on 2023/4/10
 *
 * @Time 10:50
 * @Program test
 * @Author YoHaNe/XiaoShuai
 */

@Repository
//@CacheNamespace(implementation = RedisCache.class,eviction = RedisCache.class)
public interface UserMapper {

    IPage<User> selectUserPage(Page<User> page, String keyword);

    User selectByOne(String name);

    User select(@Param("id") Integer userId);

    List<User> selectAll();

    void update(User user);

    Integer addUser(User user);

    Integer updateUser(User user);

    Integer deleteUser(Integer id);

    void batchDelete(List<Integer> ids);

    Integer loginCheck(@Param("name") String user,@Param("pass") String password);
}
