package com.make.service.heros.impl;

import com.github.pagehelper.PageInfo;
import com.make.dao.heroMybatisMapper;
import com.make.model.heroDAO;
import com.make.model.heroDAOKey;
import com.make.service.heros.HeroMybatisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Copyright@paidaxing
 * Author: paidaxing
 * Date:2020/8/28
 * Description:
 */

@Service("HeroMybatisService")
public class HeroMybatisServiceImpl implements HeroMybatisService {

    @Autowired(required = false)
    heroMybatisMapper heroMybatisMapper;

    @Override
    public int addHero(heroDAO hero) {
        return heroMybatisMapper.addHero(hero);
    }

    @Override
    public int updateHero(heroDAO hero) {
        return heroMybatisMapper.updateHeroSelective(hero);
    }

    @Override
    public int deleteHero(heroDAOKey key) {
        return heroMybatisMapper.deleteByKey(key);
    }

    @Override
    public heroDAO getHeroByName(String name) {
        return heroMybatisMapper.selectByName(name);
    }

    @Override
    public PageInfo<heroDAO> findAllUser(int pageNum, int pageSize) {
        return new PageInfo(heroMybatisMapper.findAllHero());
    }
}
