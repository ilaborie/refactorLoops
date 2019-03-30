package io.github.ilaborie.loops.samples.stream


import io.github.ilaborie.loops.samples.ElementScala
import io.github.ilaborie.loops.samples.ElementsScala.getSomeElementsScala

object TransformScala {

  def main(args: Array[String]): Unit = {
    val elements = getSomeElementsScala()
    val result = transform(elements)
    result.foreach(println(_))
  }

  def transform(elements: List[ElementScala]): List[String] =
    elements.map(elt => elt.name + " \\o/")

}