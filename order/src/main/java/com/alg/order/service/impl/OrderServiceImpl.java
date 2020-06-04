package com.alg.order.service.impl;


import com.alg.common.pojo.Order;
import com.alg.common.pojo.Product;
import com.alg.order.dao.OrderDao;
import com.alg.order.service.FeignClientService;
import com.alg.order.service.OrderService;
import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;
    @Resource
    private FeignClientService feignClientService;

    @Override
    public Order saveOrder(Order order) {
        Order save = orderDao.save(order);
        return save;
    }

    @Override
    public Order findOrderDetails(Long id) {
        return orderDao.findById(id).get();
    }

    @Override
    public Order createOrder(Integer pid) {
        Product product = feignClientService.findById(pid);
        System.out.println("查询到{}号商品的信息,内容是:{}" + pid + JSON.toJSONString(product));
        Order order = new Order();
        order.setUid(1);
        order.setUsername("分布式事物");
        order.setPid(pid);
        order.setPname(product.getPname());
        order.setPprice(product.getPprice());
        order.setNumber(1);
        orderDao.save(order);
        System.out.println("创建订单成功,订单信息为{}"+JSON.toJSONString(order));
        feignClientService.reduceInventory(pid,1);
        return null;
    }
}
