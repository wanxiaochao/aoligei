package com.alg.user.rocketmq;

import com.alg.common.pojo.Order;
import com.alibaba.fastjson.JSON;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

@Component
@RocketMQMessageListener(consumerGroup = "order-group-easy", topic = "order-topic")
public class SmsService implements RocketMQListener<Order> {

    @Override
    public void onMessage(Order order) {
        System.out.println("接收到下单成功通知:" + JSON.toJSONString(order));
    }
}
