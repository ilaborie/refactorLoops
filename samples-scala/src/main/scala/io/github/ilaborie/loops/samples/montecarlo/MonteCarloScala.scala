package io.github.ilaborie.loops.samples.montecarlo

import java.text.NumberFormat

import scala.annotation.tailrec

object MonteCarloScala {
  import ScalaPoint.{compute, newPoint, newPoint2}

  def main(args: Array[String]): Unit = {
    val format = NumberFormat.getIntegerInstance()
    (2 to 10)
      .map(e => Math.pow(10.0, e.toDouble).toInt)
      .foreach { count =>
        System.out.printf("Compute with %s ...%n", format.format(count.toLong))
        val pi = monteCarloStreamParallel(count)
        println(s"Result: $pi")
      }
  }


  // For Loop
  def monteCarloFor(count: Int): Double = {
    var inCircle = 0
    for (_ <- 1 to count) {
      val p = newPoint()

      if (p.inCircle()) {
        inCircle += 1
      }
    }
    compute(count, inCircle)
  }

  // Recursion
  def monteCarloRecursion(count: Int): Double = {
    @tailrec
    def aux(count: Int, inCircle: Int): Int =
      if (count == 0) inCircle
      else {
        val p = newPoint()
        aux(count - 1, inCircle + (if (p.inCircle()) 1 else 0))
      }

    val inCircle = aux(count, 0)
    compute(count, inCircle)
  }

  // Collections
  def monteCarloCollection(count: Int): Double = {
    val inCircle = (1 to count)
      .map(_ => newPoint())
      .count(_.inCircle())

    compute(count, inCircle)
  }


  def monteCarloCollectionParallel(count: Int): Double = {
    val inCircle = (1 to count).par
      .map(_ => newPoint())
      .count(_.inCircle())

    compute(count, inCircle)
  }

  def monteCarloCollectionParallel2(count: Int): Double = {
    val inCircle = (1 to count).par
      .map(_ => newPoint2())
      .count(_.inCircle())

    compute(count, inCircle)
  }

  // Stream

  def monteCarloStream(count: Int): Double = {
    val inCircle = Stream.fill(count) {
      newPoint()
    }
      .count(_.inCircle())

    compute(count, inCircle)
  }

  def monteCarloStreamParallel(count: Int): Double = {
    val inCircle = Stream.fill(count) {
      newPoint()
    }
      .par
      .count(_.inCircle())

    compute(count, inCircle)
  }

  def monteCarloStreamParallel2(count: Int): Double = {
    val inCircle = Stream.fill(count) {
      newPoint2()
    }
      .par
      .count(_.inCircle())

    compute(count, inCircle)
  }

}
