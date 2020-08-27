package com.make.controller;

import com.make.model.lolHero;
import com.make.service.HeroService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
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

    /**
     * 注入一个HeroServiceImpl 实例 类似于 HeroService heroService = new HeroServiceImpl()
     */
    @Autowired
    HeroService heroService;

    @RequestMapping(value = "/heros",method = RequestMethod.GET)
    public ResponseEntity<Object> getHeros(){
        return new ResponseEntity<>(heroService.getHeros(), HttpStatus.OK);
    }

    @RequestMapping(value = "/heros", method = RequestMethod.POST)
    public ResponseEntity<Object> createHero(@RequestBody lolHero hero) {
        heroService.createProduct(hero);
        return new ResponseEntity<>("hero "+ hero.getName() + " is created successfully", HttpStatus.CREATED);
    }

    @RequestMapping(value = "/heros/{name}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateHero(@PathVariable("name") String name, @RequestBody lolHero hero) {
        heroService.updateProduct(name,hero);
        return new ResponseEntity<>("hero "+ hero.getName() + " is updated successsfully", HttpStatus.OK);
    }

    @ApiOperation(value = "删除英雄成员", notes = "删除英雄成员")
    @ApiImplicitParams(@ApiImplicitParam(name = "name", value = "英雄唯一名称"))
    @ApiResponse(code = 200,response = Exception.class, message = "delete successfully")
    @RequestMapping(value = "/heros/{name}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteHero(@PathVariable("name") String name) {
        heroService.deleteProduct(name);
        return new ResponseEntity<>("hero "+ name + " is delete successsfully", HttpStatus.OK);
    }
}
