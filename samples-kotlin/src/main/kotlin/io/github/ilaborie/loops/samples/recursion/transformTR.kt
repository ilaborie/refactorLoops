package io.github.ilaborie.loops.samples.recursion

import io.github.ilaborie.loops.samples.ElementKt
import io.github.ilaborie.loops.samples.getSomeElementsKt


fun main() {
    val elements = getSomeElementsKt()
    val result = transformTR(elements)
    result.forEach { println(it) }
}

fun transformTR(elements: List<ElementKt>): List<String> {
    tailrec fun aux(elements: List<ElementKt>, acc: List<String>): List<String> {
        if (elements.isEmpty()) {
            return acc
        }

        val head = elements.first()
        val tail = elements.drop(1)

        val transformed = head.name + " \\o/"
        return aux(tail, acc + listOf(transformed))
    }

    return aux(elements, emptyList())
}

fun transformTRAlt(elements: List<ElementKt>): List<String> {
    tailrec fun aux(elements: List<ElementKt>, acc: List<String>): List<String> =
        if (elements.isEmpty()) acc
        else aux(elements.drop(1), acc + (elements.first().name + " \\o/"))

    return aux(elements, emptyList())
}