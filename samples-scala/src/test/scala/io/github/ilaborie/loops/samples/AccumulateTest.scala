package io.github.ilaborie.loops.samples

import org.junit.Assert.assertEquals
import org.junit.Test

class AccumulateTest {


  private def test(func: List[ElementScala] => Int): Unit = {
    val elements = List(
      ElementScala("1"),
      ElementScala("_2"),
      ElementScala("__3")
    )
    val result = func(elements)
    assertEquals(6, result.toLong)
  }

  @Test
  def for_should_accumulate(): Unit = {
    test {
      io.github.ilaborie.loops.samples.anatomy.AccumulateScala.accumulate
    }
  }

  @Test
  def recursion_should_accumulate(): Unit = {
    test {
      io.github.ilaborie.loops.samples.recursion.AccumulateScala.accumulate
    }
  }

  @Test
  def recursion_should_accumulate_alt(): Unit = {
    test {
      io.github.ilaborie.loops.samples.recursion.AccumulateScala.accumulateAlt
    }
  }

  @Test
  def tail_recursion_should_accumulate(): Unit = {
    test {
      io.github.ilaborie.loops.samples.recursion.AccumulateTrScala.accumulate
    }
  }

  @Test
  def tail_recursion_should_accumulate_alt(): Unit = {
    test {
      io.github.ilaborie.loops.samples.recursion.AccumulateTrScala.accumulateAlt
    }
  }

  @Test
  def stream_should_accumulate(): Unit = {
    test {
      io.github.ilaborie.loops.samples.stream.AccumulateScala.accumulate
    }
  }

}
