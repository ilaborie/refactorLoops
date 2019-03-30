package io.github.ilaborie.loops.samples.stream

import io.github.ilaborie.loops.samples.ElementKt
import org.junit.Assert.assertEquals
import org.junit.Test

class NestTest {

    private fun test(func: (List<ElementKt>) -> List<String>) {
        val elements = listOf(
            ElementKt("a"),
            ElementKt("b"),
            ElementKt("aa")
        )

        val result = func(elements)

        assertEquals(listOf("a-b", "b-a"), result)
    }


    @Test
    fun for_should_nest() {
        test { io.github.ilaborie.loops.samples.anatomy.nest(it) }
    }

    @Test
    fun stream_should_nest() {
        test { io.github.ilaborie.loops.samples.stream.nest(it) }
    }

    @Test
    fun stream_should_nest_seq() {
        test { io.github.ilaborie.loops.samples.stream.nestSeq(it) }
    }
}
