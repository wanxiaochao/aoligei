package com.alg.order.service.impl;

import com.alg.common.pojo.Order;
import com.alg.order.dao.TxLogDao;
import com.alg.order.entity.TxLog;
import com.alg.order.service.OrderServiceTest;
import org.apache.rocketmq.spring.annotation.RocketMQTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;

@RocketMQTransactionListener(txProducerGroup = "tx_producer_group")
public class OrderServiceImplTestListener implements RocketMQLocalTransactionListener {

    @Autowired
    private TxLogDao txLogDao;
    @Autowired
    private OrderServiceImplTest orderServiceImplTest;

    @Override
    public RocketMQLocalTransactionState executeLocalTransaction(Message msg, Object arg) {
        try {
            //本地事物
            orderServiceImplTest.createOrder((String) msg.getHeaders().get("txId"), (Order) arg);
            System.out.println("执行本地事物createOrder");
            return RocketMQLocalTransactionState.COMMIT;
        } catch (Exception e) {
            return RocketMQLocalTransactionState.ROLLBACK;
        }
    }

    @Override
    public RocketMQLocalTransactionState checkLocalTransaction(Message msg) {
        try {
            //查询日志记录
            String txId = (String) msg.getHeaders().get("txId");
            TxLog txLog = txLogDao.findById(txId).get();
            if (txLog == null) {
                return RocketMQLocalTransactionState.COMMIT;
            } else {
                return RocketMQLocalTransactionState.ROLLBACK;
            }
        } catch (Exception e) {
            return RocketMQLocalTransactionState.ROLLBACK;
        }
    }
}
