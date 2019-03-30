package io.github.ilaborie.loops.samples.anatomy


import io.github.ilaborie.loops.samples.ElementScala
import io.github.ilaborie.loops.samples.ElementsScala.getSomeElementsScala

import scala.collection.mutable

object NestScala {

  def main(args: Array[String]): Unit = {
    val elements = getSomeElementsScala()
    val result = nest(elements)
    result.foreach(println(_))
  }

  def nest(elements: List[ElementScala]): List[String] = {
    val result = mutable.MutableList[String]()

    for {
      elt1 <- elements
      elt2 <- elements
    } {
      val name1 = elt1.name
      val name2 = elt2.name
      if (!name1.equals(name2) && name1.length == name2.length) {
        List(name1, name2).mkString("-") +=: result
      }
    }

    result.reverse.toList
  }

}