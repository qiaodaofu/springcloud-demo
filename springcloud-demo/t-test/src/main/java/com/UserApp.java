package com;

import com.spring.UserConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class UserApp{

    @Autowired
    private UserConfig userConfig;
    @Value("${user.username}")
    private String username;

    @Value("${server.port}")
    private String hello;

    public static void main(String[] args) {
        SpringApplication.run(UserApp.class,args);



    }

    @RequestMapping("aa")
    public String aa(){
        System.out.println(userConfig.toString());
        return username;
    }

}