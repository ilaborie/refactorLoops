package io.github.ilaborie.loops.samples.montecarlo

import java.util.*

data class KtPoint(val x: Double, val y: Double) {
    fun inCircle(): Boolean =
        x * x + y * y <= 1
}

private val rnd = Random(0)
fun newPoint(): KtPoint {
    return KtPoint(rnd.nextDouble(), rnd.nextDouble())
}

// @see SplittableRandom
private val rnd2 = SplittableRandom(0)
fun newPoint2(): KtPoint {
    return KtPoint(rnd2.nextDouble(), rnd2.nextDouble())
}

fun compute(count: Int, inCircle: Int): Double {
    return inCircle.toDouble() / count * 4
}