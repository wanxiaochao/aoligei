package com.alg.order.service;


import com.alg.common.pojo.Order;

public interface OrderService {

    Order saveOrder(Order order);

    Order findOrderDetails(Long id);

    Order createOrder(Integer pid);

}
