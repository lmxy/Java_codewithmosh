package com.Mapdemo;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {
    public static void show() {
        var c1 = new Customer("a", "e1");
        var c2 = new Customer("b", "e2");

        Map<String, Customer> map = new HashMap<>();
        map.put(c1.getEmail(), c1);
        map.put(c2.getEmail(), c2);

        var unknown = new Customer("Unknown", "");
        var customer = map.getOrDefault("e10", unknown);
        System.out.println(customer);
    }
}
