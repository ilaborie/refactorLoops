package io.github.ilaborie.loops.samples.recursion;

import io.github.ilaborie.loops.samples.Element;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static io.github.ilaborie.loops.samples.Elements.getSomeElements;

public class Transform {

    public static void main(String[] args) {
        List<Element> elements = getSomeElements();
        List<String> result = transform(elements);
        result.forEach(System.out::println);
    }

    public static List<String> transform(List<Element> elements) {
        if (elements.isEmpty()) {
            return Collections.emptyList();
        }

        Element head = elements.get(0);
        List<Element> tail = elements.subList(1, elements.size());

        String transformed = head.getName() + " \\o/";
        List<String> result = new ArrayList<>();
        result.add(transformed);
        result.addAll(transform(tail));
        return result;
    }

}
