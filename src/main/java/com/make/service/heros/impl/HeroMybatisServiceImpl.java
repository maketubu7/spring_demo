package com.make.service.heros.impl;

import com.github.pagehelper.PageInfo;
import com.make.dao.heroMybatisMapper;
import com.make.model.heroDAO;
import com.make.model.heroDAOKey;
import com.make.service.heros.HeroMybatisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public int batchAddHero(List<heroDAO> heros) {
        heroMybatisMapper.batchAddHero(heros);
        return heros.size();
    }

    @Override
    public int updateHero(heroDAO hero) {
        heroDAOKey key = new heroDAOKey();
        key.setId(hero.getId());
        key.setName(hero.getName());
        if(heroMybatisMapper.selectByKey(key) != null){
            heroMybatisMapper.updateHero(hero);
            return 1;
        }
        else{
            return 0;
        }

    }

    @Override
    public int deleteHero(heroDAOKey key) {
        return heroMybatisMapper.deleteByKey(key);
    }

    @Override
    public heroDAO getHeroByKey(heroDAOKey key) {
        return heroMybatisMapper.selectByKey(key);
    }

    @Override
    public PageInfo<heroDAO> findAllUser(int pageNum, int pageSize) {
        return new PageInfo(heroMybatisMapper.findAllHero());
    }

    @Override
    public List<heroDAO> getHeroByName(String name) {
        return heroMybatisMapper.selectByName(name);
    }

}
