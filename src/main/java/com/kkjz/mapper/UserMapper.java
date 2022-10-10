package com.kkjz.mapper;

import com.kkjz.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(String userID);

    int insert(User record);

    User selectByPrimaryKey(String userID);

    List<User> selectAll();

    Integer updateByPrimaryKey(User record);

    User cheakUserBynp(@Param("userName") String userName, @Param("passWord") String passWord);

    Integer updateHandimgByPrimaryKey(@Param("userID") String userID,@Param("userHand") String userHandPath);

    User selectByUserName(String UserName);
}