package com.make.controller;

import com.make.model.heroDAO;
import com.make.model.lolHero;
import com.make.service.heros.HeroDaoService;
import com.make.service.heros.HeroService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
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
@RequestMapping(value = "/daoService")
public class HeroDaoController {
    /**
     * 注入一个HeroServiceImpl 实例 类似于 HeroService heroService = new HeroServiceImpl()
     */
    @Autowired(required = false)
    HeroDaoService heroDaoService;

    @RequestMapping(value = "/heros",method = RequestMethod.GET)
    public ResponseEntity<Object> getHeros(){
        return new ResponseEntity<>(heroDaoService.findAllUser(1,4), HttpStatus.OK);
    }

    @RequestMapping(value = "/heros", method = RequestMethod.POST)
    public ResponseEntity<Object> createHero(@RequestBody heroDAO hero) {
        heroDaoService.addHero(hero);
        return new ResponseEntity<>("hero "+ hero.getName() + " is created successfully", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/heros/{name}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateHero(@PathVariable("name") String name, @RequestBody heroDAO hero) {
        heroDaoService.updateHero(hero);
        return new ResponseEntity<>("hero "+ hero.getName() + " is updated successsfully", HttpStatus.OK);
    }

}
