package com.make.controller;

import com.make.common.HeroNotfoundException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Copyright@paidaxing
 * Author: paidaxing
 * Date:2020/8/25
 * Description:
 */
@RestController
public class ControllerAdviceDemo {
    @RequestMapping(value = "/getHero",method = RequestMethod.GET)
    public String hero(@RequestParam("id") String id){
        if (Integer.parseInt(id) > 10){
            return "德玛西亚之力";
        }
        else{
            throw new HeroNotfoundException();
        }
    }
}
