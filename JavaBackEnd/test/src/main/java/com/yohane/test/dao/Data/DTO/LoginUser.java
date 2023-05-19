package com.yohane.test.dao.Data.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Created on 2023/4/13
 *
 * @Time 10:21
 * @Program test
 * @Author YoHaNe/XiaoShuai
 */
@Data
@Getter
@Setter
public class LoginUser {

    private String loginName;

    private String password;

}
