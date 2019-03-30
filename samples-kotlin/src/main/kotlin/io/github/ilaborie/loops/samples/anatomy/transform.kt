package io.github.ilaborie.loops.samples.anatomy

import io.github.ilaborie.loops.samples.ElementKt
import io.github.ilaborie.loops.samples.getSomeElementsKt


fun main() {
    val elements = getSomeElementsKt()
    val result = io.github.ilaborie.loops.samples.stream.transform(elements)
    result.forEach { println(it) }
}

fun transform(elements: List<ElementKt>): List<String> {
    val result = mutableListOf<String>()

    for (elt in elements) {
        val transformed = elt.name + " \\o/"
        result.add(transformed)
    }

    return result
}