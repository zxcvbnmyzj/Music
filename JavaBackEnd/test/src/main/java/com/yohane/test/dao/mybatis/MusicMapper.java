package com.yohane.test.dao.mybatis;

import com.yohane.test.dao.Data.DTO.Music;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created on 2023/5/16
 *
 * @Time 20:35
 * @Program test
 * @Author YoHaNe/XiaoShuai
 */
@Repository
public interface MusicMapper {

    List<Music> getAllMusic();

    Integer selectMusic(@Param("name") String name,@Param("singer") String singer);

    Integer AddListMusic();


}
