package com.qiao.fallback;


import com.qiao.service.IProductClientService;
import com.qiao.vo.Product;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class IProductClientServiceFallbackFactory implements FallbackFactory<IProductClientService> {
    @Override
    public IProductClientService create(Throwable throwable) {
        return  new IProductClientService() {
            @Override
            public Product getProduct(long id) {
                Product product = new Product();
                product.setProductId(999999L);
                product.setProductName("客户端熔断");
                product.setProductDesc("客户端熔断");
                return  product;
            }

            @Override
            public List<Product> listProduct() {
               return null;
            }

            @Override
            public boolean addPorduct(Product product) {
                return false;
            }
        };
    }
}