package io.github.ilaborie.loops.samples.stream

import io.github.ilaborie.loops.samples.ElementKt
import io.github.ilaborie.loops.samples.getSomeElementsKt


fun main() {
    val elements = getSomeElementsKt()
    val result = transform(elements)
    result.forEach { println(it) }
}

fun transform(elements: List<ElementKt>): List<String> =
    elements.map { elt -> elt.name + " \\o/" }