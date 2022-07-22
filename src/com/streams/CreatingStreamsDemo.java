package com.streams;

import java.util.Arrays;
import java.util.stream.Stream;

public class CreatingStreamsDemo {
    public static void show() {
        Stream.iterate(1, n -> n * 3)
                .limit(10)
                .forEach(n -> System.out.println(n));
    }
}
