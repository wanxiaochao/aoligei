package com.alg.user.rocketmq;

import com.alg.common.pojo.Order;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

@Component
@RocketMQMessageListener(
        consumerGroup = "tx_producer_group",//消费者分组
        topic = "tx-topic"
)
public class SmSTxService implements RocketMQListener<Order> {

    @Override
    public void onMessage(Order order) {
        System.out.println("接收到事物消息：" + order);
    }
}
