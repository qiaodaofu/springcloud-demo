package com.spring.zujian;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@PropertySource(value = "Test-Value.properties")
@Configuration
public class TestConfig {



    @Bean
    public TestEntity testEntity(){
        return new TestEntity();
    }

/*    @Bean
    public TestZujian testZujian(){
        return new TestZujian();
    }*/

}
