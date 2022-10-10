package com.kkjz.service.impl;

import com.kkjz.mapper.FavouriteMapper;
import com.kkjz.pojo.Favourite;
import com.kkjz.service.FavouriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author kkjz
 * @create 2022-09-23 20:05
 */
@Service
public class FavouriteServiceImpl implements FavouriteService {
    @Autowired
    FavouriteMapper favouriteMapper;


    @Override
    public List<Favourite> getFavouriteList(String userID, int page) {
        //给sql作index用
        page =(page - 1)*5;
        return favouriteMapper.selectByPage(userID,page);
    }

    @Override
    public Integer getCountByID(String userID, String videoID) {
        return favouriteMapper.getCount(userID,videoID);
    }

    @Override
    public Integer addRecode(Favourite favourite) {
        return favouriteMapper.insert(favourite);
    }

    @Override
    public Integer deleRecode(String userID, String videoID) {
        //多一步用户验证
        Favourite favourite = favouriteMapper.selectByVideoIDAndUserID(userID,videoID);
        int res =favouriteMapper.deleteByPrimaryKeyOrVideoID(Integer.toString(favourite.getFavouriteID()),null);
        return res;
    }

    @Override
    public Integer deleByvideoID(String videoID) {
        return favouriteMapper.deleteByPrimaryKeyOrVideoID(null,videoID);
    }

    @Override
    public Favourite getFavouriteByFavouriteID(String favouriteID) {
        return favouriteMapper.selectByPrimaryKey(favouriteID);
    }
}
