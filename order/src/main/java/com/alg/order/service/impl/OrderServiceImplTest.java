package com.alg.order.service.impl;

import com.alg.common.pojo.Order;
import com.alg.order.dao.OrderDao;
import com.alg.order.dao.TxLogDao;
import com.alg.order.entity.TxLog;
import com.alg.order.service.OrderServiceTest;
import org.apache.rocketmq.client.producer.TransactionSendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.UUID;

@Service
public class OrderServiceImplTest implements OrderServiceTest {

    @Autowired
    private OrderDao orderDao;
    @Autowired
    private TxLogDao txLogDao;
    @Autowired
    private RocketMQTemplate rocketMQTemplate;

    public void createOrderBefore(Order order) {
        /** 发送半事物消息 */
        String tx_id = UUID.randomUUID().toString();
        Message<Order> message = MessageBuilder.withPayload(order).setHeader("txId", tx_id).build();
        TransactionSendResult transactionSendResult = rocketMQTemplate.sendMessageInTransaction("tx_producer_group","tx-topic", message, order);
        System.out.println("发送半事物消息返回："+transactionSendResult);
    }

    //本地事物
    @Transactional
    public void createOrder(String txId, Order order) {
        orderDao.save(order);
        //记录日志到数据库,回查使用
        TxLog txLog = new TxLog();
        txLog.setTxLogId(txId);
        txLog.setContent("事物测试");
        txLog.setDate(new Date());
        txLogDao.save(txLog);
    }

}
