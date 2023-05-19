package com.yohane.test.dao.Data.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created on 2023/5/17
 *
 * @Time 19:51
 * @Program test
 * @Author YoHaNe/XiaoShuai
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Music {

    Integer id;

    String musicName;

    String musicSinger;

    String musicUrl;

}
