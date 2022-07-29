package com.executors;

import java.util.concurrent.Executors;

public class ExecutorsDemo {
    public static void show() {
        var executor = Executors.newFixedThreadPool(2);

        try {
            var future = executor.submit(() -> {
                LongTask.simulate();
                return 1;
            });
        }
        finally {
            executor.shutdown();
        }


    }
}