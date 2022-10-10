package com.kkjz.service.impl;

import com.kkjz.mapper.MessageMapper;
import com.kkjz.pojo.Message;
import com.kkjz.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author kkjz
 * @create 2022-09-05 19:31
 */
@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    MessageMapper messageMapper;

    @Override
    public List<Message> messageVideoByIDAndPage(String videoID,int page) {
        //把页换成index
        page = (page - 1) * 5;
        return messageMapper.selectByvideoIDAndPage(videoID,page);
    }

    @Override
    public Integer addMessage(Message message) {
        return messageMapper.insert(message);
    }

    @Override
    public Integer delByvideoID(String videoID) {
        return messageMapper.deleteByVideoID(videoID);
    }

    @Override
    public Integer updateHandimg(String userID, String handImgPath) {
        return messageMapper.updateAllHandimg(userID,handImgPath);
    }

    @Override
    public Integer getAllCountByVideoID(String videoID) {
        return messageMapper.getAllCount(videoID);
    }
}
