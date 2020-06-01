package com.alg.order.controller;

import com.alg.common.pojo.Order;
import com.alg.common.pojo.Product;
import com.alg.order.service.FeignClientService;
import com.alg.order.service.OrderService;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class OrderController {

    @Resource
    private RestTemplate restTemplate;
    @Resource
    private OrderService orderService;
    @Resource
    private DiscoveryClient discoveryClient;
    @Resource
    private FeignClientService feignClientService;


    @GetMapping("/order-details/{id}")
    public Order findOrderDetails(@PathVariable("id") Long id) {
        return orderService.findOrderDetails(id);
    }

    @GetMapping("/order/feign/{pid}")
    public Order order(@PathVariable("pid") Integer pid) {

        //基于feign调用
        Product product = feignClientService.findById(pid);
        Order order = new Order();
        order.setUid(1);
        order.setUsername("测试用户");
        order.setPid(product.getPid());
        order.setPname(product.getPname());
        order.setPprice(product.getPprice());
        order.setNumber(1);
        Order order1 = orderService.saveOrder(order);
        return order1;
    }

    @GetMapping("/order/prod/{pid}")
    public Order orderFeign(@PathVariable("pid") Integer pid) {

        //通过ribbon实现负载均衡
        Product product = restTemplate.getForObject("http://product-service/product/" + pid, Product.class);

        Order order = new Order();
        order.setUid(1);
        order.setUsername("测试用户");
        order.setPid(product.getPid());
        order.setPname(product.getPname());
        order.setPprice(product.getPprice());
        order.setNumber(1);
        Order order1 = orderService.saveOrder(order);
        return order1;
    }

    @GetMapping("/order/service/prod/{pid}")
    public Order orderService(@PathVariable("pid") Integer pid) {

        //自定义负载均衡实现
        List<ServiceInstance> instances = discoveryClient.getInstances("product-service");
        int index = (int) (Math.random() * instances.size());
        ServiceInstance serviceInstance = instances.get(index);
        String url = serviceInstance.getHost() + ":" + serviceInstance.getPort();
        System.out.println(url);
        Product product = restTemplate.getForObject("http://" + url + "/product/" + pid, Product.class);

        Order order = new Order();
        order.setUid(1);
        order.setUsername("测试用户");
        order.setPid(product.getPid());
        order.setPname(product.getPname());
        order.setPprice(product.getPprice());
        order.setNumber(1);
        Order order1 = orderService.saveOrder(order);
        return order1;

    }

}
