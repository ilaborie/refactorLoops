package io.github.ilaborie.loops.samples.anatomy

import io.github.ilaborie.loops.samples.ElementScala
import io.github.ilaborie.loops.samples.ElementsScala.getSomeElementsScala

object AccumulateScala {

  def main(args: Array[String]): Unit = {
    val elements = getSomeElementsScala()
    val result = accumulate(elements)
    println(result)
  }

  def accumulate(elements: List[ElementScala]): Int = {
    var count = 0

    for (elt <- elements) {
      val eltSize = elt.name.length
      count += eltSize
    }

    count
  }

}