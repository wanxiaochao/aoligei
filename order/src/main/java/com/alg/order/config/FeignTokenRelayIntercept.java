package com.alg.order.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

//Feign调用时传递token
public class FeignTokenRelayIntercept implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate requestTemplate) {

        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes attributes = (ServletRequestAttributes) requestAttributes;
        HttpServletRequest request = attributes.getRequest();
        String token = request.getHeader("token");

        if (StringUtils.isNotBlank(token)) {
            requestTemplate.header("token", token);
        }

    }
}
