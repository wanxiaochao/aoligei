package com.alg.user.rocketmq;

import com.alg.common.pojo.Order;
import com.alibaba.fastjson.JSON;
import org.apache.rocketmq.spring.annotation.ConsumeMode;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

//消费有序消息
@Component
@RocketMQMessageListener(consumerGroup = "order-group-order", topic = "order-topic-order", consumeMode = ConsumeMode.ORDERLY)
public class SmsOrderMsgService implements RocketMQListener<Order> {

    @Override
    public void onMessage(Order order) {
        System.out.println("消费顺序消息:" + JSON.toJSONString(order));
    }

}
