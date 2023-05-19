package com.yohane.test.service.MainService;

import com.yohane.test.dao.Data.ResponseCode.Result;

/**
 * Created on 2023/5/17
 *
 * @Time 19:55
 * @Program test
 * @Author YoHaNe/XiaoShuai
 */
public interface MusicService {

    Result getAllMusic();

    Result selectMusic(String name,String singer);

}
