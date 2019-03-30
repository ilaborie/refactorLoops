package io.github.ilaborie.loops.samples;

import io.github.ilaborie.loops.samples.montecarlo.MonteCarlo;
import org.junit.Ignore;
import org.junit.Test;

import java.util.function.Function;

import static org.junit.Assert.assertEquals;

public class MonteCarloTest {

    private void test(Function<Integer, Double> func) {
        int count = 10_000_000;
        double result = func.apply(count);
        assertEquals(Math.PI, result, 1e-2);
    }

    @Test
    public void for_should_compute_pi() {
        test(MonteCarlo::monteCarloFor);
    }

    @Test
    @Ignore("StackOverflow")
    public void recursion_should_compute_pi() {
        test(MonteCarlo::monteCarloRecursion);
    }

    @Test
    public void stream_should_compute_pi() {
        test(MonteCarlo::monteCarloStream);
    }


    @Test
    public void stream_parallel_should_compute_pi() {
        test(MonteCarlo::monteCarloStreamParallel);
    }

    @Test
    public void stream_parallel2_should_compute_pi() {
        test(MonteCarlo::monteCarloStreamParallel2);
    }


}
