package com.make.controller;

import com.make.model.lolHero;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 * Copyright@paidaxing
 * Author: paidaxing
 * Date:2020/8/26
 * Description:
 */
@RestController
public class HeroWebService {

    RestTemplate restemplate = new RestTemplate();

    /**
     * 使用exchange()方法为所有HTTP方法使用Web服务
     * @return
     */
    @RequestMapping(value = "/template/heros",method = RequestMethod.GET)
    public String getHeroList() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity <String> entity = new HttpEntity<String>(headers);
        return restemplate.exchange("http://localhost:8080/heros", HttpMethod.GET, entity, String.class).getBody();
    }

    @RequestMapping(value = "/template/heros",method = RequestMethod.POST)
    public String postHeroList(@RequestBody lolHero hero) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity <lolHero> entity = new HttpEntity<lolHero>(hero,headers);
        return restemplate.exchange("http://localhost:8080/heros", HttpMethod.POST, entity, String.class).getBody();
    }

    @RequestMapping(value = "/template/heros/{name}",method = RequestMethod.PUT)
    public String putHeroList(@PathVariable("name") String name,@RequestBody lolHero hero) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity <lolHero> entity = new HttpEntity<lolHero>(hero,headers);
        return restemplate.exchange("http://localhost:8080/heros/"+name, HttpMethod.PUT, entity, String.class).getBody();
    }

    @RequestMapping(value = "/template/heros/{name}",method = RequestMethod.DELETE)
    public String deleteHeroList(@PathVariable("name") String name) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity <String> entity = new HttpEntity<String>(headers);
        return restemplate.exchange("http://localhost:8080/heros/"+name, HttpMethod.DELETE, entity, String.class).getBody();
    }

}
