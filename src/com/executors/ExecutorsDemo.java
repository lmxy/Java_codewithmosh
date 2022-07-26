package com.executors;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ExecutorsDemo {
    public static void show() {
        var executor = Executors.newFixedThreadPool(2);
        for (int i = 0; i < 10; i++) {
            executor.submit(() -> {
                System.out.println(Thread.currentThread().getName());
            });

        }
    }
}
