package io.github.ilaborie.loops.samples

import org.junit.Assert.assertEquals
import org.junit.Test

class FilterTest {


  private def test(func: List[ElementScala] => List[ElementScala]): Unit = {
    val elements = List(
      ElementScala("a"),
      ElementScala("b"),
      ElementScala("aa")
    )

    val result = func(elements)

    assertEquals(List(ElementScala("a"), ElementScala("aa")), result)

  }

  @Test
  def for_should_filter(): Unit = {
    test {
      io.github.ilaborie.loops.samples.anatomy.FilterScala.filter
    }
  }

  @Test
  def recursion_should_filter(): Unit = {
    test {
      io.github.ilaborie.loops.samples.recursion.FilterScala.filter
    }
  }

  @Test
  def recursion_should_filter_alt(): Unit = {
    test {
      io.github.ilaborie.loops.samples.recursion.FilterScala.filterAlt
    }
  }

  @Test
  def tail_recursion_should_filter(): Unit = {
    test {
      io.github.ilaborie.loops.samples.recursion.FilterTrScala.filter
    }
  }

  @Test
  def tail_recursion_should_filter_alt(): Unit = {
    test {
      io.github.ilaborie.loops.samples.recursion.FilterTrScala.filterAlt
    }
  }

  @Test
  def stream_should_filter(): Unit = {
    test {
      io.github.ilaborie.loops.samples.stream.FilterScala.filter
    }
  }

}
