package com.qiao.entiy;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * indexName =索引名称
 * type 表名称
 */
@Document(indexName = "myindex",type = "user")
@Data
public class User {
    @Id
    private String id;
    private String name;
    private String age;
    private String sex;

}
