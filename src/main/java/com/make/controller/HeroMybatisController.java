package com.make.controller;

import com.make.model.heroDAO;
import com.make.model.heroDAOKey;
import com.make.service.heros.HeroDaoService;
import com.make.service.heros.HeroMybatisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Copyright@paidaxing
 * Author: paidaxing
 * Date:2020/8/28
 * Description:
 */
@RestController
@RequestMapping(value = "/mybatisService")
public class HeroMybatisController {
    /**
     * 注入一个HeroMybatisServiceImpl 实例 类似于 HeroService heroService = new HeroServiceImpl()
     */
    @Autowired(required = false)
    HeroMybatisService heroMybatisService;

    @RequestMapping(value = "/heros",method = RequestMethod.GET)
    public ResponseEntity<Object> getHeros(){
        return new ResponseEntity<>(heroMybatisService.findAllUser(1,4), HttpStatus.OK);
    }

    @RequestMapping(value = "/heros", method = RequestMethod.POST)
    public ResponseEntity<Object> createHero(@RequestBody heroDAO hero) {
        heroMybatisService.addHero(hero);
        return new ResponseEntity<>("hero "+ hero.getName() + " is created successfully", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/heros/{name}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateHero(@PathVariable("name") String name, @RequestBody heroDAO hero) {
        heroMybatisService.updateHero(hero);
        return new ResponseEntity<>("hero "+ hero.getName() + " is updated successsfully", HttpStatus.OK);
    }

    @RequestMapping(value = "/getHero", method = RequestMethod.GET)
    public ResponseEntity<Object> getHero(@RequestParam("name") String name) {
        heroDAO hero = heroMybatisService.getHeroByName(name);
        return new ResponseEntity<>(hero, HttpStatus.OK);
    }

    @RequestMapping(value = "/deleteHero", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteHero(@RequestParam("name") String name,@RequestParam("id") int id) {
        heroDAOKey key = new heroDAOKey();
        key.setId(id);
        key.setName(name);
        heroMybatisService.deleteHero(key);
        return new ResponseEntity<>("hero "+ name + " is delete successsfully", HttpStatus.OK);
    }
}
