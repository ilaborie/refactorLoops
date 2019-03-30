package io.github.ilaborie.loops.samples;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static org.junit.Assert.assertEquals;

public class AccumulateTest {


    private void test(Function<List<Element>, Integer> func) {

        List<Element> elements = Arrays.asList(
                new Element("1"),
                new Element("_2"),
                new Element("__3"));

        int result = func.apply(elements);

        assertEquals(6, result);
    }

    @Test
    public void for_should_accumulate() {
        test(io.github.ilaborie.loops.samples.anatomy.Accumulate::accumulate);
    }

    @Test
    public void recursion_should_accumulate() {
        test(io.github.ilaborie.loops.samples.recursion.Accumulate::accumulate);
    }
    @Test
    public void recursion_should_accumulate_alt() {
        test(io.github.ilaborie.loops.samples.recursion.Accumulate::accumulateAlt);
    }

    @Test
    public void tail_recursion_should_accumulate() {
        test(io.github.ilaborie.loops.samples.recursion.AccumulateTR::accumulate);
    }

    @Test
    public void stream_should_accumulate() {
        test(io.github.ilaborie.loops.samples.stream.Accumulate::accumulate);
    }

    @Test
    public void stream_simple_should_accumulate() {
        test(io.github.ilaborie.loops.samples.stream.Accumulate::accumulateSimple);
    }
}
