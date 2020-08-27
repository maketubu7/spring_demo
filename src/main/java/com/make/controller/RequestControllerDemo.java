package com.make.controller;

import com.make.model.lolHero;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Copyright@paidaxing
 * Author: paidaxing
 * Date:2020/8/25
 * Description:
 */


@RestController
public class RequestControllerDemo {
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
    /**
     * @RequestBody 用来接收post请求的body数据，并存入string变量requestString
     * @param requestString
     * @return
     */
    @RequestMapping(value = "/getBodyString",method = RequestMethod.GET)
    public String getBodyString(@RequestBody String requestString){
        return requestString;
    }

    /**
     * @RequestBody 用来接收post请求的body数据，并存入对应的实体对象lolHero中
     * @param hero
     * @return
     */
    @RequestMapping(value = "/getBodyBean",method = RequestMethod.GET)
    public String getBodyBean(@RequestBody lolHero hero){
        System.out.println(hero.toString());
        return hero.toString();
    }

    /**
     * 可以同时处理body，params里的数据
     * @param hero
     * @param id
     * @return
     */
    @RequestMapping(value = "/getBodyAndParams",method = RequestMethod.GET)
    public String getBodyAndParams(@RequestBody lolHero hero, @RequestParam String id){
        System.out.println(id + " >>> " + hero.toString());
        return id + " >>> " + hero.toString();
    }

    @RequestMapping(value = "/getBodyAndComplexParams",method = RequestMethod.GET)
    public String getBodyAndComplexParams(@RequestBody lolHero hero, @RequestParam ArrayList<String> arrays){
        System.out.println(hero.toString());
        StringBuilder sb = new StringBuilder();
        for (String array : arrays){
            sb.append(array);
        }
        return "arrays: " + sb.toString() + " >>> " + hero.toString();
    }

    /**
     * 可以同时处理body，params里的数据 并且都转换为变量实体，是先解析params再解析body参数
     * @param hero1
     * @param hero2
     * @return
     */
    @RequestMapping(value = "/getBodyParamsMoreBean",method = RequestMethod.GET)
    public String getBodyParamsMoreBean(@RequestBody lolHero hero1, lolHero hero2){
        System.out.println(hero1.toString());
        System.out.println(hero2.toString());
        return hero1.toString() + "===" + hero2.toString();
    }

    /**
     * 动态路径
     * @param id
     * @return
     */
    @RequestMapping(value = "/pathValue/{username}/{id}",method = RequestMethod.GET)
    public String pathValue(@PathVariable("id") String id,@PathVariable("username") String username){
        return String.format("username=%s,id=%s",username,id);
    }

}
