package com.shds.pco;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController2 {
    @GetMapping("/hello2")
    public String hello(){
        return "hello!!! 무중단 배포 테스트7";
    }
}