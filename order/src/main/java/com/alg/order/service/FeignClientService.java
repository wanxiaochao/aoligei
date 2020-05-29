package com.alg.order.service;

import com.alg.common.pojo.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("product-service")
public interface FeignClientService {

    @GetMapping(value = "/product/{pid}")
    Product findById(@PathVariable("pid") Integer pid);

}
