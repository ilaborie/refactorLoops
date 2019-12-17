package io.github.ilaborie.loops.samples.stream

import io.github.ilaborie.loops.samples.montecarlo.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert.assertEquals
import org.junit.Test


class MonteCarloTest {

    private fun test(func: (Int) -> Double) {
        val count = 10_000_000
        val result = func(count)
        assertEquals(Math.PI, result, 1e-2)
    }

    @Test
    fun for_should_compute_pi() {
        test { monteCarloFor(it) }
    }

    @Test
    fun recursion_should_compute_pi() {
        test { monteCarloRecursion(it) }
    }

    @Test
    fun collection_should_compute_pi() {
        test { monteCarloCollection(it) }
    }

    @Test
    fun collection_seq_should_compute_pi() {
        test { monteCarloSequence(it) }
    }

    @Test
    fun stream_should_compute_pi() {
        test { monteCarloSequence(it) }
    }

    @Test
    fun stream_parallel_should_compute_pi() {
        test { monteCarloSequenceParallel(it) }
    }

    @Test
    fun stream_parallel_should_compute_pi2() {
        test { monteCarloSequenceParallel2(it) }
    }

    @Test
    fun stream_parallel_should_compute_pi_other() {
        test { monteCarloSequenceParallelOther(it) }
    }

    @Test
    fun stream_parallel_should_compute_pi_other_alex() {
        test { monteCarloSequenceParallelOtherAlex(it) }
    }

    @Test
    @ExperimentalCoroutinesApi
    fun stream_parallel_should_compute_pi_flow() {
        test {
            monteCarloFlow(it)
        }
    }

}
