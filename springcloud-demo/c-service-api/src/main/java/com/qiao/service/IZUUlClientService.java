package com.qiao.service;

import com.qiao.config.FeignClientConfig;
import com.qiao.fallback.IZUUlClientServiceallbackFactory;
import com.qiao.vo.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name = "MICROCLOUD-ZUUL-GATEWAY",configuration = FeignClientConfig.class,
        fallbackFactory = IZUUlClientServiceallbackFactory.class)
public interface IZUUlClientService {

    @RequestMapping("/enjoy-api/product-proxy/prodcut/get/{id}")
    public Product getProduct(@PathVariable("id") long id);

    @RequestMapping("/enjoy-api/product-proxy/prodcut/list")
    public List<Product> listProduct() ;

    @RequestMapping("/enjoy-api/product-proxy/prodcut/add")
    public boolean addPorduct(Product product) ;

}