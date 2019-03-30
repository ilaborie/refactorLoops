package io.github.ilaborie.loops.samples.recursion


import io.github.ilaborie.loops.samples.ElementScala
import io.github.ilaborie.loops.samples.ElementsScala.getSomeElementsScala

object FilterScala {

  def main(args: Array[String]): Unit = {
    val elements = getSomeElementsScala()
    val result = filter(elements)
    result.foreach(println(_))
  }

  def filter(elements: List[ElementScala]): List[ElementScala] = {
    if (elements.isEmpty) {
      return Nil
    }

    val head :: tail = elements

    val filterTail = filter(tail)

    if (head.name.startsWith("a")) {
      head :: filterTail
    } else {
      filterTail
    }
  }

  def filterAlt(elements: List[ElementScala]): List[ElementScala] =
    if (elements.isEmpty)
      Nil
    else if (elements.head.name.startsWith("a"))
      elements.head :: filterAlt(elements.tail)
    else
      filterAlt(elements.tail)

}