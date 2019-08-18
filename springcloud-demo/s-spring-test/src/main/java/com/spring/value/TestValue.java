package com.spring.value;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TestValue {

    @Value("qiao")
    private String name;
    @Value("#{20-1}")
    private int count;
    @Value("${password}")
    private String password;

    private int flay = 1;
}
