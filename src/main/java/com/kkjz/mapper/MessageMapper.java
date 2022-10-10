package com.kkjz.mapper;

import com.kkjz.pojo.Message;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MessageMapper {
    int deleteByPrimaryKey(String messageID);

    int deleteByVideoID(String videoID);

    int insert(Message record);

    Message selectByPrimaryKey(String messageID);

    List<Message> selectAll();

    int updateByPrimaryKey(Message record);

    List<Message> selectByvideoIDAndPage(@Param("videoid") String videoid,@Param("index") int index);

    Integer updateAllHandimg(@Param("messageuserID") String messageuserID,@Param("messageHand") String messageHand);

    Integer getAllCount(String videoID);
}