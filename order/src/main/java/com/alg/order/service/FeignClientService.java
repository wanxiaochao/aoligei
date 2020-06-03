package com.alg.order.service;

import com.alg.common.pojo.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("product-service")
public interface FeignClientService {

    @GetMapping(value = "/product/{pid}")
    Product findById(@PathVariable("pid") Integer pid);

    @RequestMapping("/product/reduceInventory")
    void reduceInventory(@RequestParam("pid") Integer pid, @RequestParam("num") int num);
}
