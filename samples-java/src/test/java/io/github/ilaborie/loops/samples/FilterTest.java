package io.github.ilaborie.loops.samples;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static org.junit.Assert.assertEquals;

public class FilterTest {


    private void test(Function<List<Element>, List<Element>> func) {

        List<Element> elements = Arrays.asList(
                new Element("a"),
                new Element("b"),
                new Element("aa"));

        List<Element> result = func.apply(elements);

        assertEquals(Arrays.asList(new Element("a"), new Element("aa")), result);
    }

    @Test
    public void for_should_filter() {
        test(io.github.ilaborie.loops.samples.anatomy.Filter::filter);
    }

    @Test
    public void recursion_should_filter() {
        test(io.github.ilaborie.loops.samples.recursion.Filter::filter);
    }

    @Test
    public void tail_recursion_should_filter() {
        test(io.github.ilaborie.loops.samples.recursion.FilterTR::filter);
    }

    @Test
    public void stream_should_filter() {
        test(io.github.ilaborie.loops.samples.stream.Filter::filter);
    }
}
