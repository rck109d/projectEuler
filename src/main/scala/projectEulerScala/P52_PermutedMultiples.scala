package main.scala.projectEulerScala

import scala.collection.mutable

// 142857
object P52_PermutedMultiples {
  def countChars(n: Int): mutable.Map[Char, Int] = {
    val m = mutable.Map[Char, Int]().withDefaultValue(0)
    n.toString.foreach(c => m(c) += 1)
    m
  }
  def main(args: Array[String]) {
    val a = Stream.from(10).find { n =>
      val first = countChars(n)
      (2 to 6).forall(i => first == countChars(i * n))
    }.get
    println(a)
  }
}
