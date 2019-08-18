package com.qiao.mapper;

import com.qiao.vo.Product;

import java.util.List;

public interface ProductMapper {

     boolean create(Product product);
     Product findById(Long id);
     List<Product> findAll();
}