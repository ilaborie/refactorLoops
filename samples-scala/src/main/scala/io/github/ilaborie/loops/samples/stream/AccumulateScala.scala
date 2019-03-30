package io.github.ilaborie.loops.samples.stream


import io.github.ilaborie.loops.samples.ElementScala
import io.github.ilaborie.loops.samples.ElementsScala.getSomeElementsScala

object AccumulateScala {

  def main(args: Array[String]): Unit = {
    val elements = getSomeElementsScala()
    val result = accumulate(elements)
    println(result)
  }

  def accumulate(elements: List[ElementScala]): Int =
    elements.foldLeft(0) { (acc, elt) =>
      acc + elt.name.length
    }


}