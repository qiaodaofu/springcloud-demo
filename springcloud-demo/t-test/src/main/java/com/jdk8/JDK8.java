package com.jdk8;

import org.apache.logging.log4j.util.PropertySource;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JDK8 {

    public static void main(String[] args) {

        List<String> strings = new ArrayList<>();
        strings.add("cccc");
        strings.add("aaaa");
        strings.add("bbbb");
        strings.add("eeee");
        strings.add("ffff");
        strings.add("zzzz");
        strings.add("gggg");
        strings.add("llll");
        strings.add("llll");


        Stream<String> stream = strings.stream();
//        System.out.println(stream.count());
//        System.out.println(stream.filter(s -> s.equals("bbbb")).collect(Collectors.toList()));
//        stream.limit(strings.size()).sorted().distinct().forEach(s -> System.out.println(s));
//        System.out.println(stream.skip(4).limit(1).collect(Collectors.joining()));
//        System.out.println(stream.skip(7).allMatch(s -> s.contains("llll")));
//        拼接字符串
//        System.out.println(stream.reduce((s, s2) -> s+s2));


//         降序
//        stream.sorted(Comparator.reverseOrder()).forEach(s -> System.out.println(s));
        Map<String, Long> collect = stream.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect);

    }


}
