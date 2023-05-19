package com.yohane.test.dao.Data.ResponseCode;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created on 2023/4/13
 *
 * @Time 9:56
 * @Program test
 * @Author YoHaNe/XiaoShuai
 */
@Data
@AllArgsConstructor
public class Result {

    private Integer code;

    private String message;

    private Object data;

}
