package io.github.ilaborie.loops.samples.stream

import io.github.ilaborie.loops.samples.ElementKt
import org.junit.Assert.assertEquals
import org.junit.Test

class AccumulateTest {

    private fun test(func: (List<ElementKt>) -> Int) {
        val elements = listOf(
            ElementKt("1"),
            ElementKt("_2"),
            ElementKt("__3")
        )
        val result = func(elements)
        assertEquals(6, result.toLong())
    }

    @Test
    fun for_should_accumulate() {
        test { io.github.ilaborie.loops.samples.anatomy.accumulate(it) }
    }

    @Test
    fun recursion_should_accumulate() {
        test { io.github.ilaborie.loops.samples.recursion.accumulate(it) }
    }

    @Test
    fun recursion_should_accumulate_alt() {
        test { io.github.ilaborie.loops.samples.recursion.accumulateAlt(it) }
    }

    @Test
    fun tail_recursion_should_accumulate() {
        test { io.github.ilaborie.loops.samples.recursion.accumulateTR(it) }
    }
    @Test
    fun tail_recursion_should_accumulate_alt() {
        test { io.github.ilaborie.loops.samples.recursion.accumulateTRAlt(it) }
    }

    @Test
    fun stream_should_accumulate() {
        test { io.github.ilaborie.loops.samples.stream.accumulate(it) }
    }

    @Test
    fun stream_should_accumulate_alt() {
        test { io.github.ilaborie.loops.samples.stream.accumulateAlt(it) }
    }

}
