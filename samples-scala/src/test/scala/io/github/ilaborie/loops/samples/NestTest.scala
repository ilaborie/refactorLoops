package io.github.ilaborie.loops.samples

import org.junit.Assert.assertEquals
import org.junit.Test

class NestTest {


  private def test(func: List[ElementScala] => List[String]): Unit = {
    val elements = List(
      ElementScala("a"),
      ElementScala("b"),
      ElementScala("aa")
    )

    val result = func(elements)

    assertEquals(List("a-b", "b-a"), result)
  }

  @Test
  def for_should_nest(): Unit = {
    test {
      io.github.ilaborie.loops.samples.anatomy.NestScala.nest
    }
  }

  @Test
  def stream_should_nest(): Unit = {
    test {
      io.github.ilaborie.loops.samples.stream.NestScala.nest
    }
  }


  @Test
  def stream_should_nest_view(): Unit = {
    test {
      io.github.ilaborie.loops.samples.stream.NestScala.nestView
    }
  }

}
