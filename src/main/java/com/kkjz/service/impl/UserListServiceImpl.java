package com.kkjz.service.impl;

import com.kkjz.mapper.UserMapper;
import com.kkjz.pojo.User;
import com.kkjz.service.UserListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author kkjz
 * @create 2022-09-03 17:03
 */
@Service
public class UserListServiceImpl implements UserListService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User userLogin(String username, String password) {
        User user = userMapper.cheakUserBynp(username,password);;
        return user;
    }

    @Override
    public Integer changeUserHand(String userID, String userHandPath) {
        Integer res = userMapper.updateHandimgByPrimaryKey(userID,userHandPath);
        System.out.println(res);
        return res;
    }

    @Override
    public String findUseID(String userName) {
        User user = userMapper.selectByUserName(userName);
        if (user == null) return null;
        return user.getUserID();
    }

    @Override
    public User getUser(String userID) {
        return userMapper.selectByPrimaryKey(userID);
    }

    @Override
    public Integer updateUserbyUser(User user) {
        return userMapper.updateByPrimaryKey(user);
    }

    @Override
    public Integer register(User user) {
        return userMapper.insert(user);
    }

}
