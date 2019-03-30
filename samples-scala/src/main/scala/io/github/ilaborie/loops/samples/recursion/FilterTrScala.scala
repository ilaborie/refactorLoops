package io.github.ilaborie.loops.samples.recursion


import io.github.ilaborie.loops.samples.ElementScala
import io.github.ilaborie.loops.samples.ElementsScala.getSomeElementsScala

import scala.annotation.tailrec

object FilterTrScala {

  def main(args: Array[String]): Unit = {
    val elements = getSomeElementsScala()
    val result = filter(elements)
    result.foreach(println(_))
  }

  def filter(elements: List[ElementScala]): List[ElementScala] = {
    @tailrec
    def aux(elements: List[ElementScala], acc: List[ElementScala]): List[ElementScala] = {
      if (elements.isEmpty) {
        return acc
      }

      val head :: tail = elements

      if (head.name.startsWith("a")) {
        aux(tail, head :: acc)
      } else {
        aux(tail, acc)
      }
    }

    aux(elements, Nil).reverse
  }

  def filterAlt(elements: List[ElementScala]): List[ElementScala] = {
    @tailrec
    def aux(elements: List[ElementScala], acc: List[ElementScala]): List[ElementScala] =
      if (elements.isEmpty)
        acc
      else if (elements.head.name.startsWith("a"))
        aux(elements.tail, elements.head :: acc)
      else
        aux(elements.tail, acc)

    aux(elements, Nil).reverse
  }

  def factorial(n: Int): Int = {
    @tailrec
    def aux(n: Int, acc: Int): Int =
      if (n < 2) acc
      else aux(n - 1, n * acc)

    aux(n, 1)
  }
}