package com.qiao.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.qiao.service.IProductClientService;
import com.qiao.service.IZUUlClientService;
import com.qiao.vo.Product;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/consumer")
public class ConsumerProductController {

    @Resource
    private IProductClientService iProductClientService;


    @Resource
    private IZUUlClientService izuUlClientService;

    @RequestMapping("/product/get/{id}")
    public Object getProduct(@PathVariable("id") long id) {
        System.out.println(1);
        return  iProductClientService.getProduct(id);
    }

    @RequestMapping("/product/getZuul/{id}")
    public Object getProductZuul(@PathVariable("id") long id) {
        return  izuUlClientService.getProduct(id);
    }

    @RequestMapping("/product/list")
    public  Object listProduct() {
       return iProductClientService.listProduct();
    }

    @RequestMapping("/product/add")
    public Object addPorduct(Product product) {
        return  iProductClientService.addPorduct(product);
    }
}