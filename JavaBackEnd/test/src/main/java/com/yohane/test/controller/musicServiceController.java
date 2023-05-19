package com.yohane.test.controller;

import com.yohane.test.dao.Data.DTO.Music;
import com.yohane.test.dao.Data.ResponseCode.Result;
import com.yohane.test.service.MainService.MusicServiceImpl;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created on 2023/5/17
 *
 * @Time 19:49
 * @Program test
 * @Author YoHaNe/XiaoShuai
 */
@RestController
@RequestMapping("/music")
public class musicServiceController {

    @Autowired
    MusicServiceImpl musicService;

    @GetMapping("/getAll")
    public Result getMusicAll(){
        return musicService.getAllMusic();
    }

    @GetMapping("/selectMusic")
    public Result selectMusic(String name,String singer){
        return musicService.selectMusic(name,singer);
    }


//    @PostMapping("/addMusicList")
//    public Result addMusicList(List<Music> musics){
//
//    }

}
