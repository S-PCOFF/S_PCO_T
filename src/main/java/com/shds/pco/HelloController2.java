package com.shds.pco;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController2 {
    @GetMapping("/hello2")
    public String hello(){
        return "hello!!! 2번째 버전 입니다.";
    }
}