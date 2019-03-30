package io.github.ilaborie.loops.samples.stream;

import io.github.ilaborie.loops.samples.Element;

import java.util.List;
import java.util.stream.Collectors;

import static io.github.ilaborie.loops.samples.Elements.getSomeElements;

public class Transform {

    public static void main(String[] args) {
        List<Element> elements = getSomeElements();
        List<String> result = transform(elements);
        result.forEach(System.out::println);
    }

    public static List<String> transform(List<Element> elements) {
        return elements.stream()
                .map(elt -> elt.getName() + " \\o/")
                .collect(Collectors.toList());
    }

}
