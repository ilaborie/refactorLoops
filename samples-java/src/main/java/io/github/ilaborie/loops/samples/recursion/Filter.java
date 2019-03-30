package io.github.ilaborie.loops.samples.recursion;

import io.github.ilaborie.loops.samples.Element;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static io.github.ilaborie.loops.samples.Elements.getSomeElements;

public class Filter {

    public static void main(String[] args) {
        List<Element> elements = getSomeElements();
        List<Element> result = filter(elements);
        result.forEach(System.out::println);
    }

public static List<Element> filter(List<Element> elements) {
    if (elements.isEmpty()) {
        return Collections.emptyList();
    }

    Element head = elements.get(0);
    List<Element> tail = elements.subList(1, elements.size());

    List<Element> tailFiltered = filter(tail);
    List<Element> result;
    if (head.getName().startsWith("a")) {
        result = new ArrayList<>();
        result.add(head);
        result.addAll(tailFiltered);
    } else {
        result = tailFiltered;
    }
    return result;
}

}
