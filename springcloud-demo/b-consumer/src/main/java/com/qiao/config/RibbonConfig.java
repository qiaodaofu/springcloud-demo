package com.qiao.config;
import com.netflix.loadbalancer.IRule;
import org.springframework.context.annotation.Bean;


/**
 * 单独给某个服务配置负载均衡
 */
public class RibbonConfig {
    @Bean
    public IRule ribbonRule() { // 其中IRule就是所有规则的标准
        return new com.netflix.loadbalancer.RandomRule(); // 随机的访问策略
    }
}