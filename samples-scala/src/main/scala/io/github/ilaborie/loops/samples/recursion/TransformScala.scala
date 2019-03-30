package io.github.ilaborie.loops.samples.recursion


import io.github.ilaborie.loops.samples.ElementScala
import io.github.ilaborie.loops.samples.ElementsScala.getSomeElementsScala

object TransformScala {

  def main(args: Array[String]): Unit = {
    val elements = getSomeElementsScala()
    val result = transform(elements)
    result.foreach(println(_))
  }


  def transform(elements: List[ElementScala]): List[String] = {
    if (elements.isEmpty) {
      return Nil
    }

    val head :: tail = elements
    val transformed = head.name + " \\o/"
    val transformedTail = transform(tail)

    transformed :: transformedTail
  }

  def transformAlt(elements: List[ElementScala]): List[String] =
    if (elements.isEmpty) Nil
    else (elements.head.name + " \\o/") :: transform(elements.tail)

}