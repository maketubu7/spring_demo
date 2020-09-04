package com.make.dao;

import com.make.model.heroDAO;
import com.make.model.heroDAOKey;

import java.util.List;

public interface heroDAOMapper {
    int deleteByPrimaryKey(heroDAOKey key);

    int insert(heroDAO record);

    int insertSelective(heroDAO record);

    heroDAO selectByPrimaryKey(heroDAOKey key);

    int updateByPrimaryKeySelective(heroDAO record);

    int updateByPrimaryKey(heroDAO record);

    List<heroDAO> selectByName(String name);

    List<heroDAO> findAllUser();
}