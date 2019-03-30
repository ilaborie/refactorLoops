package io.github.ilaborie.loops.samples

import io.github.ilaborie.loops.samples.montecarlo.MonteCarloScala._
import org.junit.Assert.assertEquals
import org.junit.Test

class MonteCarloScalaTest {

  private def test(func: Int => Double): Unit = {
    val count = 1000000
    val result = func(count)
    assertEquals(Math.PI, result, 1e-2)
  }

  @Test
  def for_should_compute_pi(): Unit = {
    test(monteCarloFor)
  }

  @Test
  def recursion_should_compute_pi(): Unit = {
    test(monteCarloRecursion)
  }

  @Test
  def collection_should_compute_pi(): Unit = {
    test(monteCarloCollection)
  }

  @Test
  def collection_par_should_compute_pi(): Unit = {
    test(monteCarloCollectionParallel)
  }


  @Test
  def stream_should_compute_pi(): Unit = {
    test(monteCarloStream)
  }


  @Test
  def stream_parallel_should_compute_pi(): Unit = {
    test(monteCarloStreamParallel)
  }

}
