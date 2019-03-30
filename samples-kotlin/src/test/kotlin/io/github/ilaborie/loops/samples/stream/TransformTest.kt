package io.github.ilaborie.loops.samples.stream

import io.github.ilaborie.loops.samples.ElementKt
import org.junit.Assert.assertEquals
import org.junit.Test

class TransformTest {

    private fun test(func: (List<ElementKt>) -> List<String>) {
        val elements = listOf(
            ElementKt("a"),
            ElementKt("b"),
            ElementKt("aa")
        )

        val result = func(elements)

        assertEquals(listOf("a \\o/", "b \\o/", "aa \\o/"), result)
    }


    @Test
    fun for_should_transform() {
        test { io.github.ilaborie.loops.samples.anatomy.transform(it) }
    }

    @Test
    fun recursion_should_transform() {
        test { io.github.ilaborie.loops.samples.recursion.transform(it) }
    }

    @Test
    fun recursion_should_transform_alt() {
        test { io.github.ilaborie.loops.samples.recursion.transformAlt(it) }
    }

    @Test
    fun tail_recursion_should_transform() {
        test { io.github.ilaborie.loops.samples.recursion.transformTR(it) }
    }

    @Test
    fun tail_recursion_should_transform_alt() {
        test { io.github.ilaborie.loops.samples.recursion.transformTRAlt(it) }
    }

    @Test
    fun stream_should_transform() {
        test { io.github.ilaborie.loops.samples.stream.transform(it) }
    }
}
