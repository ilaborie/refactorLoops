package io.github.ilaborie.loops.samples.recursion;

import io.github.ilaborie.loops.samples.Element;

import java.util.ArrayList;
import java.util.List;

import static io.github.ilaborie.loops.samples.Elements.getSomeElements;

public class TransformTR {

    public static void main(String[] args) {
        List<Element> elements = getSomeElements();
        List<String> result = transform(elements);
        result.forEach(System.out::println);
    }

    public static List<String> transform(List<Element> elements) {
        return aux(elements, new ArrayList<>());
    }

    private static List<String> aux(List<Element> elements, List<String> acc) {
        if (elements.isEmpty()) {
            return acc;
        }

        Element head = elements.get(0);
        List<Element> tail = elements.subList(1, elements.size());

        String transformed = head.getName() + " \\o/";
        acc.add(transformed);

        return aux(tail, acc);
    }

}
