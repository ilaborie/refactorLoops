package io.github.ilaborie.loops.samples.anatomy

import io.github.ilaborie.loops.samples.ElementKt
import io.github.ilaborie.loops.samples.getSomeElementsKt


fun main() {
    val elements = getSomeElementsKt()
    val result = io.github.ilaborie.loops.samples.stream.nest(elements)
    result.forEach { println(it) }
}

fun nest(elements: List<ElementKt>): List<String> {
    val result = mutableListOf<String>()

    for (elt1 in elements) {
        for (elt2 in elements) {
            val name1 = elt1.name
            val name2 = elt2.name
            if (name1 != name2 && name1.length == name2.length) {
                result.add(arrayOf(name1, name2).joinToString("-"))
            }
        }
    }

    return result
}