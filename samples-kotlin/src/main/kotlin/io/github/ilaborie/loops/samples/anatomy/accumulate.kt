package io.github.ilaborie.loops.samples.anatomy

import io.github.ilaborie.loops.samples.ElementKt
import io.github.ilaborie.loops.samples.getSomeElementsKt


fun main() {
    val elements = getSomeElementsKt()
    val result = accumulate(elements)
    println(result)
}

fun accumulate(elements: List<ElementKt>): Int {
    var count = 0

    for (elt in elements) {
        val eltSize = elt.name.length
        count += eltSize
    }

    return count
}