package com.yohane.test.service.MainService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created on 2023/5/16
 *
 * @Time 20:29
 * @Program test
 * @Author YoHaNe/XiaoShuai
 */
@Service
@Transactional
public class VideoServiceImpl implements VideoService {


    @Override
    public byte[] getMusicById(Integer id) {
        return new byte[0];
    }

//    private String getMusicURL(Integer id){
//
//    }
}
