package com.streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamsDemo {
	public static void show() {
		IntStream.of(1, 2, 3)
				.forEach(System.out::println);

		IntStream.range(1, 5)
				.forEach(System.out::println);

		IntStream.rangeClosed(1, 5)
				.forEach(System.out::println);


	}
}
