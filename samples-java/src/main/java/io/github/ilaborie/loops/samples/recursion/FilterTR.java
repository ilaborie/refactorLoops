package io.github.ilaborie.loops.samples.recursion;

import io.github.ilaborie.loops.samples.Element;

import java.util.ArrayList;
import java.util.List;

import static io.github.ilaborie.loops.samples.Elements.getSomeElements;

public class FilterTR {

    public static void main(String[] args) {
        List<Element> elements = getSomeElements();
        List<Element> result = filter(elements);
        result.forEach(System.out::println);
    }

    public static List<Element> filter(List<Element> elements) {
        return aux(elements, new ArrayList<>());
    }

    public static List<Element> aux(List<Element> elements, List<Element> acc) {
        if (elements.isEmpty()) {
            return acc;
        }

        Element head = elements.get(0);
        List<Element> tail = elements.subList(1, elements.size());

        if (head.getName().startsWith("a")) {
            acc.add(head);
        }
        return aux(tail, acc);
    }

}
