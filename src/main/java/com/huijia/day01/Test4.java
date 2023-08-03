package com.huijia.day01;

/**
 * @program:
 * @version: 1.0
 * @author: huijia
 * @create: 2023/8/3 10:35
 */
public class Test4 {
    public static void main(String[] args) {
        Long sum = 0L;
        Long startTime = System.currentTimeMillis();
        for (long i = 0; i <= 20_0000_0000L; i++) {
            sum += i;
        }
        Long endTime = System.currentTimeMillis();
        System.out.println(sum + ",共耗时：" + (endTime - startTime));


    }
}
