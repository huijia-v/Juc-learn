package com.huijia.day01;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @program:
 * @version: 1.0
 * @author: huijia
 * @create: 2023/8/3 09:56
 */
public class Test2 {
    public static void main(String[] args) {
//        ExecutorService executorService = Executors.newSingleThreadExecutor();
//        ExecutorService executorService = Executors.newFixedThreadPool(5);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            final int temp = i;
            executorService.execute(() -> {
                System.out.println(Thread.currentThread().getName() + ":" + temp);
            });
        }
        executorService.shutdown();
    }
}
