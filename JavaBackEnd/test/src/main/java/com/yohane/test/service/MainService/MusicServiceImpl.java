package com.yohane.test.service.MainService;

import com.yohane.test.dao.Data.DTO.Music;
import com.yohane.test.dao.Data.ResponseCode.ResponseCode;
import com.yohane.test.dao.Data.ResponseCode.Result;
import com.yohane.test.dao.mybatis.MusicMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created on 2023/5/17
 *
 * @Time 19:56
 * @Program test
 * @Author YoHaNe/XiaoShuai
 */
@Service
public class MusicServiceImpl implements MusicService {

    @Autowired
    MusicMapper musicMapper;

    @Override
    @Cacheable(cacheNames = "musicList")
    public Result getAllMusic() {
        Result rs = null;
        try {
            List<Music> result = musicMapper.getAllMusic();
            if(result == null || result.size() <= 0)
                rs = new Result(ResponseCode.BAD_REQUEST,"无数据",null);
            rs = new Result(ResponseCode.OK,"success",result);
        }catch (Exception e){
            e.printStackTrace();
            rs = new Result(ResponseCode.SERVER_ERROR,"error",null);
        }
        return rs;
    }

    @Override
    public Result selectMusic(String name, String singer) {
        Result rs = null;
        Integer result;
        try {
            if((result = musicMapper.selectMusic(name,singer) == null
                    ? 0 : musicMapper.selectMusic(name,singer)) > 0)
                return new Result(ResponseCode.BAD_REQUEST,"存在重复的歌曲",result);
            rs = new Result(ResponseCode.OK,"success",result);
        }catch (Exception e){
            e.printStackTrace();
            rs = new Result(ResponseCode.SERVER_ERROR,"error",null);
        }
        return rs;
    }

    @Override
    public Result addMusicOfList(List<Music> musicList) {
        Result rs = null;
        Integer result;
        try {
            if((result = musicMapper.AddListMusic(musicList)) <= 0)
                return new Result(ResponseCode.BAD_REQUEST,"添加失败,请稍后重试",result);
            rs = new Result(ResponseCode.OK,"success",result);
        }catch (Exception e){
            e.printStackTrace();
            rs = new Result(ResponseCode.SERVER_ERROR,"服务器错误",null);
        }
        return rs;
    }
}
