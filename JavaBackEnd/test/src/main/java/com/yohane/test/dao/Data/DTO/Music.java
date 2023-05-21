package com.yohane.test.dao.Data.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

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
public class Music implements Serializable {

    private static final long serialVersionUID = -4318432174393977278L;

    Integer id;

    String musicName;

    String musicSinger;

    String musicUrl;

}
