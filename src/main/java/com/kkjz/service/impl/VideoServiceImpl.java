package com.kkjz.service.impl;

import com.kkjz.mapper.VideoMapper;
import com.kkjz.pojo.Video;
import com.kkjz.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author kkjz
 * @create 2022-08-25 17:07
 */
@Service
public class VideoServiceImpl implements VideoService {

    //dao装载
    @Autowired
    VideoMapper videoMapper;

    @Override
    public List<Video> videoBycategoryWithlimit(char category, Integer limit) {
        return videoMapper.selectByVideoCategory(category, limit);
    }

    @Override
    public Video videoByID(String id) {
        return videoMapper.selectByPrimaryKey(id);
    }

    @Override
    public Integer uploadVideo(Video video) {
        return videoMapper.insert(video);
    }

    @Override
    public Integer delVideoByVideoIDAndUserID(String videoID, String userID) {
        Video video = videoMapper.selectByPrimaryKey(videoID);
        // 多一步判断视频为用户所有
        if (video.getUserID().equals(userID))
            return videoMapper.deleteByPrimaryKey(videoID);
        return 0;
    }

    @Override
    public Integer getAllCountByUserID(String userID) {
        return videoMapper.getAllCount(userID);
    }

    @Override
    public List<Video> getVideoByPage(String userID, int page) {
        //给sql作index用
        page = (page - 1) * 5;
        return videoMapper.selectByPage(userID, page);
    }
}
