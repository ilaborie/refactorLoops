package io.github.ilaborie.loops.samples.recursion

import io.github.ilaborie.loops.samples.ElementKt
import io.github.ilaborie.loops.samples.getSomeElementsKt


fun main() {
    val elements = getSomeElementsKt()
    val result = accumulateTR(elements)
    println(result)
}

fun accumulateTR(elements: List<ElementKt>): Int {
    tailrec fun aux(elements: List<ElementKt>, acc: Int): Int {
        if (elements.isEmpty()) {
            return acc
        }

        val head = elements.first()
        val tail = elements.drop(1)

        val count = head.name.length
        return aux(tail, acc + count)
    }
    return aux(elements, 0)
}

fun accumulateTRAlt(elements: List<ElementKt>): Int {
    tailrec fun aux(elements: List<ElementKt>, acc: Int): Int =
        if (elements.isEmpty()) acc
        else aux(elements.drop(1), acc + elements.first().name.length)

    return aux(elements, 0)
}
