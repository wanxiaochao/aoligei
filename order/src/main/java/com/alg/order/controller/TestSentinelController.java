package com.alg.order.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestSentinelController {

    @Value("${spring.application.name}")
    private String name;

    @RequestMapping("/order/message1")
    public String message1() {
        return "message1"+name;
    }
    @RequestMapping("/order/message2")
    @SentinelResource(value = "/order/message2")
    public String message2() {
        return "message2"+name;
    }

}
