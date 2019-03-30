package io.github.ilaborie.loops.samples.stream;

import io.github.ilaborie.loops.samples.Element;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static io.github.ilaborie.loops.samples.Elements.getSomeElements;

public class Accumulate {

    public static void main(String[] args) {
        List<Element> elements = getSomeElements();
        int result = accumulate(elements);
        System.out.println(result);
    }

    public static int accumulate(List<Element> elements) {
        return elements.stream()
                .collect(
                        () -> new AtomicInteger(0),
                        (acc, elt) -> acc.addAndGet(elt.getName().length()),
                        (acc1, acc2) -> acc1.addAndGet(acc2.get()))
                .get();
    }

    public static int accumulateSimple(List<Element> elements) {
        return elements.stream()
                .mapToInt(elt -> elt.getName().length())
                .sum();
    }

}
