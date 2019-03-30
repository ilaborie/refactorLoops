package io.github.ilaborie.loops.samples.stream


import io.github.ilaborie.loops.samples.ElementScala
import io.github.ilaborie.loops.samples.ElementsScala.getSomeElementsScala

object FilterScala {

  def main(args: Array[String]): Unit = {
    val elements = getSomeElementsScala()
    val result = filter(elements)
    result.foreach(println(_))
  }

  def filter(elements: List[ElementScala]): List[ElementScala] =
    elements.filter(elt => elt.name.startsWith("a"))

}