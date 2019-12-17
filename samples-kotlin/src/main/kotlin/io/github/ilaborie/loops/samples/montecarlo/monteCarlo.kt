package io.github.ilaborie.loops.samples.montecarlo

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.count
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.runBlocking
import java.text.NumberFormat


fun main() {
    val format = NumberFormat.getIntegerInstance()
    (2..20)
        .map { e -> Math.pow(10.0, e.toDouble()).toInt() }
        .onEach { count -> System.out.printf("Compute with %s ...%n", format.format(count.toLong())) }
        .map { monteCarloSequence(it) }
        .forEach { pi -> println("Result: $pi") }
}

// For Loop
fun monteCarloFor(count: Int): Double {
    var inCircle = 0
    for (i in 0 until count) {
        val p = newPoint()

        if (p.inCircle()) {
            inCircle++
        }
    }
    return compute(count, inCircle)
}

// Recursion
fun monteCarloRecursion(count: Int): Double {
    tailrec fun aux(count: Int, inCircle: Int): Int =
        if (count == 0) inCircle
        else {
            val p = newPoint()
            aux(count - 1, if (p.inCircle()) inCircle + 1 else inCircle)
        }

    val inCircle = aux(count, 0)
    return compute(count, inCircle)
}

// Collections
fun monteCarloCollection(count: Int): Double {
    val inCircle = (1..count)
        .map { newPoint() }
        .count { it.inCircle() }

    return compute(count, inCircle)
}

// Sequences (collections lazy)
fun monteCarloSequence(count: Int): Double {
    val inCircle = generateSequence { newPoint() }
        .take(count)
        .count { it.inCircle() }

    return compute(count, inCircle)
}

fun monteCarloSequenceParallel(count: Int): Double {
    val inCircle = sequence {
        yieldAll(generateSequence { newPoint() })
    }
        .take(count)
        .count { it.inCircle() }

    return compute(count, inCircle)
}

fun monteCarloSequenceParallel2(count: Int): Double {
    val inCircle = sequence {
        yieldAll(generateSequence { newPoint2() })
    }
        .take(count)
        .count { it.inCircle() }

    return compute(count, inCircle)
}

fun monteCarloSequenceParallelOther(count: Int): Double {
    val inCircle = sequence {
        yieldAll(generateSequence { newPoint2() })
    }
        .take(count)
        .count {
            //            println("Thread ${Thread.currentThread().name}")
            it.inCircle()
        }

    return compute(count, inCircle)
}

fun monteCarloSequenceParallelOtherAlex(count: Int): Double {
    val inCircle = (1..count).toList()
        .parallelStream()
        .map { newPoint() }
        .filter {
            //            println("Thread ${Thread.currentThread().name}")
            it.inCircle()
        }
        .count()

    return compute(count, inCircle.toInt())
}

// Flow
@ExperimentalCoroutinesApi
fun monteCarloFlow(count: Int): Double {
    val inCircle = runBlocking {
        flow {
            while (true) {
                emit(newPoint())
            }
        }
            .take(count)
            .count { it.inCircle() }
    }

    return compute(count, inCircle)
}
