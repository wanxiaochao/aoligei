package com.alg.redisspringbootstarter.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.Cache;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.context.annotation.Bean;

@Slf4j
public class CacheAutoConfiguration extends CachingConfigurerSupport {

    /**
     * redis 数据操作异常处理, 这里的处理：在日志中打印出错误信息, 但是放行
     * 保证 redis 服务器出现连接等问题的时候不影响程序的正常运行, 使得能够出问题时不用缓存 , 继续执行业务逻辑去查询 DB
     *
     * @return
     */
    @Bean
    public CacheErrorHandler errorHandler() {
        CacheErrorHandler cacheErrorHandler = new CacheErrorHandler() {
            @Override
            public void handleCacheGetError(RuntimeException e, Cache cache, Object o) {
                log.error("redis 异常：key=[{}]", e, cache, o);
            }

            @Override
            public void handleCachePutError(RuntimeException e, Cache cache, Object o, Object o1) {
                log.error("redis 异常：key=[{}]", e, cache, o);
            }

            @Override
            public void handleCacheEvictError(RuntimeException e, Cache cache, Object o) {
                log.error("redis 异常：key=[{}]", e, cache, o);
            }

            @Override
            public void handleCacheClearError(RuntimeException e, Cache cache) {
                log.error("redis 异常：key=[{}]", e, cache);
            }
        };

        return cacheErrorHandler;
    }
}

