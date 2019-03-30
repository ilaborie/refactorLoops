package io.github.ilaborie.loops.samples.anatomy;

import io.github.ilaborie.loops.samples.Element;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static io.github.ilaborie.loops.samples.Elements.getSomeElements;

public class Nest {

    public static void main(String[] args) {
        List<Element> elements = getSomeElements();
        List<String> result = nest(elements);
        result.forEach(System.out::println);
    }

    public static List<String> nest(List<Element> elements) {
        List<String> result = new ArrayList<>();

        for (Element elt1 : elements) {
            for (Element elt2 : elements) {
                String name1 = elt1.getName();
                String name2 = elt2.getName();
                if (!Objects.equals(name1, name2) &&
                        name1.length() == name2.length()) {
                    result.add(String.join("-", name1, name2));
                }
            }
        }

        return result;
    }

}
