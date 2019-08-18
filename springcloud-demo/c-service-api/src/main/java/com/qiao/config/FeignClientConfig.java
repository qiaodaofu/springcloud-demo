package com.qiao.config;
import feign.Logger;
import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignClientConfig {
    @Bean
    public BasicAuthRequestInterceptor getBasicAuthRequestInterceptor() {
//      服务与服务之间权限认证
        return new BasicAuthRequestInterceptor("admin", "enjoy");
    }

    /**
     * 需要开启日志级别
      */
    @Bean
    public Logger.Level getFeignLoggerLevel() {
        return Logger.Level.FULL ;
    }
}