/*
 * Copyright (c) 2014, Oracle America, Inc.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *  * Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *
 *  * Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in the
 *    documentation and/or other materials provided with the distribution.
 *
 *  * Neither the name of Oracle nor the names of its contributors may be used
 *    to endorse or promote products derived from this software without
 *    specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF
 * THE POSSIBILITY OF SUCH DAMAGE.
 */

package io.github.ilaborie;

import io.github.ilaborie.loops.samples.montecarlo.MonteCarlo;
import io.github.ilaborie.loops.samples.montecarlo.MonteCarloKt;
import io.github.ilaborie.loops.samples.montecarlo.MonteCarloScala$;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

@State(Scope.Benchmark)
public class MonteCarloBenchmark {


    @Param({"100", "1000", "10000", "100000", "1000000", "10000000"})
    public int count;

    // Java
    @Benchmark
    public double monteCarlo_Java_for() {
        return MonteCarlo.monteCarloFor(count);
    }

    // No tail rec in Java => StackOverflow
//    @Benchmark
//    public double monteCarlo_Java_recursion() {
//        return MonteCarlo.monteCarloRecursion(count);
//    }

    @Benchmark
    public double monteCarlo_Java_lazy() {
        return MonteCarlo.monteCarloStream(count);
    }

    @Benchmark
    public double monteCarlo_Java_lazy_parallel() {
        return MonteCarlo.monteCarloStreamParallel(count);
    }

    @Benchmark
    public double monteCarlo_Java_lazy_parallel2() {
        return MonteCarlo.monteCarloStreamParallel2(count);
    }

    // Kotlin
    @Benchmark
    public double monteCarlo_Kotlin_for() {
        return MonteCarloKt.monteCarloFor(count);
    }

    @Benchmark
    public double monteCarlo_Kotlin_recursion() {
        return MonteCarloKt.monteCarloRecursion(count);
    }

    @Benchmark
    public double monteCarlo_Kotlin_collection() {
        return MonteCarloKt.monteCarloCollection(count);
    }

    @Benchmark
    public double monteCarlo_Kotlin_collection_lazy() {
        return MonteCarloKt.monteCarloSequence(count);
    }

    @Benchmark
    public double monteCarlo_Kotlin_lazy() {
        return MonteCarloKt.monteCarloSequence(count);
    }

    @Benchmark
    public double monteCarlo_Kotlin_lazy_parallel() {
        return MonteCarloKt.monteCarloSequenceParallel(count);
    }

    @Benchmark
    public double monteCarlo_Kotlin_lazy_parallel2() {
        return MonteCarloKt.monteCarloSequenceParallel2(count);
    }

    // Scala
    @Benchmark
    public double monteCarlo_Scala_for() {
        return MonteCarloScala$.MODULE$.monteCarloFor(count);
    }
    @Benchmark
    public double monteCarlo_Scala_recursion() {
        return MonteCarloScala$.MODULE$.monteCarloRecursion(count);
    }

    @Benchmark
    public double monteCarlo_Scala_collection() {
        return MonteCarloScala$.MODULE$.monteCarloCollection(count);
    }

    @Benchmark
    public double monteCarlo_Scala_collection_parallel() {
        return MonteCarloScala$.MODULE$.monteCarloCollectionParallel(count);
    }
    @Benchmark
    public double monteCarlo_Scala_stream() {
        return MonteCarloScala$.MODULE$.monteCarloStream(count);
    }

    @Benchmark
    public double monteCarlo_Scala_stream_parallel() {
        return MonteCarloScala$.MODULE$.monteCarloStreamParallel(count);
    }
    @Benchmark
    public double monteCarlo_Scala_stream_parallel2() {
        return MonteCarloScala$.MODULE$.monteCarloStreamParallel2(count);
    }

}
