package com.streams;

import java.util.List;
import java.util.function.Predicate;

public class StreamsDemo {
    public static void show() {
        List<Movie> movies = List.of(
            new Movie("a", 10),
            new Movie("b", 15),
            new Movie("c", 20)
        );

        // Imperative Programming
        int count = 0;
        for (var movie : movies)
            if (movie.getLikes() > 10)
                count++;

        // Declarative (Functional) Programming
        var count1 = movies.stream()
                .filter(movie -> movie.getLikes() > 10)
                .count();
    }
}
