package com.make.service.heros;

import com.github.pagehelper.PageInfo;
import com.make.model.heroDAO;
import com.make.model.heroDAOKey;

/**
 * Copyright@paidaxing
 * Author: paidaxing
 * Date:2020/8/28
 * Description:
 */
public interface HeroMybatisService {

    int addHero(heroDAO hero);

    int updateHero(heroDAO hero);

    int deleteHero(heroDAOKey key);

    heroDAO getHeroByName(String name);

    PageInfo<heroDAO> findAllUser(int pageNum, int pageSize);
}
