package com.kkjz.service;

import com.kkjz.pojo.User;
/**
 * @author kkjz
 * @create 2022-08-25 16:47
 */
public interface UserListService {

    /**
     *
     * 判断用户是否存在，若是存在返回该用户信息类
     * 否则返回null
     * @param username
     * @param password
     */
     User userLogin(String username,String password);

    /**
     * 根据UserID改变用户的userHand
     */

    Integer changeUserHand(String userID,String userHandPath);

    /**
     * 根据用户名查询用户ID
     * @param username
     * @return
     */
    String findUseID(String username);

    /**
     * 根据userID查询用户所有信息
     * @param userID
     * @return
     */
    User getUser(String userID);

    /**
     * update更新用户信息
     * @param user
     * @return
     */
    Integer updateUserbyUser(User user);

    /**
     * 用户注册
     * @param user
     * @return
     */
    Integer register(User user);


}
