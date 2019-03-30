package io.github.ilaborie.loops.samples.recursion

import io.github.ilaborie.loops.samples.ElementKt
import io.github.ilaborie.loops.samples.getSomeElementsKt


fun main() {
    val elements = getSomeElementsKt()
    val result = transform(elements)
    result.forEach { println(it) }
}

fun transform(elements: List<ElementKt>): List<String> {
    if (elements.isEmpty()) {
        return emptyList()
    }

    val head = elements.first()
    val tail = elements.drop(1)

    val transformed = head.name + " \\o/"
    val transformedTail = transform(tail)

    return listOf(transformed) + transformedTail
}

fun transformAlt(elements: List<ElementKt>): List<String> =
    if (elements.isEmpty())
        emptyList()
    else
        listOf(elements.first().name + " \\o/") + transform(elements.drop(1))
