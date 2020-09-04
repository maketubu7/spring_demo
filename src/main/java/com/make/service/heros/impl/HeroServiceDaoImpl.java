package com.make.service.heros.impl;

import com.make.dao.heroDAOMapper;
import com.make.model.heroDAO;
import com.make.service.heros.HeroDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Copyright@paidaxing
 * Author: paidaxing
 * Date:2020/8/28
 * Description:
 */
@Service(value = "HeroDaoService")
public class HeroServiceDaoImpl implements HeroDaoService {

    @Autowired(required = false)
    com.make.dao.heroDAOMapper heroDAOMapper;

    @Override
    public int updateHero(heroDAO hero) {
        return heroDAOMapper.updateByPrimaryKey(hero);
    }

    @Override
    public int addHero(heroDAO hero) {
        return heroDAOMapper.insert(hero);
    }

//    @Override
//    public List<heroDAO> getHeroByName(String name) {
//        return heroDAOMapper.selectByName(name);
//    }

//    @Override
//    public PageInfo findAllUser(int pageNum, int pageSize) {
//
//        PageHelper.startPage(pageNum,pageSize);
//        List<heroDAO> heroDomain = heroDAOMapper.findAllUser();
//        return new PageInfo(heroDomain);
//    }

}
