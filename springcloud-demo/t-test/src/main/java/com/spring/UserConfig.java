package com.spring;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Data
@PropertySource("classpath:user.properties")
@Component
public class UserConfig {

    @Value("${user.username}")
    private String username;
    @Value("${user.password}")
    private String password;


}
