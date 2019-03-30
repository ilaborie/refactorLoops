package io.github.ilaborie.loops.samples.recursion

import io.github.ilaborie.loops.samples.ElementKt
import io.github.ilaborie.loops.samples.getSomeElementsKt


fun main() {
    val elements = getSomeElementsKt()
    val result = filterTr(elements)
    result.forEach { println(it) }
}

fun filterTr(elements: List<ElementKt>): List<ElementKt> {
    tailrec fun aux(elements: List<ElementKt>, acc: List<ElementKt>): List<ElementKt> {
        if (elements.isEmpty()) {
            return acc
        }

        val head = elements.first()
        val tail = elements.drop(1)

        return if (head.name.startsWith("a")) {
            aux(tail, acc + head)
        } else {
            aux(tail, acc)
        }
    }

    return aux(elements, emptyList())
}

fun filterTrAlt(elements: List<ElementKt>): List<ElementKt> {
    tailrec fun aux(elements: List<ElementKt>, acc: List<ElementKt>): List<ElementKt> =
        when {
            elements.isEmpty()                    ->
                acc
            elements.first().name.startsWith("a") ->
                aux(elements.drop(1), acc + elements.first())
            else                                  ->
                aux(elements.drop(1), acc)
        }

    return aux(elements, emptyList())
}
