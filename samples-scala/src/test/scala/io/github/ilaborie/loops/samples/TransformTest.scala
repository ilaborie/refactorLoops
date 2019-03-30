package io.github.ilaborie.loops.samples

import org.junit.Assert.assertEquals
import org.junit.Test

class TransformTest {


  private def test(func: List[ElementScala] => List[String]): Unit = {
    val elements = List(
      ElementScala("a"),
      ElementScala("b"),
      ElementScala("aa")
    )

    val result = func(elements)

    assertEquals(List("a \\o/", "b \\o/", "aa \\o/"), result)

  }

  @Test
  def for_should_transform(): Unit = {
    test {
      io.github.ilaborie.loops.samples.anatomy.TransformScala.transform
    }
  }

  @Test
  def recursion_should_transform(): Unit = {
    test {
      io.github.ilaborie.loops.samples.recursion.TransformScala.transform
    }
  }

  @Test
  def recursion_should_transform_alt(): Unit = {
    test {
      io.github.ilaborie.loops.samples.recursion.TransformScala.transformAlt
    }
  }

  @Test
  def tail_recursion_should_transform(): Unit = {
    test {
      io.github.ilaborie.loops.samples.recursion.TransformTrScala.transform
    }
  }

  @Test
  def tail_recursion_should_transform_alt(): Unit = {
    test {
      io.github.ilaborie.loops.samples.recursion.TransformTrScala.transformAlt
    }
  }

  @Test
  def stream_should_transform(): Unit = {
    test {
      io.github.ilaborie.loops.samples.stream.TransformScala.transform
    }
  }

}
