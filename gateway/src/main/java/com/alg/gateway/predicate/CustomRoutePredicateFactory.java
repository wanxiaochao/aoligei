package com.alg.gateway.predicate;

import org.apache.commons.lang.StringUtils;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * 注意哦 自定义断言的话类名得以RoutePredicateFactory结尾
 * 你的类名要和配置文件断言保持一致 （例如我这里就是 - Custom=参数）
 * 下面serverWebExchange获取数据也要注意
 * 那个配置类也得是static类型的才可以
 */
@Component
public class CustomRoutePredicateFactory extends AbstractRoutePredicateFactory<CustomRoutePredicateFactory.Config> {

    public CustomRoutePredicateFactory() {
        super(CustomRoutePredicateFactory.Config.class);
    }

    @Override
    public List<String> shortcutFieldOrder() {
        //这里的顺序要跟配置文件中的参数顺序一致
        List<String> list = Arrays.asList("minId", "maxId");
        return list;
    }

    @Override
    public Predicate<ServerWebExchange> apply(Config config) {
        return exchange -> {
            String id = exchange.getRequest().getQueryParams().getFirst("custom");
            if (StringUtils.isNotEmpty(id)) {
                int orderId = Integer.parseInt(id);
                boolean flag = orderId >= config.getMinId() && orderId <= config.getMaxId();
                return flag;
            }
            return false;
        };
    }

    //自定义一个配置类, 用于接收配置文件中的参数 这里得是静态类
    static class Config {
        private int minId;
        private int maxId;

        public Config() {
        }

        public Config(int minId, int maxId) {
            this.minId = minId;
            this.maxId = maxId;
        }

        public int getMinId() {
            return minId;
        }

        public void setMinId(int minId) {
            this.minId = minId;
        }

        public int getMaxId() {
            return maxId;
        }

        public void setMaxId(int maxId) {
            this.maxId = maxId;
        }
    }
}
