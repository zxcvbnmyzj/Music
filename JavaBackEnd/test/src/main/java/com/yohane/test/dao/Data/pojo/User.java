package com.yohane.test.dao.Data.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created on 2023/4/10
 *
 * @Time 10:34
 * @Program test
 * @Author YoHaNe/XiaoShuai
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User implements Serializable {

    private static final long serialVersionUID = -8661935845232817268L;

    private Integer id;

    private String name;

    private String password;

    private String sex;

    private String email;

    private String state;

}
