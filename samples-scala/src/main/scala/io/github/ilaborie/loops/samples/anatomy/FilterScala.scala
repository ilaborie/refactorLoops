package io.github.ilaborie.loops.samples.anatomy

import io.github.ilaborie.loops.samples.ElementScala
import io.github.ilaborie.loops.samples.ElementsScala.getSomeElementsScala

import scala.collection.mutable

object FilterScala {

  def main(args: Array[String]): Unit = {
    val elements = getSomeElementsScala()
    val result = filter(elements)
    result.foreach(println(_))
  }

  def filter(elements: List[ElementScala]): List[ElementScala] = {
    val result = mutable.MutableList[ElementScala]()

    for (elt <- elements) {
      if (elt.name.startsWith("a")) {
        elt +=: result
      }
    }

    result.reverse.toList
  }

}