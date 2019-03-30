package io.github.ilaborie.loops.samples.recursion


import io.github.ilaborie.loops.samples.ElementScala
import io.github.ilaborie.loops.samples.ElementsScala.getSomeElementsScala

import scala.annotation.tailrec

object TransformTrScala {

  def main(args: Array[String]): Unit = {
    val elements = getSomeElementsScala()
    val result = transform(elements)
    result.foreach(println(_))
  }


  def transform(elements: List[ElementScala]): List[String] = {
    @tailrec
    def aux(elements: List[ElementScala], acc: List[String]): List[String] = {
      if (elements.isEmpty) {
        return acc
      }

      val head :: tail = elements
      val transformed = head.name + " \\o/"

      aux(tail, transformed :: acc)
    }

    aux(elements, Nil).reverse
  }

  def transformAlt(elements: List[ElementScala]): List[String] = {
    @tailrec
    def aux(elements: List[ElementScala], acc: List[String]): List[String] =
      if (elements.isEmpty) acc
      else aux(elements.tail, (elements.head.name + " \\o/") :: acc)

    aux(elements, Nil).reverse
  }
}