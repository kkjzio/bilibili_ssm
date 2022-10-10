package com.kkjz.mapper;

import com.kkjz.pojo.Favourite;
import com.kkjz.pojo.Video;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VideoMapper {
    int deleteByPrimaryKey(String videoID);

    Integer insert(Video record);

    Video selectByPrimaryKey(String videoID);

    List<Video> selectAll();

    int updateByPrimaryKey(Video record);

    List<Video> selectByVideoCategory(@Param("videoCategory") char videoCategory, @Param("limitNum") Integer limitNum);

    List<Video> selectByPage(@Param("userID") String userID, @Param("indexNum") int indexNum);

    Integer getAllCount(@Param("userID") String userID);
}