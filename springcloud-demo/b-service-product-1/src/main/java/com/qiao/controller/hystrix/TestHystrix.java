package com.qiao.controller.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.qiao.controller.ProductController;

public class TestHystrix extends HystrixCommand<ProductController> {
    protected TestHystrix(HystrixCommandGroupKey group) {
        super(group);
    }

    @Override
    protected ProductController run() throws Exception {
        return null;
    }
}
