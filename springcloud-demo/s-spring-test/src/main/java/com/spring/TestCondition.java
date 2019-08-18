package com.spring;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 用来判断一个类在什么时候被加载
 */
public class TestCondition implements Condition {

    /**
     *
     * @param context  获取上下文（环境）数据，
     * @param metadata 注解信息
     * @return
     */
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        String osName = context.getEnvironment().getProperty("os.name");
        System.out.println(osName);
//       contains包含
        if (osName.contains("Windows")){
            return true;
        }
        return false;
    }

}
