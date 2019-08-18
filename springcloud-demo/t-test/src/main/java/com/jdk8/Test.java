package com.jdk8;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) throws Exception {

        new Thread(() -> System.out.println("我爱你")).start();

        new Thread(() -> System.out.println("你爱我")).start();

        String[] strs = {"aa","vv","aa"};
        Arrays.sort(strs);
        List<String> strings = Arrays.asList(strs);
        strings.forEach(s -> {
            System.out.println("字符串信息->"+s);
        });


        strings.forEach(System.out::println);

        Callable<String> callable = () -> "done";
        System.out.println(callable.call());

        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        for (int i = 0;i< threadInfos.length;i++){
            System.out.println(threadInfos[i].getThreadId()+"============"+threadInfos[i].getThreadName());
        }

        Integer[] data = {1, 3, 5, 7};
        Arrays.sort(data);
        System.out.println(Arrays.binarySearch(data, 4)); // -1

        Integer[] dataStream = {1, 2, 3, 4};
        List<Integer> list = Arrays.stream(dataStream).collect(Collectors.toList());
        System.out.println(list); // [1, 2, 3, 4]


        Random random = new Random();
        random.ints().limit(10).forEach(System.out::println);

        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        // 获取对应的平方数
        List<Integer> squaresList =numbers.stream().map(integer -> integer*integer).distinct().collect(Collectors.toList());
        squaresList.forEach(System.out::println);

        numbers.stream().sorted().forEach(System.out::println);

        long count = numbers.stream().filter(integer -> integer.equals(3)).count();
        long count1 = numbers.parallelStream().filter(integer -> integer.equals(2)).count();
        System.out.println(count);
        System.out.println(count1);


        List<String>strings1 = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        List<String> filtered = strings1.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());

        System.out.println("筛选列表: " + filtered);
        String mergedString = strings1.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
        System.out.println("合并字符串: " + mergedString);


        JDK8_New jdk8_new = new JDK8_New() {
            @Override
            public String getString() {
                return JDK8_New.super.getString();
            }
        };
        System.out.println(jdk8_new.getString());

        Test java8Tester = new Test();
        Integer value1 = null;
        Integer value2 = new Integer(10);
        // Optional.ofNullable - 允许传递为 null 参数
        Optional<Integer> a = Optional.ofNullable(value1);


        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
    }

}
