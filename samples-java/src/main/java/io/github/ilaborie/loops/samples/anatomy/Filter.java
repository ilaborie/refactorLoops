package io.github.ilaborie.loops.samples.anatomy;

import io.github.ilaborie.loops.samples.Element;

import java.util.ArrayList;
import java.util.List;

import static io.github.ilaborie.loops.samples.Elements.getSomeElements;

public class Filter {

    public static void main(String[] args) {
        List<Element> elements = getSomeElements();
        List<Element> result = filter(elements);
        result.forEach(System.out::println);
    }

    public static List<Element> filter(List<Element> elements) {
        List<Element> result = new ArrayList<>();

        for (Element elt : elements) {
            if (elt.getName().startsWith("a")) {
                result.add(elt);
            }
        }

        return result;
    }

}
