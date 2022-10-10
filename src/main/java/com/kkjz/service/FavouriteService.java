package com.kkjz.service;

import com.kkjz.pojo.Favourite;

import java.util.List;

/**
 * @author kkjz
 * @create 2022-09-23 20:05
 */
public interface FavouriteService {
    List<Favourite> getFavouriteList(String userID,int page);

    /**
     * 获取条目数
     * 可以让videoID = null 来获取所有userID的条目数
     * @param userID
     * @param videoID
     * @return
     */
    Integer getCountByID(String userID,String videoID);

    /**
     * 增加一条收藏记录
     * @param favourite
     * @return
     */
    Integer addRecode(Favourite favourite);

    /**
     * 删除一条收藏记录
     * @param userID
     * @param videoID
     * @return
     */
    Integer deleRecode(String userID,String videoID);

    /**
     * 把对应视频下的收藏全部删除
     * @param videoID
     * @return
     */
    Integer deleByvideoID(String videoID);

    Favourite getFavouriteByFavouriteID(String favouriteID);
}
