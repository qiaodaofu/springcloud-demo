package com.qiao.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.qiao.vo.Product;
import com.qiao.service.IProductService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Value("${server.port}")
    private String hello;

    @Resource
    private IProductService iProductService;

    @Resource
    private DiscoveryClient client ; // 进行Eureka的发现服务

    @RequestMapping(value="/get/{id}")
    @HystrixCommand(fallbackMethod = "getFallback")
    public Object get(@PathVariable("id") long id) {

        System.out.println(hello);

        Product product = this.iProductService.get(id) ;
        if(product==null){
            throw new RuntimeException();
        }
        return product;
    }

    public Object  getFallback(@PathVariable("id") long id){
        Product product = new Product();
        product.setProductName("服务端熔断");
        product.setProductDesc("服务端熔断");
        product.setProductId(0L);
        return product;
    }

    @RequestMapping(value="/add")
    public Object add(@RequestBody Product product) {
        return this.iProductService.add(product) ;
    }

    @RequestMapping(value="/list")
    public Object list() {
        throw new RuntimeException();
    }


    @RequestMapping("/discover")
    public Object discover() { // 直接返回发现服务信息
        return this.client ;
    }
}