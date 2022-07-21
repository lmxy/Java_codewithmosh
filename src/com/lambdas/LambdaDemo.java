package com.lambdas;

import java.util.function.Function;

public class LambdaDemo {
    public static void show() {
        // "key:value"
        // first: "key=value"
        //  second: "{key=value}"
        Function<String, String> replaceColon = str -> str.replace(":", "=");
        Function<String, String> addBraces = str -> "{" + str + "}";


//         Declarative Programming
        var result = replaceColon
                            .andThen(addBraces)
                            .apply("key:value");
        result = addBraces.compose(replaceColon).apply("key:value");


        System.out.println(result);
    }
}
