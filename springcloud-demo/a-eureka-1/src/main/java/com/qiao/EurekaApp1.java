package com.qiao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.support.DefaultSingletonBeanRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.web.servlet.DispatcherServlet;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
@EnableEurekaServer
public class EurekaApp1 {
    @Value("${server.port}")
    private String hello;
    public static void main(String[] args) {
        SpringApplication.run(EurekaApp1.class,args);
        EurekaApp1 app1 = new EurekaApp1();
        app1.aa();
    }

    public void aa(){
        System.out.println(hello);
    }

    public List get (){
        return Collections.EMPTY_LIST;
    }
}