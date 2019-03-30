package io.github.ilaborie.loops.samples.anatomy;

import io.github.ilaborie.loops.samples.Element;

import java.util.ArrayList;
import java.util.List;

import static io.github.ilaborie.loops.samples.Elements.getSomeElements;

public class Transform {

    public static void main(String[] args) {
        List<Element> elements = getSomeElements();
        List<String> result = transform(elements);
        result.forEach(System.out::println);
    }

    public static List<String> transform(List<Element> elements) {
        List<String> result = new ArrayList<>();

        for (Element elt : elements) {
            String transformed = elt.getName() + " \\o/";
            result.add(transformed);
        }

        return result;
    }

}
