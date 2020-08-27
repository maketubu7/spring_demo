package com.make.controller;

import com.make.model.lolHero;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Copyright@paidaxing
 * Author: paidaxing
 * Date:2020/8/26
 * Description:
 */
@Controller
public class IndexHeroController {
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/add-heros",method = RequestMethod.GET)
    public String addHeros(){
        return "add-heros";
    }

    @RequestMapping(value = "/view-heros",method = RequestMethod.GET)
    public String allHeros(){
        return "view-heros";
    }
}
