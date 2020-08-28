package com.make.service.heros.impl;

import com.make.model.lolHero;
import com.make.service.heros.HeroService;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Copyright@paidaxing
 * Author: paidaxing
 * Date:2020/8/26
 * Description:
 */
@Service
public class HeroServiceImpl implements HeroService {
    private static Map<String, lolHero> heroRepo = new HashMap<>();
    static {
        lolHero honey = new lolHero();
        honey.setName("make1");
        honey.setQ("胸口碎大石");
        honey.setW("铁头功");
        honey.setE("如来神掌");
        honey.setR("六脉神剑");
        heroRepo.put(honey.getName(), honey);
        lolHero almond = new lolHero();
        almond.setName("make2");
        almond.setQ("降龙十八章");
        almond.setW("龟派气功");
        almond.setE("葵花点血手");
        almond.setR("九阴真经");
        heroRepo.put(almond.getName(),almond);
    }

    @Override
    public void createProduct(lolHero hero) {
        heroRepo.put(hero.getName(),hero);
    }

    @Override
    public void updateProduct(String name, lolHero hero) {
        heroRepo.remove(name);
        heroRepo.put(name,hero);
    }

    @Override
    public void deleteProduct(String name) {
        heroRepo.remove(name);
    }

    @Override
    public Collection<lolHero> getHeros() {
        return heroRepo.values();
    }
}
