package com.aoligei.es_learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ServletComponentScan(basePackages = {"com.aoligei"})
@ComponentScan(basePackages = {"com.aoligei"})
public class EsLearnApplication {

    public static void main(String[] args) {
        SpringApplication.run(EsLearnApplication.class, args);
    }

}
