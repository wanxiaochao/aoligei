package com.alg.product.controller;


import com.alg.common.pojo.Product;
import com.alg.product.service.ProductService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RefreshScope //动态刷新获取配置中的值 可以修改nacos配置测试
public class ProductController {

    @Resource
    private ProductService productService;

    @GetMapping("/product/{pid}")
    public Product product(@PathVariable("pid") Integer pid) {
        Product product = productService.findByPid(pid);
        return product;
    }

    @Value("${dynamic.name}")
    private String dynamicConfig;

    @GetMapping("/product/dynamic-config")
    public String dynamicConfig() {
        return dynamicConfig;
    }

    @RequestMapping("/product/reduceInventory")
    public void reduceInventory(Integer pid, int num) {
        productService.reduceInventory(pid, num);
    }
}
