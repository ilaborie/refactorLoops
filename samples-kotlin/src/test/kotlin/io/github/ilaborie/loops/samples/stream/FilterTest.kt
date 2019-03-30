package io.github.ilaborie.loops.samples.stream

import io.github.ilaborie.loops.samples.ElementKt
import org.junit.Assert.assertEquals
import org.junit.Test

class FilterTest {

    private fun test(func: (List<ElementKt>) -> List<ElementKt>) {
        val elements = listOf(
            ElementKt("a"),
            ElementKt("b"),
            ElementKt("aa")
        )

        val result = func(elements)

        assertEquals(listOf(ElementKt("a"), ElementKt("aa")), result)
    }


    @Test
    fun for_should_filter() {
        test { io.github.ilaborie.loops.samples.anatomy.filter(it) }
    }

    @Test
    fun recursion_should_filter() {
        test { io.github.ilaborie.loops.samples.recursion.filter(it) }
    }

    @Test
    fun recursion_should_filter_alt() {
        test { io.github.ilaborie.loops.samples.recursion.filterAlt(it) }
    }

    @Test
    fun tail_recursion_should_filter() {
        test { io.github.ilaborie.loops.samples.recursion.filterTr(it) }
    }

    @Test
    fun tail_recursion_should_filter_alt() {
        test { io.github.ilaborie.loops.samples.recursion.filterTrAlt(it) }
    }

    @Test
    fun stream_should_filter() {
        test { io.github.ilaborie.loops.samples.stream.filter(it) }
    }
}
