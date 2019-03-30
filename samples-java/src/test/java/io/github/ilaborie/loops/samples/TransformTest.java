package io.github.ilaborie.loops.samples;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static org.junit.Assert.assertEquals;

public class TransformTest {


    private void test(Function<List<Element>, List<String>> func) {

        List<Element> elements = Arrays.asList(
                new Element("a"),
                new Element("b"),
                new Element("aa"));

        List<String> result = func.apply(elements);

        assertEquals(Arrays.asList("a \\o/", "b \\o/", "aa \\o/"), result);
    }

    @Test
    public void for_should_transform() {
        test(io.github.ilaborie.loops.samples.anatomy.Transform::transform);
    }

    @Test
    public void recursion_should_transform() {
        test(io.github.ilaborie.loops.samples.recursion.Transform::transform);
    }

    @Test
    public void tail_recursion_should_transform() {
        test(io.github.ilaborie.loops.samples.recursion.TransformTR::transform);
    }

    @Test
    public void stream_should_transform() {
        test(io.github.ilaborie.loops.samples.stream.Transform::transform);
    }
}
