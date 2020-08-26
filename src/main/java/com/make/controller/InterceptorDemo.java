package com.make.controller;

import com.make.model.lolHero;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Copyright@paidaxing
 * Author: paidaxing
 * Date:2020/8/25
 * Description:
 */
@RestController
@RequestMapping(value = "/interceptor")
public class InterceptorDemo {
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

    @RequestMapping(value = "/getProducts")
    public ResponseEntity<Object> getProduct(@RequestParam("name") String name) {
        return new ResponseEntity<>(heroRepo.get(name), HttpStatus.OK);
    }

}
