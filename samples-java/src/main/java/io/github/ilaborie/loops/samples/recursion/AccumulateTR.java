package io.github.ilaborie.loops.samples.recursion;

import io.github.ilaborie.loops.samples.Element;

import java.util.List;

import static io.github.ilaborie.loops.samples.Elements.getSomeElements;

@SuppressWarnings("ALL")
public class AccumulateTR {

    public static void main(String[] args) {
        List<Element> elements = getSomeElements();
        int result = accumulate(elements);
        System.out.println(result);
    }

    public static int accumulate(List<Element> elements) {
        return aux(elements, 0);
    }

    public static int aux(List<Element> elements, int acc) {
        if (elements.isEmpty()) {
            return acc;
        }

        Element head = elements.get(0);
        List<Element> tail = elements.subList(1, elements.size());

        int count = head.getName().length();
        return aux(tail, acc + count);
    }

}
