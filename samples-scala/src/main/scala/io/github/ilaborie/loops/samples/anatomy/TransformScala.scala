package io.github.ilaborie.loops.samples.anatomy


import io.github.ilaborie.loops.samples.ElementScala
import io.github.ilaborie.loops.samples.ElementsScala.getSomeElementsScala

import scala.collection.mutable

object TransformScala {

  def main(args: Array[String]): Unit = {
    val elements = getSomeElementsScala()
    val result = transform(elements)
    result.foreach(println(_))
  }

  def transform(elements: List[ElementScala]): List[String] = {
    val result = mutable.MutableList[String]()

    for (elt <- elements) {
      val transformed = elt.name + " \\o/"
      transformed +=: result
    }

    result.reverse.toList
  }

}