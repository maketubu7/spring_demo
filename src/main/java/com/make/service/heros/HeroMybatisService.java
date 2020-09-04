package com.make.service.heros;

import com.github.pagehelper.PageInfo;
import com.make.model.heroDAO;
import com.make.model.heroDAOKey;

import java.util.List;

/**
 * Copyright@paidaxing
 * Author: paidaxing
 * Date:2020/8/28
 * Description:
 */
public interface HeroMybatisService {

    int addHero(heroDAO hero);

    int batchAddHero(List<heroDAO> heros);

    int updateHero(heroDAO hero);

    int deleteHero(heroDAOKey key);

    heroDAO getHeroByKey(heroDAOKey key);

    List<heroDAO> getHeroByName(String name);

    PageInfo<heroDAO> findAllUser(int pageNum, int pageSize);


}
