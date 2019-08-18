package com.qiao.controller;

import com.qiao.dao.UserDao;
import com.qiao.entiy.User;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.elasticsearch.index.query.functionscore.FunctionScoreQueryBuilder;
import org.elasticsearch.index.query.functionscore.ScoreFunctionBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Book;
import java.util.*;

@RestController
public class UserController {

    @Autowired
    private UserDao userDao;

    /**
     * 插入文档
     * @param user
     * @return
     */
    @RequestMapping("save")
    public User save(User user){
        User user1 = userDao.save(user);

        return user1;
    }

    /**
     * 查询文档
     * @param id
     * @return
     */
    @RequestMapping("findById/{id}")
    public Optional<User> findById(@PathVariable("id") String id){
        Optional<User> user = userDao.findById(id);
        return user;
    }

    /**
     * 全文检索（根据整个实体的所有属性，可能结果为0个）
     * @param entity
     * @return
     */
    @RequestMapping("testSearch/{entity}")
    public List<User> testSearch(@PathVariable("entity") String entity){
        QueryStringQueryBuilder builder = new QueryStringQueryBuilder(entity);
        Iterable<User> searchResult = userDao.search(builder);
        Iterator<User> iterator = searchResult.iterator();
        List<User> list = new ArrayList();
        while (iterator.hasNext()){
            list.add(iterator.next());
        }
        return list;
    }

}
