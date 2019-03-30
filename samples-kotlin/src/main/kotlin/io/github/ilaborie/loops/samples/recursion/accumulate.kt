package io.github.ilaborie.loops.samples.recursion

import io.github.ilaborie.loops.samples.ElementKt
import io.github.ilaborie.loops.samples.stream.accumulate
import io.github.ilaborie.loops.samples.getSomeElementsKt


fun main() {
    val elements = getSomeElementsKt()
    val result = accumulate(elements)
    println(result)
}

fun accumulate(elements: List<ElementKt>): Int {
    if (elements.isEmpty()) {
        return 0
    }

    val head = elements.first()
    val tail = elements.drop(1)

    val count = head.name.length
    val countTail = accumulate(tail)
    return count + countTail
}

fun accumulateAlt(elements: List<ElementKt>): Int =
    if (elements.isEmpty()) 0
    else elements.first().name.length + accumulateAlt(elements.drop(1))
