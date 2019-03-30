package io.github.ilaborie.loops.samples.recursion;

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
        if (elements.isEmpty()) {
            return 0;
        }

        Element head = elements.get(0);
        List<Element> tail = elements.subList(1, elements.size());

        int count = head.getName().length();
        int countTail = accumulate(tail);
        return count + countTail;
    }

    public static int accumulateAlt(List<Element> elements) {
        if (elements.isEmpty()) {
            return 0;
        }

        Element head = elements.get(0);
        List<Element> tail = elements.subList(1, elements.size());
        return head.getName().length() + accumulateAlt(tail);
    }

}
