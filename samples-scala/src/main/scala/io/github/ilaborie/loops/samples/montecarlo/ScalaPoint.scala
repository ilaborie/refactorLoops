package io.github.ilaborie.loops.samples.montecarlo

import java.util.SplittableRandom

import scala.util.Random

case class ScalaPoint(x: Double, y: Double) {
  def inCircle(): Boolean =
    x * x + y * y <= 1
}

object ScalaPoint {

  private val rnd = new Random(0)
  def newPoint(): ScalaPoint =
    ScalaPoint(rnd.nextDouble(), rnd.nextDouble())

  private val rnd2 = new SplittableRandom(0)
  def newPoint2(): ScalaPoint =
    ScalaPoint(rnd2.nextDouble(), rnd2.nextDouble())


  def compute(count: Int, inCircle: Int): Double =
    inCircle.toDouble / count * 4

}
