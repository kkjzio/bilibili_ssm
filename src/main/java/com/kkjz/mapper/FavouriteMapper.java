package com.kkjz.mapper;

import com.kkjz.pojo.Favourite;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author kkjz
 * @create 2022-09-23 14:52
 */
public interface FavouriteMapper {
    int deleteByPrimaryKeyOrVideoID(@Param("favouriteID") String favouriteID,@Param("videoID") String videoID);

    Integer insert(Favourite favourite);

    Favourite selectByPrimaryKey(String favouriteID);

    Integer updateByPrimaryKey(Favourite favourite);

    List<Favourite> selectByPage(@Param("userID") String userID,@Param("indexNum") int indexNum);

    Integer getCount(@Param("userID") String userID,@Param("videoID") String videoID);

    Favourite selectByVideoIDAndUserID(@Param("userID") String userID,@Param("videoID") String videoID);
}
