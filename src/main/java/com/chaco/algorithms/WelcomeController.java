//package com.chaco.algorithms;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
///**
// * @author zhaopeiyan
// * @date 2021/1/30 5:03 下午
// */
//@RestController
//@Slf4j
//public class WelcomeController {
//    @GetMapping("/ping")
//    public String pong() {
//        return "pong";
//    }
//
//    @RequestMapping(value = "{name:^ab\\d+}")
//    public String test(@PathVariable("name") Object n) {
//        return n.toString();
//    }
//}