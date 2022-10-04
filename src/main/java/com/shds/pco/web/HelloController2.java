package com.shds.pco.web;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController2 {
    @GetMapping("/test")
    public String test(){
        return "무중단 배포 구축 완료! 재배포 테스트3";
    }
}