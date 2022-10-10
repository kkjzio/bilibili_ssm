package com.kkjz.service;

import com.kkjz.pojo.Video;

import java.util.List;

/**
 * @author kkjz
 * @create 2022-08-25 16:50
 */
public interface VideoService {

    /**
     * 根据视频分类返回指定数目的视频列表信息
     * category目前可取0 1 2 3 4， 0代表不分类
     * limit为0代表遍历该分类全部
     * @param category
     * @param limit
     * @return
     */
    List<Video> videoBycategoryWithlimit(char category,Integer limit);

    /**
     * 根据视频id获取video类
     */

    Video videoByID(String id);

    Integer uploadVideo(Video video);

    /**
     * 删除视频以及本体文件
     * @param videoID
     * @param userID
     * @return
     */
    Integer delVideoByVideoIDAndUserID(String videoID,String userID);

    /**
     * 获取所有已上传视频数
     * @param userID
     * @return
     */
    Integer getAllCountByUserID(String userID);

    List<Video> getVideoByPage(String userID,int page);
}
