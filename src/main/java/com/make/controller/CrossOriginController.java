package com.make.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Copyright@paidaxing
 * Author: paidaxing
 * Date:2020/8/27
 * Description:
 */
@RestController
@CrossOrigin("http://localhost:9090")
public class CrossOriginController {

    @RequestMapping(value = "/crossOrigin", method = RequestMethod.GET)
    public ResponseEntity<Object> crossOrigin(){
        return new ResponseEntity<>("success", HttpStatus.OK);

    }}
