package com.executors;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Timer;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;

public class ExecutorsDemo {
    public static void show() {
        var executor = Executors.newFixedThreadPool(2);

        try {
            var future = executor.submit(() -> {
                System.out.println("Start time: " + Time.valueOf(LocalTime.now()));
                LongTask.simulate();
                System.out.println("End time: " + Time.valueOf(LocalTime.now()));
                return 1;
            });

            System.out.println("Do more work");
            try {
                var result = future.get();
                System.out.println(result);
            } catch (InterruptedException  | ExecutionException e) {
                e.printStackTrace();
            }
        }
        finally {
            executor.shutdown();
        }
    }
}