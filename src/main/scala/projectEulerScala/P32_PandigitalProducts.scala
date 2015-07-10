package main.scala.projectEulerScala

import scala.collection.mutable

// 45228
object P32_PandigitalProducts {
  def sliceMkStringToInt(seq: Seq[Int], from: Int, to: Int): Int = seq.slice(from, to).mkString("").toInt

  def result(): Int = {
    (1 to 5000).flatMap { a =>
      (a to 5000).filter { b =>
        (a.toString + b.toString + (a * b).toString).sorted == "123456789"
      }.map(b => a * b)
    }.distinct.sum
  }

  def brute(): Int = {
    val products = mutable.Set[Int]()
    (1 to 9).permutations.foreach { p =>
      (1 to p.size - 1).foreach { a =>
        (1 to p.size - a - 1).foreach { b =>
          val x = sliceMkStringToInt(p, 0, a)
          val y = sliceMkStringToInt(p, a, a + b)
          val z = sliceMkStringToInt(p, a + b, p.size)
          if (x * y == z) {
            println(x + " * " + y + " = " + z)
            products.add(z)
          }
        }
      }
    }
    products.sum
  }

  def euler32 = {
    def isProduct(s: String) = {
      val oneDigit = s.take(1).toInt
      val fourDigit = s.slice(1, 5).toInt
      val prod = s.drop(5).toInt

      val twoDigit = s.take(2).toInt
      val threeDigit = s.slice(2, 5).toInt

      oneDigit * fourDigit == prod || twoDigit * threeDigit == prod
    }
    (1 to 9).permutations
      .toStream
      .map(_.mkString)
      .filter(isProduct)
      .map(_.drop(5).toInt)
      .distinct
      .sum
  }

  def main(args: Array[String]) {
    println(result)
  }
}
