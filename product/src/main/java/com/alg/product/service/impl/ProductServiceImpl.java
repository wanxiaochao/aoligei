package com.alg.product.service.impl;


import com.alg.common.pojo.Product;
import com.alg.product.dao.ProductDao;
import com.alg.product.service.ProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductDao productDao;

    @Override
    public Product findByPid(Integer pid) {
        return productDao.findById(pid).get();
    }

    @Override
    public void reduceInventory(Integer pid, int num) {
        Product product = productDao.findById(pid).get();
        product.setStock(product.getStock() - num);//减库存
        if (product.getStock() < num) {
            throw new RuntimeException("库存不足");
        }
        int i = 1 / 0;
        productDao.save(product);
    }
}
