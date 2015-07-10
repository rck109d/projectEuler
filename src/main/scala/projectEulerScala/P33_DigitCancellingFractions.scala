package main.scala.projectEulerScala

import scala.annotation.tailrec
import scala.collection.mutable

// 100
object P33_DigitCancellingFractions {
  @tailrec
  def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  def firstTry = {
    val r = 10 to 99
    val special = mutable.Set[(Int, Int)]()
    (for (a <- r; b <- r) yield (a, b)).foreach { case (top, bot) =>
      val topString = top.toString
      val botString = bot.toString
      val topLeft = topString.take(1)
      val topRight = topString.takeRight(1)
      val botLeft = botString.take(1)
      val botRight = botString.takeRight(1)
      if (
        top != bot &&
          topRight == botLeft &&
          topRight != "0" &&
          Integer.parseInt(topLeft, 10) * 1.0 / Integer.parseInt(botRight, 10) == 1.0 * top / bot
      ) {
        println("found " + (top, bot))
        special += ((top, bot))
      }
    }
    val product = (special.map(_._1).product, special.map(_._2).product)
    println("unreduced product fraction: " + product)
    println("reduced product denominator: " + product._2 / gcd(product._1, product._2))
  }

  def euler33 = {
    val prod = (for {i <- 1 until 10
                     d <- 1 until i
                     n <- 1 until d
                     if (n * 10 + i) * d == n * (i * 10 + d)
    } yield (n, d)) reduce { (a, b) => (a._1 * b._1, a._2 * b._2) }
    prod._2 / gcd(prod._1, prod._2)
  }

  def main(args: Array[String]) {
    println(euler33)
  }
}
