package com.make.controller;

import com.make.model.lolHero;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Copyright@paidaxing
 * Author: paidaxing
 * Date:2020/8/26
 * Description:
 */
@RestController
public class HeroController {
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
    @RequestMapping("/heros")
    public ResponseEntity<Object> getHeros(){
        return new ResponseEntity<>(heroRepo.values(), HttpStatus.OK);
    }

    @RequestMapping(value = "/heros", method = RequestMethod.POST)
    public ResponseEntity<Object> createHero(@RequestBody lolHero hero) {
        heroRepo.put(hero.getName(), hero);
        return new ResponseEntity<>("hero "+ hero.getName() + " is created successfully", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/heros/{name}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateHero(@PathVariable("name") String name, @RequestBody lolHero hero) {
        heroRepo.remove(name);
        hero.setName(name);
        heroRepo.put(name, hero);
        return new ResponseEntity<>("hero "+ hero.getName() + " is updated successsfully", HttpStatus.OK);
    }

    @RequestMapping(value = "/heros/{name}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteHero(@PathVariable("name") String name) {
        heroRepo.remove(name);
        return new ResponseEntity<>("hero "+ name + " is delete successsfully", HttpStatus.OK);
    }
}
