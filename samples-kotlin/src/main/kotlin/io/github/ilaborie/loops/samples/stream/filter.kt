package io.github.ilaborie.loops.samples.stream

import io.github.ilaborie.loops.samples.ElementKt
import io.github.ilaborie.loops.samples.getSomeElementsKt


fun main() {
    val elements = getSomeElementsKt()
    val result = filter(elements)
    result.forEach { println(it) }
}

fun filter(elements: List<ElementKt>): List<ElementKt> =
    elements.filter { it.name.startsWith("a") }