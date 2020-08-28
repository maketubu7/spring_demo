package com.make.dao;

import com.make.model.heroGamesDAO;
import com.make.model.heroGamesDAOKey;

public interface heroGamesDAOMapper {
    int deleteByPrimaryKey(heroGamesDAOKey key);

    int insert(heroGamesDAO record);

    int insertSelective(heroGamesDAO record);

    heroGamesDAO selectByPrimaryKey(heroGamesDAOKey key);

    int updateByPrimaryKeySelective(heroGamesDAO record);

    int updateByPrimaryKey(heroGamesDAO record);
}