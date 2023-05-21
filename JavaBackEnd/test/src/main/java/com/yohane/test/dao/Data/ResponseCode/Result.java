package com.yohane.test.dao.Data.ResponseCode;

import com.sun.xml.internal.ws.developer.Serialization;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * Created on 2023/4/13
 *
 * @Time 9:56
 * @Program test
 * @Author YoHaNe/XiaoShuai
 */
@Data
@AllArgsConstructor
public class Result implements Serializable {

    private static final long serialVersionUID = -1160305195842100549L;

    private Integer code;

    private String message;

    private Object data;

}
