package io.github.ilaborie.loops.samples.recursion

import io.github.ilaborie.loops.samples.ElementScala
import io.github.ilaborie.loops.samples.ElementsScala.getSomeElementsScala

import scala.annotation.tailrec

object AccumulateTrScala {

  def main(args: Array[String]): Unit = {
    val elements = getSomeElementsScala()
    val result = accumulate(elements)
    println(result)
  }

  def accumulate(elements: List[ElementScala]): Int = {
    @tailrec
    def aux(elements: List[ElementScala], acc: Int): Int = {
      if (elements.isEmpty) {
        return acc
      }

      val head :: tail = elements

      val count = head.name.length
      aux(tail, acc + count)
    }

    aux(elements, 0)
  }

  def accumulateAlt(elements: List[ElementScala]): Int = {
    @tailrec
    def aux(elements: List[ElementScala], acc: Int): Int =
      if (elements.isEmpty) acc
      else aux(elements.tail, acc + elements.head.name.length)

    aux(elements, 0)
  }

}