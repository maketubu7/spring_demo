package com.make.controller;

import com.make.model.lolHero;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * Copyright@paidaxing
 * Author: paidaxing
 * Date:2020/8/25
 * Description:
 */


@RestController
public class RequestControllerDemo {
    /**
     * @RequestBody 用来接收post请求的body数据，并存入string变量requestString
     * @param requestString
     * @return
     */
    @RequestMapping("/getBodyString")
    public String getBodyString(@RequestBody String requestString){
        return requestString;
    }

    /**
     * @RequestBody 用来接收post请求的body数据，并存入对应的实体对象lolHero中
     * @param hero
     * @return
     */
    @RequestMapping("/getBodyBean")
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
    @RequestMapping("/getBodyAndParams")
    public String getBodyAndParams(@RequestBody lolHero hero, @RequestParam String id){
        System.out.println(id + " >>> " + hero.toString());
        return id + " >>> " + hero.toString();
    }

    @RequestMapping("/getBodyAndComplexParams")
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
    @RequestMapping("/getBodyParamsMoreBean")
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
    @RequestMapping("/pathValue/{username}/{id}")
    public String pathValue(@PathVariable("id") String id,@PathVariable("username") String username){
        return String.format("username=%s,id=%s",username,id);
    }
}
