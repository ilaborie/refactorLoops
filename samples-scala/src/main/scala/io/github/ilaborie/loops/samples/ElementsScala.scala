package io.github.ilaborie.loops.samples

import scala.util.Random

object ElementsScala {
  private val LOREM_ISPUM =
    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."

  def getSomeElementsScala(): List[ElementScala] = {
    val array = LOREM_ISPUM.split("[ ,.]")
    Random.shuffle {
      array
        .filterNot(_.isEmpty)
        .map(_.toLowerCase)
        .map(ElementScala.apply)
        .toList
    }
  }
}