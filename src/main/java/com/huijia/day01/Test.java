package com.huijia.day01;

import java.util.concurrent.TimeUnit;

/**
 * @program:
 * @version: 1.0
 * @author: huijia
 * @create: 2023/8/3 09:46
 */
public class Test {
    public static void main(String[] args) {
        A a = new A();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                if (i == 5) {
                    try {
                        Thread.sleep(3);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                a.test(i);
            }
        }).start();

    }


}

class A {
    public synchronized void test(int i) {
        if (i == 6) {
            try {
                this.wait(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(i + "------------");

    }
}