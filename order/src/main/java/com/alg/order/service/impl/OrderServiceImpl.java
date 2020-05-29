package com.alg.order.service.impl;


import com.alg.common.pojo.Order;
import com.alg.order.dao.OrderDao;
import com.alg.order.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

    @Override
    public Order saveOrder(Order order) {
        Order save = orderDao.save(order);
        return save;
    }
}
