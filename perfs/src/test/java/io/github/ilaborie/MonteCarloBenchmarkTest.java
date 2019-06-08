package io.github.ilaborie;

import org.junit.Test;

public class MonteCarloBenchmarkTest {

    @Test
    public void testAll() {
        MonteCarloBenchmark benchmark = new MonteCarloBenchmark();

        benchmark.count = 10;

        benchmark.monteCarlo_Java_for();
//        benchmark.monteCarlo_Java_recursion();
        benchmark.monteCarlo_Java_lazy();
        benchmark.monteCarlo_Java_lazy_parallel();
        benchmark.monteCarlo_Java_lazy_parallel2();

        benchmark.monteCarlo_Kotlin_for();
        benchmark.monteCarlo_Kotlin_recursion();
        benchmark.monteCarlo_Kotlin_collection();
        benchmark.monteCarlo_Kotlin_collection_lazy();
        benchmark.monteCarlo_Kotlin_lazy();
        benchmark.monteCarlo_Kotlin_lazy_parallel();
        benchmark.monteCarlo_Kotlin_lazy_parallel2();

        benchmark.monteCarlo_Scala_for();
        benchmark.monteCarlo_Scala_recursion();
        benchmark.monteCarlo_Scala_collection();
        benchmark.monteCarlo_Scala_collection_parallel();
        benchmark.monteCarlo_Scala_stream();
        benchmark.monteCarlo_Scala_stream_parallel();
        benchmark.monteCarlo_Scala_stream_parallel2();
        benchmark.monteCarlo_Scala_lazylist();
        benchmark.monteCarlo_Scala_lazylist_parallel();
        benchmark.monteCarlo_Scala_lazylist_parallel2();
    }
}
