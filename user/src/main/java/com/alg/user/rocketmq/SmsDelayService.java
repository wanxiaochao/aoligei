package com.alg.user.rocketmq;

import com.alg.common.pojo.Order;
import com.alibaba.fastjson.JSON;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

@Component
@RocketMQMessageListener(consumerGroup = "order-delay", topic = "order-delay-topic")
public class SmsDelayService implements RocketMQListener<Order> {

    @Override
    public void onMessage(Order order) {
        System.out.println("接收到延时消息成功通知:" + JSON.toJSONString(order));
    }
}
