package com.aoligei.es_learn;

import com.alibaba.fastjson.JSON;
import com.aoligei.es_learn.config.ElasticSearchConfig;
import com.aoligei.es_learn.pojo.User;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.IOException;

@SpringBootTest
class EsLearnApplicationTests {

    @Resource
    private RestHighLevelClient restHighLevelClient;

    @Test
    void contextLoads() throws IOException {
        //新建一个索引
        IndexRequest indexRequest = new IndexRequest("index_user");
        //指定id
        indexRequest.id("3");

        User user = new User();
        user.setNickname("猪八戒");
        user.setUid(4L);
        user.setBirthday(System.currentTimeMillis());
        user.setAddress("天津市西青区");
        // 转为json字符
        String u = JSON.toJSONString(user);
        // 保存json
        indexRequest.source(u, XContentType.JSON);

        // 执行操作
        IndexResponse index = restHighLevelClient.index(indexRequest, ElasticSearchConfig.COMMON_OPTIONS);

        System.out.println(index);

    }

}
