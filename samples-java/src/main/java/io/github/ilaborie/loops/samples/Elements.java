package io.github.ilaborie.loops.samples;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public final class Elements {

    private static final String LOREM_ISPUM = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";

    private Elements() {
        throw new AssertionError("private");
    }


    public static List<Element> getSomeElements() {
        String[] array = LOREM_ISPUM.split("[ ,.]");
        List<Element> list = Arrays.stream(array)
                .filter(it -> !it.isEmpty())
                .map(String::toLowerCase)
                .map(Element::new)
                .collect(Collectors.toList());
        Collections.shuffle(list);
        return list;

    }
}
