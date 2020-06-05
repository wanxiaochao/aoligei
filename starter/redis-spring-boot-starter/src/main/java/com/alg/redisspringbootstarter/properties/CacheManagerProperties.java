package com.alg.redisspringbootstarter.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * @author zlt
 * @date 2019/1/6
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "spring.redis.custom")
public class CacheManagerProperties {
    private List<CacheConfig> configs;


    @Setter
    @Getter
    public static class CacheConfig {
        /**
         * cache key
         */
        private String key;
        /**
         * 过期时间，sec
         */
        private long second = 60;
    }
}
