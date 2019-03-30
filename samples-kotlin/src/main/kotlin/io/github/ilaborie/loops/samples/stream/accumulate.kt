package io.github.ilaborie.loops.samples.stream

import io.github.ilaborie.loops.samples.ElementKt
import io.github.ilaborie.loops.samples.getSomeElementsKt


fun main() {
    val elements = getSomeElementsKt()
    val result = accumulate(elements)
    println(result)
}

fun accumulate(elements: List<ElementKt>): Int =
    elements
        .fold(0) { acc, elt ->
            acc + elt.name.length
        }

fun accumulateAlt(elements: List<ElementKt>): Int =
    elements
        .map { it.name.length }
        .sum()
