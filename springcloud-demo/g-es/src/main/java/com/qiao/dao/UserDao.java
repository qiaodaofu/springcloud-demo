package com.qiao.dao;

import com.qiao.entiy.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.repository.CrudRepository;

//public interface UserDao extends CrudRepository<User,String> {
public interface UserDao extends ElasticsearchRepository<User,String> {
}
