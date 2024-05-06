package org.cbaron.java8.lambda;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class EjemploPredicate {
    public static void main(String[] args) {

        Predicate<Integer> predicate = num -> num > 10;
        boolean r = predicate.test(7);
        System.out.println(r);

        Predicate<String> predicate2 = role -> role.equals("admin");
        System.out.println(predicate2.test("admin"));

        BiPredicate<String, String> biPredicate = String::equals; //a.equals(b);
        System.out.println(biPredicate.test("carlos", "aleph"));
    }
}
