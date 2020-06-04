package com.alg.userprovide;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ServletComponentScan(basePackages = {"com.alg"})
@ComponentScan(basePackages = {"com.alg"})
public class UserProvideApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserProvideApplication.class, args);
    }

}
