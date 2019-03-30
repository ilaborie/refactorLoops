package io.github.ilaborie.loops.samples.stream

import io.github.ilaborie.loops.samples.ElementKt
import io.github.ilaborie.loops.samples.getSomeElementsKt


fun main() {
    val elements = getSomeElementsKt()
    val result = nest(elements)
    result.forEach { println(it) }
}

fun nest(elements: List<ElementKt>): List<String> =
    elements
        .flatMap { elt1 -> elements.map { elt2 -> elt1.name to elt2.name } }
        .filter { (name1, name2) -> name1 != name2 }
        .filter { (name1, name2) -> name1.length == name2.length }
        .map { (name1, name2) -> arrayOf(name1, name2).joinToString("-") }


fun nestSeq(elements: List<ElementKt>): List<String> =
    elements.asSequence()
        .flatMap { elt1 -> elements.asSequence().map { elt2 -> elt1.name to elt2.name } }
        .filter { (name1, name2) -> name1 != name2 }
        .filter { (name1, name2) -> name1.length == name2.length }
        .map { (name1, name2) -> arrayOf(name1, name2).joinToString("-") }
        .toList()