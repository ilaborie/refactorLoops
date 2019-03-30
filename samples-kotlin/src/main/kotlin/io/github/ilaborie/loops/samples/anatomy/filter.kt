package io.github.ilaborie.loops.samples.anatomy

import io.github.ilaborie.loops.samples.ElementKt
import io.github.ilaborie.loops.samples.getSomeElementsKt


fun main() {
    val elements = getSomeElementsKt()
    val result = io.github.ilaborie.loops.samples.stream.filter(elements)
    result.forEach { println(it) }
}

fun filter(elements: List<ElementKt>): List<ElementKt> {
    val result = mutableListOf<ElementKt>()

    for (elt in elements) {
        if (elt.name.startsWith("a")) {
            result.add(elt)
        }
    }

    return result
}