package com.make.controller;

import com.make.common.HeroNotfoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Copyright@paidaxing
 * Author: paidaxing
 * Date:2020/8/25
 * Description:
 */

/**
 * 全局异常处理,对于对应的某个异常，做出不同的反应，类似于以前的 try/catch/finally
 */
@ControllerAdvice
public class HeroExceptionController {
    @ExceptionHandler(value = HeroNotfoundException.class)
    public ResponseEntity<Object> exception(HeroNotfoundException exception) {
        return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
    }
}
