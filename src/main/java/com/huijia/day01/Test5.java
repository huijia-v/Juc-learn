package com.huijia.day01;

import java.util.concurrent.*;

/**
 * 自定义线程池
 *
 * @program:
 * @version: 1.0
 * @author: huijia
 * @create: 2023/8/3 10:07
 */
public class Test5 {
    public static void main(String[] args) {


        System.out.println(add1());
        System.out.println(add2());

    }


    public static String add1() {
        Long sum = 0L;
        Long startTime = System.currentTimeMillis();
        for (long i = 0; i <= 20_0000_0000L; i++) {
            sum += i;
        }
        Long endTime = System.currentTimeMillis();

        return sum + "没有使用多线程的方法" + ",共耗时：" + (endTime - startTime);
    }

    public static String add2() {
        Long sum = 0L;
        Long startTime = System.currentTimeMillis();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Long> task = new ForkJoinDemo(0L, 20_0000_0000L);
        forkJoinPool.execute(task);

        try {
            sum = task.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        Long endTime = System.currentTimeMillis();

        return sum + "使用了多线程，共耗时" + (endTime - startTime);

    }
}
