package com.yohane.test.dao.Data.VO;

import com.yohane.test.dao.Data.pojo.User;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created on 2023/4/13
 *
 * @Time 15:57
 * @Program test
 * @Author YoHaNe/XiaoShuai
 */
@Data
@NoArgsConstructor
public class LoginVo implements Serializable {
    private static final long serialVersionUID = -1166955294383953060L;

    private Integer id;
    private String token;
    private User user;
}
