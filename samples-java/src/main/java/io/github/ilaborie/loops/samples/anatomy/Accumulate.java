package io.github.ilaborie.loops.samples.anatomy;

import io.github.ilaborie.loops.samples.Element;

import java.util.List;

import static io.github.ilaborie.loops.samples.Elements.getSomeElements;

public class Accumulate {

    public static void main(String[] args) {
        List<Element> elements = getSomeElements();
        int result = accumulate(elements);
        System.out.println(result);
    }

    public static int accumulate(List<Element> elements) {
        int count = 0;

        for (Element elt : elements) {
            int eltSize = elt.getName().length();
            count += eltSize;
        }

        return count;
    }

}
