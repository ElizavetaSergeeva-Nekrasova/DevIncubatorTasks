package by.incubator.task7;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class OutOfMemoryErrors {
    public static void outOfMemoryMethod1() {
        Human[] humans = new Human[1000000000];
    }

    public static void outOfMemoryMethod2() {
        List<Human> linkedList = new LinkedList<>();

        for (;;) {
            linkedList.add(new Human(3, "abc", "abc"));
        }
    }
}