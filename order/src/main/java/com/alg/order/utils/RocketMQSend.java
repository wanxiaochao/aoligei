package com.alg.order.utils;

import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.apache.rocketmq.spring.support.RocketMQUtil;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class RocketMQSend {
    @Resource
    private RocketMQTemplate rocketMQTemplate;

    /**
     * 同步发送是指消息发送方发出数据后，会在收到接收方发回响应之后才发下一个数据包的通讯方
     * 式。
     * 此种方式应用场景非常广泛，例如重要通知邮件、报名短信通知、营销短信系统等。
     */
    public void sendSyncMsg(String topic, String message) {
        //参数一: topic， 如果想添加tag 可以使用"topic:tag"的写法
        //参数二: 消息内容
        SendResult sendResult = rocketMQTemplate.syncSend(topic, message);
        System.out.println("同步发送返回：" + sendResult);
    }

    /**
     * 异步发送是指发送方发出数据后，不等接收方发回响应，接着发送下个数据包的通讯方式。发送
     * 方通过回调接口接收服务器响应，并对响应结果进行处理。
     * 异步发送一般用于链路耗时较长，对 RT 响应时间较为敏感的业务场景，例如用户视频上传后通知
     * 启动转码服务，转码完成后通知推送转码结果等。
     */
    public void sendAsyncMsg(String topic, String message) throws InterruptedException {
        rocketMQTemplate.asyncSend(topic, message, new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                System.out.println("异步发送成功：" + sendResult);
            }

            @Override
            public void onException(Throwable throwable) {
                System.out.println("异步发送异常：" + throwable);
            }
        });
        //让线程不要终止 测试用的
        //Thread.sleep(30000000);
    }

    /**
     * 单向发送是指发送方只负责发送消息，不等待服务器回应且没有回调函数触发，即只发送请求不
     * 等待应答。
     * 适用于某些耗时非常短，但对可靠性要求并不高的场景，例如日志收集
     */
    public void sendOneWay(String topic, String message) {
        rocketMQTemplate.sendOneWay(topic, message);
        System.out.println("单向消息返回值：");
    }

    //同步顺序消息[异步顺序 单向顺序写法类似]

    /**
     * @param topic   主题
     * @param message 消息
     * @param hashKey hashKey: 为了保证报到同一个队列中，将消息发送到orderTopic主题上
     * @since: 2020/6/2
     * 顺序消息在消费时必须同步消费
     */
    public void sendSyncOrderMsg(String topic, String message, String hashKey) {
        SendResult sendResult = rocketMQTemplate.syncSendOrderly(topic, message, hashKey);
        System.out.println("顺序消息返回值：" + sendResult);
    }

    public void sendSyncDelayMsg(String topic, String message, long timeout) {
        SendResult topic1 = rocketMQTemplate.syncSend(topic, message, timeout);
        System.out.println("延时消息返回值：" + topic1);
    }
}
