package com.yohane.test.dao.Data.DTO;

import lombok.Data;

/**
 * Created on 2023/4/16
 *
 * @Time 1:37
 * @Program test
 * @Author YoHaNe/XiaoShuai
 */
@Data
public class QueryDTO {
    /**
     * 页码
     */
    private Integer pageNo;

    private Integer pageSize;

    /**
     * 关键字
     */
    private String keyword;
}
