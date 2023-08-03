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
public class Test3 {
    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(
                2,
                3,
                1L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(2),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );
        for (int i = 0; i < 100; i++) {
            final   int temp = i;
            executorService.execute(()->{
                System.out.println(Thread.currentThread().getName() + ":" + temp);
            });
        }
        executorService.shutdown();
    }
}
