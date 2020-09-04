package com.make.service.heros;

import com.github.pagehelper.PageInfo;
import com.make.model.heroDAO;

import java.util.List;

/**
 * Copyright@paidaxing
 * Author: paidaxing
 * Date:2020/8/28
 * Description:
 */
public interface HeroDaoService {
    int addHero(heroDAO hero);

    int updateHero(heroDAO hero);

    List<heroDAO> getHeroByName(String name);

    PageInfo<heroDAO> findAllUser(int pageNum, int pageSize);

}
