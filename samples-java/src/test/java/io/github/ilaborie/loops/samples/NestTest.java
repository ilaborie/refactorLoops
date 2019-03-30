package io.github.ilaborie.loops.samples;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static org.junit.Assert.assertEquals;

public class NestTest {


    private void test(Function<List<Element>, List<String>> func) {
        List<Element> elements = Arrays.asList(
                new Element("a"),
                new Element("b"),
                new Element("aa"));

        List<String> result = func.apply(elements);

        assertEquals(Arrays.asList("a-b", "b-a"), result);
    }

    @Test
    public void for_should_nest() {
        test(io.github.ilaborie.loops.samples.anatomy.Nest::nest);
    }

    @Test
    public void stream_should_nest() {
        test(io.github.ilaborie.loops.samples.stream.Nest::nest);
    }

    @Test
    public void stream_should_nest_alt() {
        test(io.github.ilaborie.loops.samples.stream.Nest::nestAlt);
    }
}
