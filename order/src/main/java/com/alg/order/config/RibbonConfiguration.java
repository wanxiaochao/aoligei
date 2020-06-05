package com.alg.order.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Collections;

@Configuration
public class RibbonConfiguration {

    @Resource
    private RibbonTokenRelayInterceptor ribbonTokenRelayInterceptor;

    @Bean
    @LoadBalanced//nacos整合了ribbon  ribbon配置传递token
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setInterceptors(Collections.singletonList(ribbonTokenRelayInterceptor));
        return new RestTemplate();
    }

}
