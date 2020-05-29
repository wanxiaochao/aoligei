package com.alg.product.service;


import com.alg.common.pojo.Product;

public interface ProductService {
    Product findByPid(Integer pid);
}
