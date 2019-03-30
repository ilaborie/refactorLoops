package io.github.ilaborie.loops.samples.stream


import io.github.ilaborie.loops.samples.ElementScala
import io.github.ilaborie.loops.samples.ElementsScala.getSomeElementsScala

object NestScala {

  def main(args: Array[String]): Unit = {
    val elements = getSomeElementsScala()
    val result = nest(elements)
    result.foreach(println(_))
  }

  def nest(elements: List[ElementScala]): List[String] =
    elements.flatMap { elt1 => elements.map(elt2 => elt1.name -> elt2.name) }
      .filterNot { case (name1, name2) => name1.equals(name2) }
      .filter { case (name1, name2) => name1.length == name2.length }
      .map { case (name1, name2) => List(name1, name2).mkString("-") }

  def nestView(elements: List[ElementScala]): List[String] =
    elements.view
      .flatMap { elt1 => elements.map(elt2 => elt1.name -> elt2.name) }
      .filterNot { case (name1, name2) => name1.equals(name2) }
      .filter { case (name1, name2) => name1.length == name2.length }
      .map { case (name1, name2) => List(name1, name2).mkString("-") }
      .toList

}