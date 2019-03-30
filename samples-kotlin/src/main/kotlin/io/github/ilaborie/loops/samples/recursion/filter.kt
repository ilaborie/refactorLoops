package io.github.ilaborie.loops.samples.recursion

import io.github.ilaborie.loops.samples.ElementKt
import io.github.ilaborie.loops.samples.getSomeElementsKt


fun main() {
    val elements = getSomeElementsKt()
    val result = filter(elements)
    result.forEach { println(it) }
}

fun filter(elements: List<ElementKt>): List<ElementKt> {
    if (elements.isEmpty()) {
        return emptyList()
    }

    val head = elements.first()
    val tail = elements.drop(1)

    val filterTail = filter(tail)
    return if (head.name.startsWith("a")) {
        listOf(head) + filterTail
    } else {
        filterTail
    }
}

fun filterAlt(elements: List<ElementKt>): List<ElementKt> =
    when {
        elements.isEmpty()                    ->
            emptyList()
        elements.first().name.startsWith("a") ->
            listOf(elements.first()) + filterAlt(elements.drop(1))
        else                                  ->
            filterAlt(elements.drop(1))
    }
