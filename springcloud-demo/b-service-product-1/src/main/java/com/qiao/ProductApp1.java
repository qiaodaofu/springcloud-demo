package com.qiao;

import com.netflix.discovery.DiscoveryClient;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.web.servlet.DispatcherServlet;

@SpringBootApplication
@MapperScan("com.qiao.mapper")
@EnableEurekaClient
@EnableHystrix
public class ProductApp1{
    public static void main(String[] args) {
        SpringApplication.run(ProductApp1.class,args);
    }
}
