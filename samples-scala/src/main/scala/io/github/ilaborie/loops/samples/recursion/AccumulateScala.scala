package io.github.ilaborie.loops.samples.recursion

import io.github.ilaborie.loops.samples.ElementScala
import io.github.ilaborie.loops.samples.ElementsScala.getSomeElementsScala

object AccumulateScala {

  def main(args: Array[String]): Unit = {
    val elements = getSomeElementsScala()
    val result = accumulate(elements)
    println(result)
  }


  def accumulate(elements: List[ElementScala]): Int = {
    if (elements.isEmpty) {
      return 0
    }

    val head :: tail = elements

    val count = head.name.length
    val countTail = accumulate(tail)
    count + countTail
  }

  def accumulateAlt(elements: List[ElementScala]): Int =
    if (elements.isEmpty) 0
    else elements.head.name.length + accumulateAlt(elements.tail)

}