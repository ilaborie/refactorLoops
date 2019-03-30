package io.github.ilaborie.loops.samples.stream;

import io.github.ilaborie.loops.samples.Element;

import java.util.List;
import java.util.stream.Collectors;

import static io.github.ilaborie.loops.samples.Elements.getSomeElements;

public class Filter {

    public static void main(String[] args) {
        List<Element> elements = getSomeElements();
        List<Element> result = filter(elements);
        result.forEach(System.out::println);
    }

    public static List<Element> filter(List<Element> elements) {
        return elements.stream()
                .filter(elt -> elt.getName().startsWith("a"))
                .collect(Collectors.toList());
    }

}
