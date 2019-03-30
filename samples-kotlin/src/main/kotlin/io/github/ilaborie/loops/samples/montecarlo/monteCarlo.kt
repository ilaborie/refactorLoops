package io.github.ilaborie.loops.samples.montecarlo

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