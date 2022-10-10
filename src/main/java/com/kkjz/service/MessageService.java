package com.kkjz.service;

import com.kkjz.pojo.Message;

import java.util.List;

/**
 * @author kkjz
 * @create 2022-09-05 19:27
 */
public interface MessageService {

    /**
     *  根据messagevideoID查询评论
     */
    List<Message> messageVideoByIDAndPage(String videoID,int page);

    Integer addMessage(Message message);

    Integer delByvideoID(String videoID);

    Integer updateHandimg(String userID,String handImgPath);

    /**
     * 查询该视频下评论的总数
     * @param videoID
     * @return
     */
    Integer getAllCountByVideoID(String videoID);
}
